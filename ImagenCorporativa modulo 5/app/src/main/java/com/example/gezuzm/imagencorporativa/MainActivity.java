package com.example.gezuzm.imagencorporativa;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gezuzm.imagencorporativa.adapter.PageAdapter;
import com.example.gezuzm.imagencorporativa.fragment.MascotasPreferidas;
import com.example.gezuzm.imagencorporativa.fragment.PerfilFragment;
import com.example.gezuzm.imagencorporativa.fragment.RecyclerViewFragment;
import com.example.gezuzm.imagencorporativa.pojo.Mascota;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> arrayMascotas;
    private RecyclerView listaMascotas;     // para usarse como recurso local

    // para el FRAGMENT, utilizar los view
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    /////////////////////////////////

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // variables locales
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        if (toolbar != null)
        {
            //    marca error
            //    setSupportActionBar(toolbar);
        }

        // conecta los "fragments" y el "viewPager"
        setUpViewPager();

        /*  pasado a archivo FRAGMENT
        //asignar la referencia del recurso al recurso local
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        // declara un linearloyout para un mejor acomodo del RecyclerView
        LinearLayoutManager llMascotas = new LinearLayoutManager(this);
        llMascotas.setOrientation(LinearLayout.VERTICAL); // requisito
        listaMascotas.setLayoutManager(llMascotas); // asignarlo al RecyclerView

        // de la clase mascotas
        InicializarListaMascotas();
        // iniciar el adaptador, es necesario para poder usar el RecyclerView
        inicializarAdaptador();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
*/
    }

    // crea los FRAGMENTS
    private ArrayList<Fragment> agregarFragments()
    {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    // poner en orbita los fragments
    // 1.- configurar el VIEWPAGER
    // 2.- lo agrega al TABLELAYOUT
    private void setUpViewPager()
    {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name_dog);

    }

    /*
    private void InicializarListaMascotas() {
        // es nercesario tener una clase
        arrayMascotas = new ArrayList<Mascota>();

        arrayMascotas.add(new Mascota(R.drawable.el_escarador, "Escalador"));
        arrayMascotas.add(new Mascota(R.drawable.cochino_jabato, "Jabato"));
        arrayMascotas.add(new Mascota(R.drawable.feanor, "Feanor"));
        arrayMascotas.add(new Mascota(R.drawable.golden_dragoone, "Drago"));
        arrayMascotas.add(new Mascota(R.drawable.kuaku_, "Kuaku"));
        arrayMascotas.add(new Mascota(R.drawable.nomoon, "Nonito"));
        arrayMascotas.add(new Mascota(R.drawable.pekefux, "Pekefux"));
        arrayMascotas.add(new Mascota(R.drawable.tortuga, "Tortu"));
        arrayMascotas.add(new Mascota(R.drawable.miaumiua_atigrado, "Miaumiau"));
    }


    private void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(arrayMascotas, this);
        listaMascotas.setAdapter(adaptador);

    }

*/
    // ir a la segunda actividad
    private void IrMascotasPreferidas() {
        Intent intent = new Intent(this, MascotasPreferidas.class);

        startActivity(intent);

    }


    // este metodo creara el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // MENU NORMAL
        getMenuInflater().inflate(R.menu.menu_opciones,menu);

        getMenuInflater().inflate(R.menu.menu_action_view, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId())
        {

            case R.id.mIrMascotasPreferidas:

                intent = new Intent(this,MascotasPreferidas.class );
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                intent = new Intent(this,AcercaDeActivity.class );
                startActivity(intent);
                break;

            case R.id.mContacto:
                intent = new Intent(this,ContactoActivity.class );
                startActivity(intent);
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    /*



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.gezuzm.imagencorporativa/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.gezuzm.imagencorporativa/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    } */
}
