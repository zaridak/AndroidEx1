package com.example.ask1;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import android.location.LocationManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.app.Fragment;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;
import static androidx.core.content.ContextCompat.getSystemService;

public class Contact  {

    private String username;
    private String email;
    private String telephone;
    private String address;


    //private static SQLiteDatabase db;

    public Contact(String username,String email, String telephone,String address){
        this.telephone = telephone;
        this.username = username;
        this.address=address;
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public String getTelephone(){
        return this.telephone;
    }

    public String getUsername(){
        return this.username;
    }

    public String getAddress(){
        return  this.address;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean addInDB(SQLiteDatabase db){

        try{
            db.execSQL("CREATE TABLE IF NOT EXISTS 'Contacts' ("+
                    "'id' INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "'address' TEXT,"+
                    "'telephone' TEXT,"+
                    "'username' TEXT,"+
                    "'email' TEXT)");

            db.execSQL("INSERT OR IGNORE INTO 'Contacts' VALUES "+
                    "('"+this.address+"','"+this.telephone+"','"+this.username+"'"+","+"'"+this.email
                    +"'"+");" );
        }catch (Exception ex){
            System.err.println("Failed to create or add contact from class contact");
            return false;
        }
        db.close();
        return true;




    }

}
