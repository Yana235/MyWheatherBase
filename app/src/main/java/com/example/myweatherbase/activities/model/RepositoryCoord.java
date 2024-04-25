package com.example.myweatherbase.activities.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCoord {

    private List<Coord> coord;

    private static RepositoryCoord instance;
    private RepositoryCoord(){
        coord=new ArrayList<>();
        coord.add(new Coord(39.1999323,-4.383741));

    }
    public static RepositoryCoord getInstance(){
        if(instance==null)
            instance=new RepositoryCoord();
        return instance;
    }

    public List<Coord> getAll(){
        return coord;
    }
    public Coord get(int index){return coord.get(index);}


}
