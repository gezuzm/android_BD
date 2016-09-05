package com.example.gezuzm.imagencorporativa.fragment;

import com.example.gezuzm.imagencorporativa.adapter.MascotaAdaptador;
import com.example.gezuzm.imagencorporativa.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mauricio on 04/09/16.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList <Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
