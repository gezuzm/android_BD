package com.example.gezuzm.imagencorporativa.pojo;

import com.example.gezuzm.imagencorporativa.R;

/**
 * Created by mauricio on 21/08/16.
 */
public class Mascota {

    private int id;     // modelo VISTA-PRESENTADOR
    private int imgMascota;
    private int imgIconoLike;
    private int imgIconoNoLike;
    private String nombreMascota;
    private int noLike;


    // para modelo VISTA-PRESENTADOR
    public Mascota(int imgMascota, String nombreMascota, int noLike)
    {
        this.imgMascota = imgMascota;
        this.imgIconoLike = R.drawable.hueso_nosilueta;
        this.imgIconoNoLike = R.drawable.hueso_silueta ;
        this.nombreMascota = nombreMascota;
        this.noLike = noLike;
    }



        public Mascota()
        {
        this.imgMascota = imgMascota;
        this.imgIconoLike = R.drawable.hueso_nosilueta;
        this.imgIconoNoLike = R.drawable.hueso_silueta ;
        this.nombreMascota = nombreMascota;
        this.noLike = 0;
    }

    public Mascota(int imgMascota, int noLike, int imgIconoNoLike )
    {
        this.imgMascota = imgMascota;
        //this.imgIconoLike = R.drawable.hueso_nosilueta;
        this.imgIconoNoLike = imgIconoNoLike ;
       // this.nombreMascota = nombreMascota;
        this.noLike = noLike;
    }

    public int getFotoMascota() {
        return imgMascota;
    }

    public void setFotoMascota(int imgMascota) {
        this.imgMascota = imgMascota;
    }

    public int getImgIconoLike() {
        return imgIconoLike;
    }

    public void setImgIconoLike(int imgIconoLike) {
        this.imgIconoLike = imgIconoLike;
    }

    public int getImgIconoNoLike() {
        return imgIconoNoLike;
    }

    public void setImgIconoNoLike(int imgIconoNoLike) {
        this.imgIconoNoLike = imgIconoNoLike;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getNoLike() {
        return noLike;
    }

    public void setNoLike(int noLike) {
        this.noLike = noLike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
