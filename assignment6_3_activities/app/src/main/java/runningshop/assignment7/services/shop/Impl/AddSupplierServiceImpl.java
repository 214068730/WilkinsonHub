package runningshop.assignment7.services.shop.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.Serializable;

import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.shop.Supplier;
import runningshop.assignment7.repository.shop.Impl.SupplierRepositoryImpl;
import runningshop.assignment7.repository.shop.SupplierRepository;
import runningshop.assignment7.services.shop.AddSupplierService;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class AddSupplierServiceImpl extends IntentService implements AddSupplierService {


    private final SupplierRepository repository;
    private static AddSupplierServiceImpl service = null;

    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String ACTION_UPDATE ="package runningshop.assignment7.services.customer.Impl.action.UPDATE";
    private static final String ACTION_DELETE ="package runningshop.assignment7.services.customer.Impl.action.DELETE";


    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "package runningshop.assignment7.services.customer.Impl.extra.UPDATE";
    private static final String EXTRA_DELETE= "package runningshop.assignment7.services.customer.Impl.extra.DELETE";

    public AddSupplierServiceImpl() {
        super("AddSupplierServiceImpl");
        repository = new SupplierRepositoryImpl(App.getAppContext());
    }


    public static AddSupplierServiceImpl getInstance(){
         if(service == null)
             service = new AddSupplierServiceImpl();
        return service;
    }



    @Override
    public void addService(Context context, Supplier supplier) {
        Intent intent = new Intent(context,AddSupplierServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,supplier);
        context.startService(intent);
    }

    @Override
    public void updateSupplier(Context context, Supplier supplier) {
        Intent intent = new Intent(context,AddSupplierServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE,supplier);
        context.startService(intent);
    }

    @Override
    public void deleteSupplier(Context context, Supplier supplier) {
        Intent intent = new Intent(context,AddSupplierServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        intent.putExtra(EXTRA_DELETE,supplier);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
       if(intent != null) {
           final String action = intent.getAction();
           if(ACTION_ADD.equals(action)) {
               Supplier supplierResources = (Supplier) intent.getSerializableExtra(EXTRA_ADD);
               add(supplierResources);
           }
           else
               if(ACTION_UPDATE.equals(action)){
                   Supplier updateSupplier = (Supplier) intent.getSerializableExtra(EXTRA_UPDATE);
                   update(updateSupplier);
               }
           else
               if(ACTION_DELETE.equals(action)){
                   Supplier deleteSupplier = (Supplier) intent.getSerializableExtra(EXTRA_DELETE);
                   delete(deleteSupplier);
               }
       }
    }

    private void update(Supplier supplier){
        try{
            repository.update(supplier);
            Toast.makeText(App.getAppContext(),"Supplier has been updated",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void delete(Supplier supplier){
        try{
            repository.delete(supplier);
            Toast.makeText(App.getAppContext(),"Supplier has been updated",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void add(Supplier supplier){
        try{
            Supplier addSupplier = new Supplier.BuilderSupplier()
                    .supplierID(supplier.getSupplierID())
                    .supplierName(supplier.getSupplierName())
                    .supplierAddress(supplier.getSupplierAddress())
                    .build();

            repository.save(addSupplier);
            Toast.makeText(App.getAppContext(),"Supplier has been added",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
