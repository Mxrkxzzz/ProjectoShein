package pe.senati.projectoshein.bean;

import android.database.Cursor;

import com.google.android.material.color.utilities.CorePalette;

public class Cliente {
    int id;
    String Correo, Password, Telefono;

    public Cliente() {

    }

    public Cliente(int id, String correo, String password, String telefono) {
        this.id = id;
        Correo = correo;
        Password = password;
        Telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Cliente(Cursor cursor) {
        if( !cursor.moveToFirst() ) {
            cursor.close();
            return;
        }

        id = cursor.getInt(0);
        Correo = cursor.getString(1);
        Password = cursor.getString(2);
        Telefono = cursor.getString(3);

        cursor.close();
    }
}