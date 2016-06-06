package runningshop.assignment7.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import runningshop.assignment7.R;
import runningshop.assignment7.conf.util.App;
import runningshop.assignment7.domain.customer.Customer;
import runningshop.assignment7.repository.customer.CustomerRepository;
import runningshop.assignment7.repository.customer.Impl.CustomerRepositoryImpl;

public class ViewCustomer extends AppCompatActivity {


    GridView gridView;
    CustomerRepository repo;

    private Set<Customer> customerSet;
    private ArrayAdapter adapter;
    private ArrayAdapter adapter1;
    private ListView listView;
    private String[] names;
    private String[] id;
    private ArrayList<String> customerArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer);

         repo = new CustomerRepositoryImpl(App.getAppContext());
         customerArray = new ArrayList<>();

        Cursor cursor = repo.selectAll();

            if(cursor.moveToNext()) {
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


            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,customerArray);
           // adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,id);

            gridView = (GridView) findViewById(R.id.gridView);
            gridView.setAdapter(adapter);
            //listView.setAdapter(adapter1);
        }
    }
}
