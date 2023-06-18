package pe.senati.projectoshein.bean;

import android.database.Cursor;

public class Producto {
    int id;
    String Detalle, Precio;

    public Producto() {

    }

    public Producto(int id, String detalle, String precio) {
        this.id = id;
        Detalle = detalle;
        Precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String correo) {
        Detalle = correo;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String password) {
        Precio = password;
    }

    public Producto(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            cursor.close();
            return;
        }

        id = cursor.getInt(0);
        Detalle = cursor.getString(1);
        Precio = cursor.getString(2);

        cursor.close();
    }
}