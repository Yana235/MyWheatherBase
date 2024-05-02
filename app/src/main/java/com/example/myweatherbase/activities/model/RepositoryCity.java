package com.example.myweatherbase.activities.model;

import com.example.myweatherbase.R;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCity {

    private List<City> ciudades;

    private static RepositoryCity instance;
    private RepositoryCity(){
        ciudades=new ArrayList<>();
        ciudades.add(new City("Madrid",new Coord(39.1999323,-4.383741), R.mipmap.ic_madrid_foreground));
        ciudades.add(new City("Murcia",new Coord(37.9805037,-1.1271753), R.mipmap.ic_murcia_foreground));
        ciudades.add(new City("Barcelona",new Coord(37.9804102,-1.2507862), R.mipmap.ic_barcelona_foreground));
        ciudades.add(new City("Valencia",new Coord(39.407669,-0.5263215), R.mipmap.ic_valencia_foreground));

    }
    public static RepositoryCity getInstance(){
        if(instance==null)
            instance=new RepositoryCity();
        return instance;
    }

    public List<City> getAll(){
        return ciudades;
    }
    public City get(int index){return ciudades.get(index);}
    public void add(City city) { ciudades.add(city); }



}
