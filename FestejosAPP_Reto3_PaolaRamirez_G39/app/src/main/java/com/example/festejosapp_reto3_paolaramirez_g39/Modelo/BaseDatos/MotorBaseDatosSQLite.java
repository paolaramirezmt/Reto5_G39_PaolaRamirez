package com.example.festejosapp_reto3_paolaramirez_g39.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TABLA FAVORITOS
        db.execSQL("CREATE TABLE favoritos (id INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO favoritos VALUES (1, 'Vegetariana','TENEMOS TODO TIPO DE COMIDA PARA CATERING')");
        db.execSQL("INSERT INTO favoritos VALUES (2, 'Tres quesos','TE OFRECEMOS DECORACION PARA  TODO TIPO DE FIESTAS')");
        db.execSQL("INSERT INTO favoritos VALUES (3, 'Pollo Chanpiñones','INVITACIONES A TU MEDIDA, PARA TODOS TUS EVENTOS ESPECIALES')");

        //TABLA PRODUCTOS
        db.execSQL("CREATE TABLE productos (titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO productos VALUES ('Comida','TENEMOS TODO TIPO DE COMIDA PARA CATERING')");
        db.execSQL("INSERT INTO productos VALUES ('Decoracion','TE OFRECEMOS DECORACION PARA  TODO TIPO DE FIESTAS')");
        db.execSQL("INSERT INTO productos VALUES ('Tarjetas','INVITACIONES A TU MEDIDA, PARA TODOS TUS EVENTOS ESPECIALES')");

        //TABLA SERVICIOS
        db.execSQL("CREATE TABLE servicios (titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO servicios VALUES ('Musica','PONEMOS LA MUSICA A TU ESTILO PARA TU REUNION')");
        db.execSQL("INSERT INTO servicios VALUES ('Salones','OFRECEMOS UNA AMPLIA VARIEDAD DE SALONES PARA TODO TIPO DE REUNIONES')");
        db.execSQL("INSERT INTO servicios VALUES ('Meseros','MESEROS QUE  REPARTEN LA COMIDA Y ATIENDEN DE LA MEJOR MANERA')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE productos");
        db.execSQL("DROP TABLE servicios");
        onCreate(db);

    }
}
