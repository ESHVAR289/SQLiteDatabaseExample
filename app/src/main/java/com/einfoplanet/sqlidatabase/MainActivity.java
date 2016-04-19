package com.einfoplanet.sqlidatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instance for the DBAdapter class
        DBAdapter dbAdapter=new DBAdapter(this);

        dbAdapter.open();
        if (dbAdapter.updateContact(1,"Eshvar Mali","eshvar89@hotmail.com")){
            Toast.makeText(this,"Update Successfully.",Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this,"Update failed",Toast.LENGTH_LONG).show();

        dbAdapter.close();
    }
}
