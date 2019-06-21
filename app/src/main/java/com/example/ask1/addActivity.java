package com.example.ask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class addActivity extends AppCompatActivity {


    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void addContact(View view) {

        String username = findViewById(R.id.username).toString();
        String userEmail =  findViewById(R.id.email).toString();
        String userAddress =findViewById(R.id.address).toString();
        String userTel = findViewById(R.id.telephone).toString();

        //Contact toAdd = new Contact("aek","lola@live.com","54665454","padou menw");
        Contact toAdd = new Contact(username,userEmail,userTel,userAddress);

        db = openOrCreateDatabase("Ask1DB",MODE_PRIVATE,null);

        if( toAdd.addInDB(db)){
            //Toast.makeText(this,"Contact Added yo",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, startScreen.class);
            startActivity(intent);
        }

        else
            Toast.makeText(this,"Oops something went wrong. Buy an iPhone",Toast.LENGTH_SHORT).show();



    }
}
