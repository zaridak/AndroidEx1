package com.example.ask1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.view.View;
import android.app.Fragment;
import android.content.Intent;

import java.util.Vector;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;
import static androidx.core.content.ContextCompat.startActivity;

public class myAdapter extends ArrayAdapter<Contact>  {

    private Context mContext;
    private Vector<Contact> contactsList = new Vector<>();
    SQLiteDatabase db;

    public myAdapter(Context context, Vector<Contact> contacts) {
        super(context, 0, contacts);
        this.mContext = context;
        this.contactsList = contacts;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_item,parent,false);

        final Contact con = this.contactsList.elementAt(position);

        TextView name = (TextView) listItem.findViewById(R.id.textView_username);
        name.setText("Name: "+con.getUsername());

        TextView email = (TextView) listItem.findViewById(R.id.textView_Email);
        email.setText("Email: "+con.getEmail());

        TextView tel = (TextView) listItem.findViewById(R.id.textView_Tel);
        tel.setText("Mobile: "+con.getTelephone());

        TextView address = (TextView) listItem.findViewById(R.id.textView_Add);
        address.setText("Address: "+con.getAddress());

      /*  TextView deleteBtn = (TextView) listItem.findViewById(R.id.dltConBtnitem);
        deleteBtn.setText("Delete");

        Button btButton = (Button) listItem.findViewById(R.id.dltConBtnitem);

        btButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("svinw to "+con.getEmail() );

                /*db = openOrCreateDatabase("Ask1DB",null);
                db.execSQL("DELETE FROM Contacts WHERE email="+
                        "'"+con.getEmail()+"'");
                addActivity go = new addActivity();
                go.deleteByMail(con.getEmail());
            }
        }); */

        return listItem;
    }
}


