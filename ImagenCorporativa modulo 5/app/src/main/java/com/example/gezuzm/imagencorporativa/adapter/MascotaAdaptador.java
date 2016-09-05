package com.example.gezuzm.imagencorporativa.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gezuzm.imagencorporativa.db.ConstructorMascotas;
import com.example.gezuzm.imagencorporativa.pojo.Mascota;
import com.example.gezuzm.imagencorporativa.R;

import java.util.ArrayList;

/**
 * Created by mauricio on 21/08/16.
 */

// clase indispesable para poder usar el RECYCLERVIEW
    // debe heredar de RecyclerView
    ///extends RecyclerView.Adapter<MascotaAdaptador.ContactoViewHolder>
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>  {

    ArrayList<Mascota> arrayMascotas;        // lista de las mascotas de tipo MASCOTA
    Activity activity;                  // tambien es necesaria una ACTIVIDAD

    // 4.- crear el constructor
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){

        this.arrayMascotas = mascotas;
        this.activity = activity;
    }

    // 1.- clase automatica al exterderla
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // le da vida al layout
        // convierte el card_view a un layout para manipularlo
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    // 2.- clase automatica
    @Override
    public int getItemCount() {
        return arrayMascotas.size();
    }


    // 3.-
    // llenar los recursos
    // sobreescribir esta clase que llenara el ViewHolder
    // se cambia el "primer parametro" de la clase estatica
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

        // obtiene la posicion del que se esta viendo
        final Mascota mascota =  arrayMascotas.get(position);

        // se envia los datos a los recursos
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFotoMascota());
        mascotaViewHolder.imgIconoLike.setImageResource(mascota.getImgIconoLike());
        mascotaViewHolder.tvnombreMascota.setText(mascota.getNombreMascota());
        mascotaViewHolder.imgIconoNoLike.setImageResource(mascota.getImgIconoNoLike());
        mascotaViewHolder.tvNoLike.setText(String.valueOf(mascota.getNoLike()));

        //
        // "EVENTOS"
        //
        // cuan se da click sobre el hueso
        mascotaViewHolder.imgIconoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  mascota.setNoLike(mascota.getNoLike() + 1);
               // mascotaViewHolder.tvNoLike.setText(String.valueOf(mascota.getNoLike()));
                //Toast.makeText(activity, "like..."  , Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas= new ConstructorMascotas(activity);

                constructorMascotas.darLikeMascota(mascota);

                mascotaViewHolder.tvNoLike.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));

            }
        });


        /*contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("Nombre", contacto.getNombre());
                intent.putExtra("Telefono",contacto.getTelefono());
                intent.putExtra("Email",contacto.getEmail());
                activity.startActivity(intent);
            }
        }); */

    }


    // Clase estatica para el RecycledView "requerida"
    // "RecyclerView.ViewHolder"
    // se hace primero antes de lo demas para poder heredar la clase padre de esta
    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgMascota;
        private ImageView imgIconoLike;
        private ImageView imgIconoNoLike;
        private TextView  tvnombreMascota;
        private TextView tvNoLike;

        // constructor
        public MascotaViewHolder(View itemView) {
            super(itemView);

            // elementos que ligan a los controles
            imgMascota = (ImageView)itemView.findViewById(R.id.imgMascota);
            imgIconoLike = (ImageView) itemView.findViewById(R.id.imgIconoLike);
            imgIconoNoLike = (ImageView)itemView.findViewById(R.id.imgIconoNoLike);
            tvnombreMascota = (TextView)itemView.findViewById(R.id.tvNombreMascota);
            tvNoLike = (TextView)itemView.findViewById(R.id.tvNoLike);
        }
    }

}
