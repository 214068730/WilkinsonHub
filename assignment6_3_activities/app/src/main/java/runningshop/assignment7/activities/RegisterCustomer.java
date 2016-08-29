package runningshop.assignment7.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import runningshop.assignment7.R;

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

        i.putExtra("CustomerName",name.getText().toString());
        i.putExtra("CustomerStreetName",street.getText().toString());
        i.putExtra("CustomerSuburb",suburb.getText().toString());
        i.putExtra("CustomerPostalCode", postalCode.getText().toString());
        startActivity(i);
    }
}
