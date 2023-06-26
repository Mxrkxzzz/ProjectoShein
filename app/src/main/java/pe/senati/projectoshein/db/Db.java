package pe.senati.projectoshein.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Db extends SQLiteOpenHelper {

    SQLiteDatabase db;
    String sSQL = "";

    public Db(@Nullable Context context){
        super(context, "Shein_1.01.db", null, 1);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Cliente(id integer  primary key autoincrement, Correo text, Password text)");
        db.execSQL("create table Producto(id integer  primary key autoincrement, Precio text, Detalle text, Color text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public int Insert(String sTabla, ContentValues values) {
        return (int) db.insert(sTabla,null,values);
    }

    public void Sentencia(String sql) {
        this.sSQL = sql;
    }


    public Cursor getCursor() {
        return db.rawQuery(sSQL,null);
    }

    public void Ejecutar(){
        db.execSQL( sSQL);
    }

    public String getCampo(){
        String sCampo = null;
        Cursor cursor = getCursor();
        if (cursor.moveToFirst())
            sCampo = cursor.getString(0);

        cursor.close();
        return sCampo;
    }

    public String[] getRegistro() {
        String item;
        String[] aRegistro = null;
        Cursor cursor = getCursor();
        if ( cursor.moveToFirst() ){
            if (cursor.moveToFirst()){
                aRegistro = new String[ cursor.getColumnCount()];
                for (int i=0; i<aRegistro.length; i++){
                    item =cursor.getString(i);
                    aRegistro[i]= item == null || item.equals("null") ? null : item.trim();
                }
            }
        }
        cursor.close();
        return  aRegistro;
    }

}