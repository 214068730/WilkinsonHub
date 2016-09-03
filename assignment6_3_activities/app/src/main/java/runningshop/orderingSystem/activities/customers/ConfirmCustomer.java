package runningshop.orderingSystem.activities.customers;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import runningshop.orderingSystem.R;
import runningshop.orderingSystem.activities.CustomerMenu;
import runningshop.orderingSystem.domain.address.AddressVO;
import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.factories.customer.CustomerAddressFactory;
import runningshop.orderingSystem.factories.customer.CustomerFactory;

public class ConfirmCustomer extends AppCompatActivity {


    String custName ;
    String custStreet;
    String custSuburb ;
    String postal;
    private Customer customer;
    private AddressVO address;
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

        /*AddressVO address = new AddressVO.AddressBuilder()
                .streetName(custStreet)
                .suburb(custSuburb)
                .postalCode(postal)
                .build();
        customer = new Customer.CustomerBuild()
                .custName(custName)
                .address(address)
                .build();*/
        address = CustomerAddressFactory.getCustomerAddress(postalCode.getText().toString(),street.getText().toString(),suburb.getText().toString());
        customer = CustomerFactory.getCustomer(0L,name.getText().toString(),address);
    }

    public void onClick(View view)
    {
//        ApiCustomerService service = new ApiCustomerServiceImpl();

            Intent i = new Intent(this, CustomerMenu.class);
           // CustomerService cust = CustomerServiceImpl.getInstance();

            //service.save(customer);
           new HttpRequestTask().execute();
            Toast.makeText(this,"Added", Toast.LENGTH_SHORT).show();
           // cust.addCustomer(App.getAppContext(), customer);  //sqlite database
            startActivity(i);
            finish();

    }


    private class HttpRequestTask extends AsyncTask<Void, Void, Customer> {
        @Override
        protected Customer doInBackground(Void... params) {
            try {
               final String url = "http://148.100.5.106:8080/shop/customer/create";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Customer> httpEntity = new HttpEntity<>(customer,headers);
                Customer cust = restTemplate.postForObject(url,httpEntity,Customer.class);

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }
    }
}


