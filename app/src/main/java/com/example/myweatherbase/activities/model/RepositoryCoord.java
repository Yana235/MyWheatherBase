package com.example.myweatherbase.activities.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCoord {

    private List<City> ciudades;

    private static RepositoryCoord instance;
    private RepositoryCoord(){
        ciudades=new ArrayList<>();
        ciudades.add(new City("Madrid",new Coord(39.1999323,-4.383741)));
        ciudades.add(new City("Murcia",new Coord(37.9805037,-1.1271753)));
        ciudades.add(new City("Barcelona",new Coord(37.9804102,-1.2507862)));
        ciudades.add(new City("Valencia",new Coord(39.407669,-0.5263215)));

    }
    public static RepositoryCoord getInstance(){
        if(instance==null)
            instance=new RepositoryCoord();
        return instance;
    }

    public List<City> getAll(){
        return ciudades;
    }
    public City get(int index){return ciudades.get(index);}
    public void add(City city) { ciudades.add(city); }



}
