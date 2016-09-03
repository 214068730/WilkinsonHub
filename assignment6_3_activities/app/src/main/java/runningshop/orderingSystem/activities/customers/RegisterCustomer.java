package runningshop.orderingSystem.activities.customers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import runningshop.orderingSystem.R;

public class RegisterCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);
    }

    public void onClick(View view)
    {
        Intent i = new Intent(this,ConfirmCustomer.class);
        EditText name = (EditText)findViewById(R.id.txtCustomerName);
        EditText street = (EditText)findViewById(R.id.txtStreet);
        EditText suburb = (EditText)findViewById(R.id.txtSuburb);
        EditText postalCode = (EditText)findViewById(R.id.txtPostalCode);

        if(name.getText().toString().equals("")||street.getText().toString().equals("")||suburb.getText().toString().equals("")||postalCode.getText().toString().equals(""))
        {
            Toast.makeText(this,"Please fill in all fields",Toast.LENGTH_LONG).show();
        }
        else {
            i.putExtra("CustomerName", name.getText().toString());
            i.putExtra("CustomerStreetName", street.getText().toString());
            i.putExtra("CustomerSuburb", suburb.getText().toString());
            i.putExtra("CustomerPostalCode", postalCode.getText().toString());
            startActivity(i);
        }
    }

    public void clearName(View view){
        EditText name = (EditText)findViewById(R.id.txtCustomerName);
        name.setText("");
    }

    public void clearStreet(View view){
        EditText street = (EditText)findViewById(R.id.txtStreet);
        street.setText("");
    }

    public void clearSuburb(View view){
        EditText suburb = (EditText)findViewById(R.id.txtSuburb);
        suburb.setText("");
    }

    public void clearPostalCode(View view){
        EditText postalCode = (EditText)findViewById(R.id.txtPostalCode);
        postalCode.setText("");
    }

}
