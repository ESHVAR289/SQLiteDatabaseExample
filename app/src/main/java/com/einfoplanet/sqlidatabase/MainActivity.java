package com.einfoplanet.sqlidatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * HOW IT WORKS
        * in this example ,we first created an instance of DBAdapter class.
        *       DBAdapter db=new DBAdapter(this);
        *    The insertContact() method returns the ID of the inserted row.If an error occure during the
         *    operation , it returns -1
         *
         *    If we examint the file system of android device/emulator using DDMS,we can see the MyDB database is
         *    created under the database folder.
        * */
        DBAdapter dbAdapter=new DBAdapter(this);
        //adding a contact
        dbAdapter.open();
        long id= dbAdapter.insertContact("Eshvar Mali","eshvar89@hotmail.com");
             id= dbAdapter.insertContact("Dinkar Mali","dinkarraj@gmail.com");

        dbAdapter.close();
    }
}
