package runningshop.orderingSystem.activities.customers;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

import runningshop.orderingSystem.R;
import runningshop.orderingSystem.activities.CustomerMenu;
import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.repository.customer.CustomerRepository;
import runningshop.orderingSystem.repository.customer.Impl.CustomerRepositoryImpl;

public class ViewCustomer extends AppCompatActivity {
    GridView gridView;
    private ArrayAdapter adapter;
    private ArrayList<String> customerArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        CustomerRepository repo = new CustomerRepositoryImpl(App.getAppContext());
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
            gridView = (GridView) findViewById(R.id.gridView);
            gridView.setAdapter(adapter);
        }
    }

    public void onHome(View view){
        Intent i = new Intent(this,CustomerMenu.class);
        startActivity(i);
        finish();
    }


}
