package com.example.ask1;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Vector;

public class viewActivity extends AppCompatActivity {
/*
git add .
git commit -m "fefefe"
git push
*/
    SQLiteDatabase db;
/*
*                   'address' TEXT,"+  2
                    "'telephone' TEXT,"+ 3
                    "'username' TEXT,"+4
                    "'email' TEXT)");  5 */

    Vector<Contact> myCons;

    // add exception handling !!!!!!!!!!!!!!!!!!!!!!!!!
    // maybe string array instead of vector
    public void getContactsFromDB(SQLiteDatabase db){

        StringBuffer buffer = new StringBuffer();
        Cursor cursor = db.rawQuery("SELECT * FROM Contacts",null);
        if (cursor.getCount()!=0){
            while (cursor.moveToNext()){
                myCons.add(new Contact(cursor.getString(2),cursor.getString(3),cursor.getString(1),cursor.getString(0)));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        myCons = new Vector<>();
        db = openOrCreateDatabase("Ask1DB",MODE_PRIVATE,null);
        getContactsFromDB(db);

        findViewById(R.id.viewList);

        //fix this dynamically SAVVATO
        if(!myCons.isEmpty()){

            //add all vector to values
            //{myCons.elementAt(0).getUsername(),myCons.elementAt(0).getEmail()};
            int size = myCons.size()*4;
            String[] values = new String[myCons.size()];
            int i=0;
            for(Contact tmp :myCons){
                values[i++] = "Όνομα: "+tmp.getUsername()+"\n"+"Email: "+tmp.getEmail()+"\n"+"Τηλέφωνο: "+tmp.getTelephone()+"\n"+"Διεύθυνση: "+tmp.getAddress()+"\n";
            }

            for(int j =0;j<values.length;j++)
                System.out.println(values[j]);

            //print by 4 group
            ListView  listView =(ListView) findViewById(R.id.viewList);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, values);
            listView.setAdapter(adapter);
           // Toast.makeText(this,myCons.size(),Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"No contacts found",Toast.LENGTH_SHORT).show();
        }


    }
}
