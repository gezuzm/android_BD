package com.example.gezuzm.imagencorporativa.presentador;

import android.content.Context;

import com.example.gezuzm.imagencorporativa.db.ConstructorMascotas;
import com.example.gezuzm.imagencorporativa.fragment.IRecyclerViewFragmentView;
import com.example.gezuzm.imagencorporativa.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mauricio on 04/09/16.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;

    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;

        obtenerMascotasBaseDatos();

    }

    @Override
    public void obtenerMascotasBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);

        mascotas = constructorMascotas.ObtenerDatos();

        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {

        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));

        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

}
