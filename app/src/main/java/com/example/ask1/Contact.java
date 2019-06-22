package com.example.ask1;

import android.database.sqlite.SQLiteDatabase;

public class Contact  {

    private String username;
    private String email;
    private String telephone;
    private String address;
    private int id;

    public Contact(String username,String email, String telephone,String address){

        this.telephone = telephone;
        this.username = username;
        this.address=address;
        this.email = email;
        //System.out.println("Contact Created "+this.username+" "+this.email+" "+ this.address+" "+this.telephone);
    }

    public String getEmail(){
        System.out.println("EPISTREFW TO MAIL "+this.email);
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

    protected boolean addInDB(SQLiteDatabase db){

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

    public String toString(){
        return this.username+" "+this.email+" "+this.telephone+" "+this.address;
    }
}