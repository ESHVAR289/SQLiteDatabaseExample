package com.einfoplanet.sqlidatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAdapter dbAdapter=new DBAdapter(this);
        //adding a contact
        dbAdapter.open();
        long id= dbAdapter.insertContact("Eshvar Mali","eshvar89@hotmail.com");
             id= dbAdapter.insertContact("Dinkar Mali","dinkarraj@gmail.com");

        dbAdapter.close();
    }
}
