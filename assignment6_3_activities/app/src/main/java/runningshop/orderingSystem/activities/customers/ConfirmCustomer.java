package runningshop.orderingSystem.activities.customers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import runningshop.orderingSystem.R;
import runningshop.orderingSystem.conf.util.App;
import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.services.apiservices.ApiCustomerService;
import runningshop.orderingSystem.services.apiservices.Impl.ApiCustomerServiceImpl;
import runningshop.orderingSystem.services.customer.CustomerService;
import runningshop.orderingSystem.services.customer.Impl.CustomerServiceImpl;

public class ConfirmCustomer extends AppCompatActivity {


    String custName ;
    String custStreet;
    String custSuburb ;
    String postal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_customer);

        Bundle data = getIntent().getExtras();
        if(data == null)
            return;

        TextView name = (TextView)findViewById(R.id.lblName);
        TextView street = (TextView)findViewById(R.id.lblStreet);
        TextView suburb = (TextView)findViewById(R.id.lblSuburb);
        TextView postalCode = (TextView)findViewById(R.id.lblPostal);

         custName = data.getString("CustomerName");
         custStreet = data.getString("CustomerStreetName");
         custSuburb = data.getString("CustomerSuburb");
         postal = data.getString("CustomerPostalCode");

        name.setText(custName);
        street.setText(custStreet);
        suburb.setText(custSuburb);
        postalCode.setText(postal);


    }

    public void onClick(View view)
    {
        //ApiCustomerService service = new ApiCustomerServiceImpl();
        try {
            Intent i = new Intent(this, ViewCustomer.class);
            CustomerService cust = CustomerServiceImpl.getInstance();
            AddressVO address = new AddressVO.AddressBuilder()
                    .streetName(custStreet)
                    .suburb(custSuburb)
                    .postalCode(postal)
                    .build();
            Customer customer = new Customer.CustomerBuild()
                    .custName(custName)
                    .address(address)
                    .build();
            //service.save(customer);
            Toast.makeText(this,"Added", Toast.LENGTH_SHORT).show();
            cust.addCustomer(App.getAppContext(), customer);  //sqlite database
            startActivity(i);
            finish();
        }catch(Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
