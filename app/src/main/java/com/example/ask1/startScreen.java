package com.example.ask1;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class startScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void add(View view) {
        Intent intent = new Intent(this, addActivity.class);
        startActivity(intent);
    }

    public void view(View view) {
        Intent intent = new Intent(this, viewActivity.class);
        startActivity(intent);
    }

    public void delete(View view) {

        SQLiteDatabase db;

        try{
            db = openOrCreateDatabase("Ask1DB",MODE_PRIVATE,null);
            db.execSQL("DELETE FROM Contacts");
            db.close();
            Toast.makeText(this,"Contacts deleted",Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex){
            Toast.makeText(this,"Delete Operation failed "+ex.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void changePass(View view){
        Intent intent = new Intent(this, changePassActivity.class);
        startActivity(intent);
    }




}
