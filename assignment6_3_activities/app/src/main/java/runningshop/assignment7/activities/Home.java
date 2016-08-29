package runningshop.assignment7.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import runningshop.assignment7.R;
import runningshop.assignment7.conf.util.App;

public class Home extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View view){
        Intent i = new Intent(this,RegisterCustomer.class);
        startActivity(i);
    }
}
