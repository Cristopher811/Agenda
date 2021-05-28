package com.example.agenda.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;
import com.example.agenda.entidades.Contacto;
import java.util.ArrayList;

public class DBContactos extends DBHelper{
    Context context;
    public DBContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertContacts(String nombre, String telefono, String email){
        long id = 0;
        try{
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("email", email);

            id = db.insert(TABLE_CONTACTOS, null, values);
        }catch(Exception ex){
            ex.toString();
        }
        return id;
    }
    public ArrayList<Contacto>MostrarContactos(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Contacto> ListaContactos = new ArrayList<Contacto>();
        Contacto contacto = null;
        Cursor cursorContactos = null;
        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS, null);

        if(cursorContactos.moveToFirst()){
            do{
                contacto = new Contacto();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setTelefono(cursorContactos.getString(2));
                contacto.setEmail(cursorContactos.getString(3));
                ListaContactos.add(contacto);
            }while(cursorContactos.moveToNext());
        }
        cursorContactos.close();
        return ListaContactos;
    }
}
