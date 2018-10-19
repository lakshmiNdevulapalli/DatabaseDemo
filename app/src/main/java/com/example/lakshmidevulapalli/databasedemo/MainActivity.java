package com.example.lakshmidevulapalli.databasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       try{
           SQLiteDatabase database = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

           database.execSQL("CREATE TABLE IF NOT EXISTS newUsers(name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");
           //database.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");
           /*database.execSQL("INSERT INTO users (name, age) VALUES ('Ben', 19)");
           database.execSQL("INSERT INTO users (name, age) VALUES ('Indy', 47)");
           database.execSQL("INSERT INTO users (name, age) VALUES ('Peter', 7)");
           database.execSQL("INSERT INTO users (name, age) VALUES ('parker', 4)");*/
           database.execSQL("DELETE FROM newUsers WHERE id = 1");

           /*database.execSQL("INSERT INTO newUsers (name, age) VALUES ('Ben', 19)");
           database.execSQL("INSERT INTO newUsers (name, age) VALUES ('Indy', 47)");
           database.execSQL("INSERT INTO newUsers (name, age) VALUES ('Peter', 7)");
*/
           Cursor c = database.rawQuery("SELECT * FROM newUsers", null);

           int nameIndex = c.getColumnIndex("name");
           int ageIndex = c.getColumnIndex("age");
           int idIndex = c.getColumnIndex("id");

           c.moveToFirst();

           while (c != null){
               Log.i("Name of the user", c.getString(nameIndex));
               Log.i("age of the user", c.getString(ageIndex));
               Log.i("User id", c.getString(idIndex));
               c.moveToNext();
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
