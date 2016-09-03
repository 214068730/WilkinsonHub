package runningshop.orderingSystem.services.customer.Impl;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.Binder;
import android.os.IBinder;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.repository.customer.CustomerRepository;
import runningshop.orderingSystem.repository.customer.Impl.CustomerRepositoryImpl;
import runningshop.orderingSystem.services.customer.ViewCustomers;

public class ViewAllCustomers extends Service implements ViewCustomers {
    final private CustomerRepository repo;
    private static ViewAllCustomers service = null;
    private final IBinder localBinder = new ViewAllCustomersLocalBinder();

    public ViewAllCustomers() {
        repo = new CustomerRepositoryImpl(App.getAppContext());
    }

    public static ViewAllCustomers getInstance(){
        if(service == null)
            service = new ViewAllCustomers();
        return service;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    @Override
    public ArrayAdapter<String> displayAllCustomer() {
        ArrayAdapter adapter;
        ArrayList<String> customerArray;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        customerArray = new ArrayList<>();

        Cursor cursor = repo.selectAll();
        if (cursor.moveToNext()) {
            do {
                String id = String.valueOf(cursor.getLong(0));
                String name = cursor.getString(1);
                String postal = cursor.getString(2);
                String streetName = cursor.getString(3);
                String suburb = cursor.getString(4);

                customerArray.add(id);
                customerArray.add(name);
                customerArray.add(postal);
                customerArray.add(streetName);
                customerArray.add(suburb);

            } while (cursor.moveToNext());
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, customerArray);
            return (adapter);
        }
        else
        return null;
    }


    public class ViewAllCustomersLocalBinder extends Binder {
        public ViewAllCustomers getService(){

            return ViewAllCustomers.this;
        }
    }
}
