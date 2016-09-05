package com.example.gezuzm.imagencorporativa.db;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.example.gezuzm.imagencorporativa.R;
import com.example.gezuzm.imagencorporativa.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mauricio on 04/09/16.
 */
public class ConstructorMascotas {

    private static final Integer LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {

        this.context = context;
    }

    public ArrayList<Mascota> ObtenerDatosMascotasPreferidas(){

        BaseDatos db = new BaseDatos(context);

        ArrayList<Mascota> mascotaTPM = db.obtenerUltimas5Mascotas();

        // eliminar los id que no esten en esta lista

        String ids = "";
        int contador  = 0;

        for (int i = 0 ; i < mascotaTPM.size(); i++)
        {
            if (ids == "")
            {
                ids =  String.valueOf( mascotaTPM.get(i).getId());
            }
            else
            {

                ids = ids + "," + String.valueOf( mascotaTPM.get(i).getId());
            }
            contador+=1;
        }

        if (ids != "")
        {
            db.BorrarMascotaSinLike(ids);

            Toast.makeText(context, "Solamente quedaron en la BD: " + String.valueOf(contador) + " Mascotas de id: " + ids, Toast.LENGTH_LONG).show();
        }

        return mascotaTPM;

    }



    public ArrayList<Mascota> ObtenerDatos(){

        /*
        ArrayList<Mascota> arrayMascotas = new ArrayList<Mascota>();

        arrayMascotas.add(new Mascota(R.drawable.el_escarador, "Escalador",2));
        arrayMascotas.add(new Mascota(R.drawable.cochino_jabato, "Jabato",3));
        arrayMascotas.add(new Mascota(R.drawable.feanor, "Feanor",5));
        arrayMascotas.add(new Mascota(R.drawable.golden_dragoone, "Drago",6));
        arrayMascotas.add(new Mascota(R.drawable.kuaku_, "Kuaku",2));
        arrayMascotas.add(new Mascota(R.drawable.nomoon, "Nonito",1));
        arrayMascotas.add(new Mascota(R.drawable.pekefux, "Pekefux",4));
        arrayMascotas.add(new Mascota(R.drawable.tortuga, "Tortu",0));
        arrayMascotas.add(new Mascota(R.drawable.miaumiua_atigrado, "Miaumiau",7));

        return arrayMascotas; */

        BaseDatos db = new BaseDatos(context);

        insertarCincoMascotas(db);

        Toast.makeText(context,"Inserto 5 Mascotas", Toast.LENGTH_LONG).show();

        ArrayList<Mascota> mascota_TMP =  db.obtenerTodasLasMascotas();

        Toast.makeText(context, "Ahora Hay " + String.valueOf(mascota_TMP.size())+ " Mascotas", Toast.LENGTH_LONG ).show();

        //return db.obtenerTodasLasMascotas();

        return mascota_TMP;

    }


    public void insertarCincoMascotas(BaseDatos db)
    {
        //
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Escalador");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_MASCOTA,R.drawable.el_escarador);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Jabato");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_MASCOTA,R.drawable.cochino_jabato);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Miaumiau");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_MASCOTA,R.drawable.miaumiua_atigrado);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Nonito");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_MASCOTA,R.drawable.nomoon);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Tortu");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMG_MASCOTA,R.drawable.tortuga);

        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NOLIKES, LIKE);

        db.insertarLikeMascota(contentValues);

    }

    public int obtenerLikesMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(context);

        return db.obtenerLikesMascota(mascota);

    }

}
