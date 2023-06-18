package pe.senati.projectoshein.dao;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

import pe.senati.projectoshein.bean.Producto;
import pe.senati.projectoshein.db.Db;

public class ProductoDao {
    Db db;

    public ProductoDao(Context context) {
        db = new Db(context);
    }

    public List<Producto> getProductos() {
        db.Sentencia("select * from producto");
        Cursor cursor = db.getCursor();
        if (cursor.getCount() == 0) {
            cursor.close();
            return null;
        }

        List<Producto> lstProducto = new ArrayList<>();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
            lstProducto.add(new Producto(cursor));

        cursor.close();
        return lstProducto;
    }
}