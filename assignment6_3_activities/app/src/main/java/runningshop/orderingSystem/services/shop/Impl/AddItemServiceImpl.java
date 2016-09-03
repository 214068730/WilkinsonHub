package runningshop.orderingSystem.services.shop.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.domain.shop.Item;
import runningshop.orderingSystem.repository.shop.Impl.ItemRepositoryImpl;
import runningshop.orderingSystem.repository.shop.ItemRepository;
import runningshop.orderingSystem.services.shop.AddItemService;

/**
 * Created by Siraaj on 05/08/2016.
 */
public class AddItemServiceImpl extends IntentService implements AddItemService {

    private final ItemRepository repository;
    private static AddItemServiceImpl service = null;

    private static final String ACTION_ADD ="package runningshop.assignment7.services.customer.Impl.action.ADD";
    private static final String ACTION_UPDATE ="package runningshop.assignment7.services.customer.Impl.action.UPDATE";
    private static final String ACTION_DELETE ="package runningshop.assignment7.services.customer.Impl.action.DELETE";


    private static final String EXTRA_ADD = "package runningshop.assignment7.services.customer.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "package runningshop.assignment7.services.customer.Impl.extra.UPDATE";
    private static final String EXTRA_DELETE = "package runningshop.assignment7.services.customer.Impl.extra.DELETE";


    public AddItemServiceImpl() {
        super("AddItemServiceImpl");
        repository = new ItemRepositoryImpl(App.getAppContext());
    }

    public static AddItemServiceImpl getInstance(){
        if(service == null)
            service = new AddItemServiceImpl();
        return service;
    }

    @Override
    public void addItem(Context context, Item item) {
        Intent intent = new Intent(context,AddItemServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,item);
        context.startService(intent);
    }

    @Override
    public void updateItem(Context context, Item item) {
        Intent intent = new Intent(context,AddItemServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE,item);
        context.startService(intent);
    }

    @Override
    public void deleteItem(Context context, Item item) {
        Intent intent = new Intent(context,AddItemServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        intent.putExtra(EXTRA_DELETE,item);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent != null) {
            final String action = intent.getAction();
            if(ACTION_ADD.equals(action)) {
                Item itemResources = (Item) intent.getSerializableExtra(EXTRA_ADD);
                add(itemResources);
            }
            else
                if(ACTION_UPDATE.equals(action)){
                    Item updateItem =(Item)intent.getSerializableExtra(EXTRA_UPDATE);
                    update(updateItem);
                }
            else
                    if(ACTION_DELETE.equals(action)){
                        Item deleteItem = (Item)intent.getSerializableExtra(EXTRA_DELETE);
                        delete(deleteItem);
                    }
        }
    }

    private void update(Item item){
        try{
            repository.update(item);
            Toast.makeText(App.getAppContext(),"Item has been updated",Toast.LENGTH_LONG).show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void delete(Item item){
        try{
            repository.delete(item);
            Toast.makeText(App.getAppContext(),"Item has been removed",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void add(Item item){
        try{
            Item addItem = new Item.ItemBuilder()
                    .itemCode(item.getItemCode())
                    .itemName(item.getItemName())
                    .build();
            repository.save(addItem);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
