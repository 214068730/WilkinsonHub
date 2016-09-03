package runningshop.orderingSystem.activities.customers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import runningshop.orderingSystem.R;
import runningshop.orderingSystem.activities.CustomerMenu;
import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.services.customer.CustomerService;
import runningshop.orderingSystem.services.customer.Impl.CustomerServiceImpl;



public class Delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        EditText id= (EditText) findViewById(R.id.txtSearchDeleteID);
        TextView name = (TextView)findViewById(R.id.lblCustomerName);
        name.setVisibility(View.INVISIBLE);
        TextView street = (TextView)findViewById(R.id.lblCustomerStreetName);
        street.setVisibility(View.INVISIBLE);
        TextView suburb = (TextView)findViewById(R.id.lblCustomerSuburb);
        suburb.setVisibility(View.INVISIBLE);
        TextView postalCode = (TextView)findViewById(R.id.lblCustomerPostalCode);
        postalCode.setVisibility(View.INVISIBLE);
        TextView deleteNumber = (TextView)findViewById(R.id.lblCustomerDeleteNumber);
        deleteNumber.setVisibility(View.INVISIBLE);
        Button deleteButton = (Button)findViewById(R.id.btnDeleteCustomer);
        deleteButton.setVisibility(View.INVISIBLE);
    }


    public void onDeleteSearch(View view) {
        EditText id= (EditText) findViewById(R.id.txtSearchDeleteID);
        TextView name = (TextView)findViewById(R.id.lblCustomerName);
        TextView street = (TextView)findViewById(R.id.lblCustomerStreetName);
        TextView suburb = (TextView)findViewById(R.id.lblCustomerSuburb);
        TextView postalCode = (TextView)findViewById(R.id.lblCustomerPostalCode);
        CustomerService cust = CustomerServiceImpl.getInstance();
        TextView deleteNumber = (TextView)findViewById(R.id.lblCustomerDeleteNumber);
        long searchId = 0L;
        Button deleteButton = (Button)findViewById(R.id.btnDeleteCustomer);


        if((id.getText().toString()+"") == ""){

        }
        else
            searchId = Long.parseLong(id.getText().toString());

        Customer customer = cust.findCustomer(App.getAppContext(),searchId);
        if(customer != null)
        {
            name.setVisibility(View.VISIBLE);
            street.setVisibility(View.VISIBLE);
            suburb.setVisibility(View.VISIBLE);
            postalCode.setVisibility(View.VISIBLE);
            deleteNumber.setText(searchId+"");

            name.setText(customer.getCustName().toString()+"");
            street.setText(customer.getStreetName().toString()+"");
            suburb.setText(customer.getSuburb().toString()+"");
            postalCode.setText(customer.getPostalCode().toString()+"");
            deleteButton.setVisibility(View.VISIBLE);
        }
        else {
            name.setVisibility(View.VISIBLE);
            street.setVisibility(View.INVISIBLE);
            suburb.setVisibility(View.INVISIBLE);
            postalCode.setVisibility(View.INVISIBLE);
            deleteButton.setVisibility(View.INVISIBLE);
            name.setText("Customer does not exist");
        }
    }

    public void onDeleteCustomer(View view) {
        TextView deleteNumber = (TextView)findViewById(R.id.lblCustomerDeleteNumber);
        TextView name = (TextView)findViewById(R.id.lblCustomerName);
        TextView street = (TextView)findViewById(R.id.lblCustomerStreetName);
        TextView suburb = (TextView)findViewById(R.id.lblCustomerSuburb);
        TextView postalCode = (TextView)findViewById(R.id.lblCustomerPostalCode);
        Button deleteButton = (Button)findViewById(R.id.btnDeleteCustomer);
        long deleteID = Long.parseLong(deleteNumber.getText().toString()+"");
        CustomerService cust = CustomerServiceImpl.getInstance();

        Customer customer = cust.findCustomer(App.getAppContext(),deleteID);
        cust.deleteCustomer(App.getAppContext(),customer);
        name.setVisibility(View.INVISIBLE);
        street.setVisibility(View.INVISIBLE);
        suburb.setVisibility(View.INVISIBLE);
        postalCode.setVisibility(View.INVISIBLE);
        deleteButton.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Customer has been removed", Toast.LENGTH_SHORT).show();
    }
    public void onCustomerHome(View view) {
        try {
            Intent i = new Intent(this, CustomerMenu.class);
            startActivity(i);
            finish();
        }catch(Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
