package com.example.gezuzm.imagencorporativa.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.gezuzm.imagencorporativa.R;
import com.example.gezuzm.imagencorporativa.adapter.MascotaAdaptador2;
import com.example.gezuzm.imagencorporativa.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
// clase creada automaticamente
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> arrayMascotas;
    private RecyclerView listaMascotas;     // para usarse como recurso local

/*
    public PerfilFragment() {
        // Required empty public constructor
    }
*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,   @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);


        // equivale al setcontentview
        // asocia la clase a la vista v es el layout ahora
        View v = inflater.inflate(R.layout.fragment_perfil, container, false );

        //asignar la referencia del recurso al recurso local
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas2);
        // declara un linearloyout para un mejor acomodo del RecyclerView
        //LinearLayoutManager llMascotas = new LinearLayoutManager(getActivity());
        //llMascotas.setOrientation(LinearLayout.VERTICAL); // requisito

        GridLayoutManager glMascotas = new GridLayoutManager(getActivity(),3);
        glMascotas.setOrientation(LinearLayout.VERTICAL); // requisito

        listaMascotas.setLayoutManager(glMascotas); // asignarlo al RecyclerView

        // de la clase mascotas
        InicializarListaMascotas();
        // iniciar el adaptador, es necesario para poder usar el RecyclerView
        inicializarAdaptador();



        return v;

    }


    private void InicializarListaMascotas() {
        // es nercesario tener una clase
        arrayMascotas = new ArrayList<Mascota>();

       /* arrayMascotas.add(new Mascota(R.drawable.el_escarador, "Escalador"));
        arrayMascotas.add(new Mascota(R.drawable.cochino_jabato, "Jabato"));
        arrayMascotas.add(new Mascota(R.drawable.feanor, "Feanor"));
        arrayMascotas.add(new Mascota(R.drawable.golden_dragoone, "Drago"));
        arrayMascotas.add(new Mascota(R.drawable.kuaku_, "Kuaku"));
        arrayMascotas.add(new Mascota(R.drawable.nomoon, "Nonito"));
        arrayMascotas.add(new Mascota(R.drawable.pekefux, "Pekefux"));
        arrayMascotas.add(new Mascota(R.drawable.tortuga, "Tortu"));*/
       // arrayMascotas.add(new Mascota(R.drawable.miaumiua_atigrado, "Miaumiau"));

        arrayMascotas.add(new Mascota(R.drawable.feanor, 2,R.drawable.hueso_silueta));
        arrayMascotas.add(new Mascota(R.drawable.feanor,3,R.drawable.hueso_silueta));
        arrayMascotas.add(new Mascota(R.drawable.feanor,4,R.drawable.hueso_silueta));
        arrayMascotas.add(new Mascota(R.drawable.feanor,3,R.drawable.hueso_silueta));
        arrayMascotas.add(new Mascota(R.drawable.feanor,0,R.drawable.hueso_silueta));
        arrayMascotas.add(new Mascota(R.drawable.feanor,1,R.drawable.hueso_silueta));
        arrayMascotas.add(new Mascota(R.drawable.feanor, 2,R.drawable.hueso_silueta));
        arrayMascotas.add(new Mascota(R.drawable.feanor,3,R.drawable.hueso_silueta));
        arrayMascotas.add(new Mascota(R.drawable.feanor,4,R.drawable.hueso_silueta));
    }


    private void inicializarAdaptador() {
        MascotaAdaptador2 adaptador = new MascotaAdaptador2(arrayMascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


}
