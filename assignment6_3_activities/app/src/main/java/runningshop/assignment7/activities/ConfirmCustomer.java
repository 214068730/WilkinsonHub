package runningshop.assignment7.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import runningshop.assignment7.R;

public class ConfirmCustomer extends AppCompatActivity {

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

        String custName = data.getString("CustomerName");
        String custStreet = data.getString("CustomerStreetName");
        String custSuburb = data.getString("CustomerSuburb");
        String postal = data.getString("CustomerPostalCode");

        name.setText(custName);
        street.setText(custStreet);
        suburb.setText(custSuburb);
        postalCode.setText(postal);


    }

    public void onClick(View view)
    {
        Intent i = new Intent(this,ViewCustomer.class);
        startActivity(i);
    }
}
