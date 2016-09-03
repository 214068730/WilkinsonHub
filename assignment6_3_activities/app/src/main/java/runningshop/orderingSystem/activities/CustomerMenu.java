package runningshop.orderingSystem.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import runningshop.orderingSystem.R;
import runningshop.orderingSystem.activities.customers.Delete;
import runningshop.orderingSystem.activities.customers.RegisterCustomer;
import runningshop.orderingSystem.activities.customers.Update;
import runningshop.orderingSystem.activities.customers.ViewCustomer;

public class CustomerMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu);
    }

    public void onClick(View view){
        Intent i = new Intent(this,RegisterCustomer.class);
        startActivity(i);
    }

    public void viewCustomer(View view)
    {
        try {
            Intent i = new Intent(this, ViewCustomer.class);
            startActivity(i);
            finish();
        }catch(Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onDelete(View view)
    {
        try {
            Intent i = new Intent(this, Delete.class);
            startActivity(i);
            finish();
        }catch(Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onUpdateCustomer(View view)
    {
        try {
            Intent i = new Intent(this, Update.class);
            startActivity(i);
            finish();
        }catch(Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
