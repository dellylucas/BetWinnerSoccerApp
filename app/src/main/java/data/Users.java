package data;

import android.content.ContentValues;

import java.util.UUID;

import data.UsersContract.UsersEntry;

public class Users {
    private String id;
    private  String name;
    private  String telephone;
    private  Boolean type;
    private  String pass;
    private  String email;

    public Users(String name, String telephone, Boolean type, String pass, String email) {
        this.id = UUID.randomUUID().toString(); ;
        this.name = name;
        this.telephone = telephone;
        this.type = type;
        this.pass = pass;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(UsersEntry.ID, id);
        values.put(UsersEntry.NAME, name);
        values.put(UsersEntry.TELEPHONE, telephone);
        values.put(UsersEntry.TYPE, type);
        values.put(UsersEntry.PASS, pass);
        values.put(UsersEntry.EMAIL, email);
        return values;
    }
}
