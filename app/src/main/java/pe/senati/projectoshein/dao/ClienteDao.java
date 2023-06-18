package pe.senati.projectoshein.dao;

import android.content.ContentValues;
import android.content.Context;

import pe.senati.projectoshein.bean.Cliente;
import pe.senati.projectoshein.db.Db;

public class ClienteDao {

    Db db;

    public ClienteDao(Context context){
        db = new Db( context );
    }

    public void Guardar(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("Correo", cliente.getCorreo());
        values.put("Password", cliente.getPassword());
        cliente.setId( db.Insert("Cliente", values) );
    }

    public boolean Login(Cliente cliente) {

        db.Sentencia( String.format( "select * from Cliente where Correo ='%s' and Password='%s'", cliente.getCorreo(), cliente.getPassword()) );
        cliente = new Cliente( db.getCursor() );
        return cliente.getId() > 0;
    }

    public Cliente getCliente() {
        db.Sentencia("select count(*) from Cliente");
        if (db.getCampo().equals("0")) return null;

        db.Sentencia("select * from Cliente");
        return new Cliente( db.getCursor () );

    }
}
