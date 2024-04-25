package com.example.myweatherbase.activities.model;

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


    public City(String nam,Coord cord){
        this.name=nam;
        this.coord=cord;

    }

    public Coord coord(){
        return coord;
    }

    public static City getCity(int index){
        return city;
    }


    @Override
    public String toString(){
        return name;
    }

}