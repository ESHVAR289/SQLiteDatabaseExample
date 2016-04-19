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

        //get a contact
        dbAdapter.open();
        Cursor cursor=dbAdapter.getContact(2);
        if (cursor.moveToFirst()){
            displayContact(cursor);
        }
        else Toast.makeText(this,"NO CONTACT FOUND",Toast.LENGTH_LONG).show();
        dbAdapter.close();
    }

    private String displayContact(Cursor cursor) {
        String str;
         str=cursor.getString(1)+"\n"+cursor.getString(2);

        textView.setText(str);
        textView.setVisibility(View.VISIBLE);
        return  str;
    }
}
