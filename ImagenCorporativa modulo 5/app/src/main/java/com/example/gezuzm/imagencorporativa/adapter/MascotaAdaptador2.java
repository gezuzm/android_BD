package com.example.gezuzm.imagencorporativa.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gezuzm.imagencorporativa.R;
import com.example.gezuzm.imagencorporativa.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mauricio on 28/08/16.
 */
public class MascotaAdaptador2 extends RecyclerView.Adapter<MascotaAdaptador2.MascotaViewHolder> {

    ArrayList<Mascota> arrayMascotas;        // lista de las mascotas de tipo MASCOTA
    Activity activity;                  // tambien es necesaria una ACTIVIDAD

    // 4.- crear el constructor
    public MascotaAdaptador2(ArrayList<Mascota> mascotas, Activity activity){

        this.arrayMascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaAdaptador2.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // le da vida al layout
        // convierte el card_view a un layout para manipularlo
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota2, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaAdaptador2.MascotaViewHolder mascotaViewHolder, int position) {

        // obtiene la posicion del que se esta viendo
        final Mascota mascota2 =  arrayMascotas.get(position);

        // se envia los datos a los recursos
        // imagen Mascota
        mascotaViewHolder.imgMascota2.setImageResource(mascota2.getFotoMascota());
        // icono hueso blanco para el click
       // mascotaViewHolder2.imgIconoLike.setImageResource(mascota.getImgIconoLike());
        //mascotaViewHolder2.tvnombreMascota.setText(mascota.getNombreMascota());
        // icono likes
        mascotaViewHolder.imgIconoNoLike2.setImageResource(mascota2.getImgIconoNoLike());
        // no. de likes
        mascotaViewHolder.tvNoLike2.setText(String.valueOf(mascota2.getNoLike()));
    }

    @Override
    public int getItemCount() {
        return arrayMascotas.size();
    }

    // Clase estatica para el RecycledView "requerida"
    // "RecyclerView.ViewHolder"
    // se hace primero antes de lo demas para poder heredar la clase padre de esta
    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgMascota2;
       // private ImageView imgIconoLike;
        private ImageView imgIconoNoLike2;
        //private TextView tvnombreMascota;
        private TextView tvNoLike2;

        // constructor
        public MascotaViewHolder(View itemView) {
            super(itemView);

            // elementos que ligan a los controles
            imgMascota2 = (ImageView)itemView.findViewById(R.id.imgMascota2);
          //  imgIconoLike = (ImageView) itemView.findViewById(R.id.imgIconoLike);
            imgIconoNoLike2 = (ImageView)itemView.findViewById(R.id.imgIconoNoLike2);
           // tvnombreMascota = (TextView)itemView.findViewById(R.id.tvNombreMascota);
            tvNoLike2 = (TextView)itemView.findViewById(R.id.tvNoLike2);
        }
    }

}
