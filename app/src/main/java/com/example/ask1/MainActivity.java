package com.example.ask1;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import android.location.LocationManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        db = openOrCreateDatabase("Ask1DB",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS 'userPass' (" +
                "'pass' TEXT," +
                "PRIMARY KEY('pass'))");
        db.execSQL("INSERT OR IGNORE INTO 'userPass' VALUES" +
                "('1');");*/
    }

    public void checkPass(View view) {
        //Toast.makeText(this,"wtf!",Toast.LENGTH_SHORT).show();
        EditText psw = findViewById(R.id.passText);
        String userInput = psw.getText().toString();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        StringBuffer buffer = new StringBuffer();
        db = openOrCreateDatabase("Ask1DB",MODE_PRIVATE,null);

        Cursor cursor = db.rawQuery("SELECT * FROM userPass",null);
        if (cursor.getCount()!=0){
            while (cursor.moveToNext()){
                buffer.append(cursor.getString(0));
            }
        }
       // Toast.makeText(this,buffer.toString(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(this,userInput.toString(),Toast.LENGTH_SHORT).show();

        //Toast.makeText(this,buffer,Toast.LENGTH_SHORT).show();
        String systemPass = buffer.toString();

        if(buffer.toString().equals(userInput)){//correct pass
            db.close();
            Intent intent = new Intent(this, startScreen.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Worng Password",Toast.LENGTH_SHORT).show();
            db.close();
        }

    }
}
