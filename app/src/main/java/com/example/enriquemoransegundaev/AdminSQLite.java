package com.example.enriquemoransegundaev;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLite extends SQLiteOpenHelper {
    private String sqlCreate = "CREATE TABLE persona (nombre text PRIMARY KEY,apellidos text)";


    AdminSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);

    }

    @Override

    //Creamos las tablas
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }
    // Pasar de los datos antiguos a los nuevos en este caso borramos la tabla y creamos una nueva
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //borramos
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS articulos");
        //creamos
        sqLiteDatabase.execSQL(sqlCreate);

    }
}