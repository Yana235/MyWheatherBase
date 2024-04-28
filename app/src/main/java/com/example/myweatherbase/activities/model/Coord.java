package com.example.myweatherbase.activities.model;

import java.io.Serializable;

public class Coord implements Serializable {
    public double lat;
    public double lon;

    public Coord(double latitud,double longitud){
        this.lat=latitud;
        this.lon=longitud;
    }


    @Override
    public String toString(){
        return "&lat="+lat+"&lon="+lon;
    }


}
