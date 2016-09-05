package com.example.gezuzm.imagencorporativa.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gezuzm.imagencorporativa.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mauricio on 04/09/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

private  Context context;


    // se personaliza
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);

        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "( " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_ID   +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT ,"  +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_IMG_MASCOTA + " INTEGER "  +
                                        " )";

        String queryCrearTablaLikesMascota = " CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS + " ( " +
                                             ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                             ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " INTEGER, " +
                                             ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NOLIKES + " INTEGER, " +
                                             " FOREIGN KEY("  +  ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " ) " +
                                             " REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + " ( " + ConstantesBaseDatos.TABLE_MASCOTAS_ID  + " ) " +
                                             " ) ";


        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS);

        onCreate(db);
    }

/*
    public ArrayList<Mascota>  obtenerTodasLasMascotas()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();


        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);


        while (registros.moveToNext())
        {
            Mascota mascotaActual = new Mascota();

            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombreMascota(registros.getString(1));
            mascotaActual.setFotoMascota(registros.getInt(2));

            String querylikes = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NOLIKES + " ) as likes " +
                    "FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " = " +
                    mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(querylikes, null);

            if (registrosLikes.moveToNext())
            {
                mascotaActual.setNoLike(registrosLikes.getInt(0));

            }
            else
            {

                mascotaActual.setNoLike(0);
            }

            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    } */

    public ArrayList<Mascota>  obtenerUltimas5Mascotas()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext())
        {
            Mascota mascotaActual = new Mascota();

            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombreMascota(registros.getString(1));
            mascotaActual.setFotoMascota(registros.getInt(2));

            String querylikes = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NOLIKES + " ) as likes " +
                    "FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " = " +
                    mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(querylikes, null);

            if (registrosLikes.moveToNext())
            {
                mascotaActual.setNoLike(registrosLikes.getInt(0));

                if( (registrosLikes.getInt(0)) > 0)
                {
                    mascotas.add(mascotaActual);
                }
            }
            else
            {

                mascotaActual.setNoLike(0);
            }

            if (mascotas.size() > 4)
            {
                db.close();

                return mascotas;
            }
            //mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }




    public ArrayList<Mascota>  obtenerTodasLasMascotas()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query,null);


        while (registros.moveToNext())
        {
            Mascota mascotaActual = new Mascota();

            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombreMascota(registros.getString(1));
            mascotaActual.setFotoMascota(registros.getInt(2));

            String querylikes = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NOLIKES + " ) as likes " +
                                "FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " = " +
                                mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(querylikes, null);

            if (registrosLikes.moveToNext())
            {
                mascotaActual.setNoLike(registrosLikes.getInt(0));

            }
            else
            {

                mascotaActual.setNoLike(0);
            }

            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    }


    public  void insertarMascota(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        // metodo ya definido
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);

        db.close();
    }


    public void insertarLikeMascota(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS, null, contentValues);

        db.close();

    }

    public int obtenerLikesMascota(Mascota mascota)
    {
        int likes = 0;
        String query = "SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NOLIKES + ") " +
                      " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                      " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " = " +
                      mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext())
        {

            likes += registros.getInt(0);
        }

        db.close();

        return likes;

    }


    public int BorrarMascotaSinLike(String ids)
    {
        int likes = 0;

        String query = "DELETE FROM " + ConstantesBaseDatos.TABLE_MASCOTAS  +
                       " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + " NOT IN  (" +
                        ids + ")";

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(query);

        db.close();

        return likes;

    }

}
