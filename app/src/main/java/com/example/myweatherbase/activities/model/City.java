package com.example.myweatherbase.activities.model;

import android.widget.ImageView;

import java.io.Serializable;

public class City implements Serializable {
    public int id;
    public String name;
    public Coord coord;
    public String country;
    public int population;
    public int timezone;
    public int sunrise;
    public int sunset;
    public static City city;


    public City(String nam, Coord cord, int img){
        this.name=nam;
        this.coord=cord;

    }

    public Coord getCoord(){
        return coord;
    }
    public String getName(){
        return name;
    }

    public static City getCity(int index){
        return city;
    }


    @Override
    public String toString(){
        return name;
    }

}