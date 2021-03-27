package com.jota.pruebalistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Crud {
    private ConectarBD BaseD;
    private SQLiteDatabase DB;
    private ContentValues values = new ContentValues();

    public Crud(Context context) {
        BaseD = new ConectarBD(context);
    }

    public Crud() {
    }

    // Metodo para Grabar Datos
    public void grabar(Producto p) {
        DB = BaseD.getWritableDatabase();
        values.clear();
        values.put(TablaBD.ProductoEntry.NOMBRE, p.getNombre());
        values.put(TablaBD.ProductoEntry.VALOR, p.getValor());
        DB.insert(TablaBD.ProductoEntry.TABLE_NAME, null, values);
    }

    // Metodo para Rellenar los Nombres
    public ArrayList cargarNombre(){
        ArrayList<String> soloNom = new ArrayList<>();
        DB = BaseD.getWritableDatabase();
        Cursor informacion = DB.rawQuery("SELECT * FROM " + TablaBD.ProductoEntry.TABLE_NAME, null);
        if (informacion.moveToFirst()){
            do {
                soloNom.add(informacion.getString(0)); // + " " + registro.getString(1));
            }while(informacion.moveToNext());
        }

        return soloNom;
    }

    // metodo para carga todos los datos
    public ArrayList<Producto> mostrarDatos() {
        ArrayList<Producto> tProd = new ArrayList<Producto>();
        DB = BaseD.getWritableDatabase();
        Cursor informacion = DB.rawQuery("select * from " + TablaBD.ProductoEntry.TABLE_NAME, null);
        if (informacion.moveToFirst()) {
            do {
                tProd.add(new Producto(informacion.getString(0), informacion.getInt(1)));
            } while(informacion.moveToNext());
        }
        return tProd;
    }
}
