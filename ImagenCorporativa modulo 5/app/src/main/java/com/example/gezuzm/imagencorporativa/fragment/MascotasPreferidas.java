package com.example.gezuzm.imagencorporativa.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.gezuzm.imagencorporativa.R;
import com.example.gezuzm.imagencorporativa.adapter.MascotaAdaptador;
import com.example.gezuzm.imagencorporativa.pojo.Mascota;
import com.example.gezuzm.imagencorporativa.presentador.IMascotasPreferidasPresenter;
import com.example.gezuzm.imagencorporativa.presentador.MascotasPreferidasPresenter;

import java.util.ArrayList;

public class MascotasPreferidas extends AppCompatActivity implements IMascotasPreferidas {

    ArrayList<Mascota> arrayMascotas;
    private RecyclerView listaMascotas;     // para usarse como recurso local
    private IMascotasPreferidasPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_preferidas);

        // para habilitar el boton de subir
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        //asignar la referencia del recurso al recurso local
        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        presenter = new MascotasPreferidasPresenter(this,getBaseContext());
        //presenter = new RecyclerViewFragmentPresenter(this, getContext());

    }

  /*  private void InicializarListaMascotas()
    {
        // es nercesario tener una clase
        arrayMascotas = new ArrayList<Mascota>();

        arrayMascotas.add(new Mascota());
        arrayMascotas.add(new Mascota());
        arrayMascotas.add(new Mascota());
        arrayMascotas.add(new Mascota());
        arrayMascotas.add(new Mascota());
    }
    */

    @Override
    public void generarLinearLayoutVertical() {

        // declara un linearloyout para un mejor acomodo del RecyclerView
        LinearLayoutManager llMascotas = new LinearLayoutManager(this);
        llMascotas.setOrientation(LinearLayout.VERTICAL); // requisito
        listaMascotas.setLayoutManager(llMascotas); // asignarlo al RecyclerView

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

       // MascotaAdaptador adaptador = new MascotaAdaptador(arrayMascotas,this);
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);


        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {

        listaMascotas.setAdapter(adaptador);

    }
}
