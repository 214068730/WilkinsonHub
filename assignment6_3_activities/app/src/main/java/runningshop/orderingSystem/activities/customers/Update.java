package runningshop.orderingSystem.activities.customers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import runningshop.orderingSystem.R;
import runningshop.orderingSystem.activities.CustomerMenu;
import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.services.customer.CustomerService;
import runningshop.orderingSystem.services.customer.Impl.CustomerServiceImpl;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        LinearLayout layout = (LinearLayout)findViewById(R.id.updateLayout);
        Button updateButton = (Button)findViewById(R.id.btnCustomerUpdate);
        layout.setVisibility(View.INVISIBLE);
        updateButton.setVisibility(View.INVISIBLE);
        TextView updateId = (TextView)findViewById(R.id.txtID);
        updateId.setVisibility(View.INVISIBLE);
    }

    public void onHome(View view)
    {
        try {
            Intent i = new Intent(this, CustomerMenu.class);
            startActivity(i);
            finish();
        }catch(Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onCustomerUpdateSearch(View view)
    {
       EditText id = (EditText) findViewById(R.id.txtUpdateSearchID);
        TextView updateId = (TextView)findViewById(R.id.txtID);
        EditText name = (EditText) findViewById(R.id.txtCustomerNameUpdate);
        EditText streetName = (EditText) findViewById(R.id.txtCustomerStreetNameUpdate);
        EditText suburb = (EditText) findViewById(R.id.txtCustomerSuburbUpdate);
        EditText postal = (EditText) findViewById(R.id.txtCustomerPostalCodeUpdate);
        Button updateButton = (Button)findViewById(R.id.btnCustomerUpdate);
        CustomerService cust = CustomerServiceImpl.getInstance();
        LinearLayout layout = (LinearLayout)findViewById(R.id.updateLayout);
        long searchId = 0L;

        try {
            if((id.getText().toString()+"") == ""){

            }
            else
                searchId = Long.parseLong(id.getText().toString());

            Customer customer = cust.findCustomer(App.getAppContext(),searchId);
            if(customer != null)
            {
                layout.setVisibility(View.VISIBLE);
                updateId.setText(searchId+"");

                name.setText(customer.getCustName().toString()+"");
                streetName.setText(customer.getStreetName().toString()+"");
                suburb.setText(customer.getSuburb().toString()+"");
                postal.setText(customer.getPostalCode().toString()+"");
                updateButton.setVisibility(View.VISIBLE);
            }
            else {
                layout.setVisibility(View.INVISIBLE);
                updateButton.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Customer does not exist", Toast.LENGTH_SHORT).show();

            }


        }catch(Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
    public void onCustomerUpdate(View view)
    {
        TextView updateId = (TextView)findViewById(R.id.txtID);
        EditText name = (EditText) findViewById(R.id.txtCustomerNameUpdate);
        EditText streetName = (EditText) findViewById(R.id.txtCustomerStreetNameUpdate);
        EditText suburb = (EditText) findViewById(R.id.txtCustomerSuburbUpdate);
        EditText postal = (EditText) findViewById(R.id.txtCustomerPostalCodeUpdate);
        Button updateButton = (Button)findViewById(R.id.btnCustomerUpdate);
        long ID = Long.parseLong(updateId.getText().toString()+"");
        CustomerService cust = CustomerServiceImpl.getInstance();
        Customer customer = cust.findCustomer(App.getAppContext(),ID);
        AddressVO updatedAddress = new AddressVO.AddressBuilder()
                .streetName(streetName.getText().toString()+"")
                .suburb(suburb.getText().toString()+"")
                .postalCode(postal.getText().toString()+"")
                .build();
        Customer updateCustomer = new Customer.CustomerBuild()
                .copy(customer)
                .custName(name.getText().toString()+"")
                .address(updatedAddress)
                .build();
        cust.updateCustomer(App.getAppContext(),updateCustomer);
        LinearLayout layout = (LinearLayout)findViewById(R.id.updateLayout);
        updateButton.setVisibility(View.INVISIBLE);
        layout.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Customer has been updated", Toast.LENGTH_SHORT).show();
    }
}
