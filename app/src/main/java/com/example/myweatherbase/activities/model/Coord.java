package com.example.myweatherbase.activities.model;

import java.io.Serializable;

public class Coord implements Serializable {
    public double lat;
    public double lon;

    public Coord(double latitud,double longitud){
        this.lat=latitud;
        this.lon=longitud;
    }

    public Double getLat(){
        return lat;
    }
    public Double getLon(){
        return lat;
    }
    @Override
    public String toString(){
        return ""+lat+lon;
    }


}
