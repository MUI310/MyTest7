package com.example.databaseprovidertest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 private String newId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button queryData=(Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Uri uri=Uri.parse("content://com.example.providertest.provider/contacts");
                Cursor cursor=getContentResolver().query(uri,null,null,null,null);
                if(cursor!=null){
                    while (cursor.moveToNext()){
                        String name=cursor.getString(cursor.getColumnIndex("name")+0);
                        String number=cursor.getString(cursor.getColumnIndex("number")+0);
                        String gender=cursor.getString(cursor.getColumnIndex("gender")+0);

                        Log.d("MainActivity","name is"+name);
                        Log.d("MainActivity","number is"+number);
                        Log.d("MainActivity","gender is"+gender);
                    }
                cursor.close();
                }
            }
        });
    }
}