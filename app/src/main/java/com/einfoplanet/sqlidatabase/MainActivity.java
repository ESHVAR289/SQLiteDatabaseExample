package com.einfoplanet.sqlidatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //text view for displaying the contact
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate the textview
        textView= (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);
        //creating an instance of DBAdapter
        DBAdapter dbAdapter=new DBAdapter(this);

       //get all contacts
        dbAdapter.open();
        Cursor cursor= dbAdapter.getAllContacts();
        if (cursor.moveToFirst()){
            do {
                displayContact(cursor);
            }while (cursor.moveToNext());
            }
        dbAdapter.close();
        }



    private String displayContact(Cursor cursor) {
        String str;
         str="ID ="+cursor.getString(0)+"\nName ="+cursor.getString(1)+"\nEmail ="+cursor.getString(2);
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        textView.setText(str);
        textView.setVisibility(View.VISIBLE);
        return  str;
    }
}
