package com.example.ask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class changePassActivity extends AppCompatActivity {


    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
    }


    public void updatePass(View view) {

        EditText pass1 = findViewById(R.id.pass1);
        EditText pass2 = findViewById(R.id.pass2);

        String psw1 = pass1.getText().toString();
        String psw2 = pass2.getText().toString();

        if(! psw1.equals(psw2)) {
            Toast.makeText(this,"Not same passes",Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            db = openOrCreateDatabase("Ask1DB",MODE_PRIVATE,null);
            if(psw1.equals(psw2))
                db.execSQL("UPDATE userPass SET pass= "+
                        "'"+psw1+"';");
            db.close();
            Intent intent = new Intent(this, startScreen.class);
            startActivity(intent);

            } catch (Exception ex){
            Toast.makeText(this,"Fail changing pass "+ex.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }
}
