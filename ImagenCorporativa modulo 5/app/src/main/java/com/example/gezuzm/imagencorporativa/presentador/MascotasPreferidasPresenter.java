package com.example.gezuzm.imagencorporativa.presentador;

import android.content.Context;
import android.widget.Toast;

import com.example.gezuzm.imagencorporativa.db.ConstructorMascotas;
import com.example.gezuzm.imagencorporativa.fragment.IMascotasPreferidas;
import com.example.gezuzm.imagencorporativa.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by mauricio on 04/09/16.
 */
public class MascotasPreferidasPresenter implements  IMascotasPreferidasPresenter {


    private Context context;
    private IMascotasPreferidas iMascotasPreferidas;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private boolean insertar ;


    public MascotasPreferidasPresenter(IMascotasPreferidas iMascotasPreferidas, Context context)
    {
        this.iMascotasPreferidas = iMascotasPreferidas;
        this.context = context;

        obtenerMascotasBaseDatos();

    }

    @Override
    public void obtenerMascotasBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);

       // mascotas = constructorMascotas.ObtenerDatos();
        mascotas = constructorMascotas.ObtenerDatosMascotasPreferidas();

        mostrarMascotasRV();

        if (mascotas.size() == 0)
        {
            Toast.makeText(context, "NO hay mascotas con favoritos",Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void mostrarMascotasRV() {

        iMascotasPreferidas.inicializarAdaptadorRV(iMascotasPreferidas.crearAdaptador(mascotas));

        iMascotasPreferidas.generarLinearLayoutVertical();

    }
}
