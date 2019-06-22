package com.example.ask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class removeActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
    }

    public void rmvByMail(View view ){

        EditText Email   = findViewById(R.id.mailID);
        String userEmail = Email.getText().toString();

        try{
            db = openOrCreateDatabase("Ask1DB",MODE_PRIVATE,null);

            Cursor counter =  db.rawQuery("SELECT COUNT (*) FROM Contacts WHERE email="+
                    "'"+userEmail+"';",null);

            counter.moveToFirst();
            int count = counter.getInt(0);
            counter.close();
            if(count == 0){
                Toast.makeText(this,"Contact doesn't exist", Toast.LENGTH_SHORT).show();
                db.close();
            }
            else{
                db.execSQL("DELETE FROM Contacts WHERE email=" +
                        "'"+userEmail+"';");
                db.close();
                Intent intent = new Intent(this, startScreen.class);
                startActivity(intent);
            }

        }catch (Exception ex){
            Toast.makeText(this,"Delete failed, try again", Toast.LENGTH_SHORT).show();
        }

    }
}
