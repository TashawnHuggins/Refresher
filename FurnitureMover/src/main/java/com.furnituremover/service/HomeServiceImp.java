package com.furnituremover.service;

import com.furnituremover.dao.HomeDAOImp;
import com.furnituremover.entitiy.Home;
import com.furnituremover.exceptions.EmptyValue;
import com.furnituremover.exceptions.ZeroValue;
import org.apache.commons.text.WordUtils;

import java.util.ArrayList;

public class HomeServiceImp implements HomeServiceInt
{
    private final HomeDAOImp homeDAOImp;

    public HomeServiceImp(HomeDAOImp homeDAOImp)
    {
        this.homeDAOImp = homeDAOImp;
    }


    @Override
    public Home ServiceCreateHome(Home home)
    {
        //Business logic: if a house name has multiple words, convert it to titlecase
        if(home.getHomeName().matches(".*\\s+.*"))
        {
            WordUtils.capitalizeFully(home.getHomeName());
            String name = home.getHomeName().replaceAll("\\s", "");
            home.setHomeName(name);
            return homeDAOImp.createHome(home);
        }
        else if(home.getHomeName().isEmpty())
        {
            throw new EmptyValue("Home name can't be blank.");
        }
        else if(home.getHomeSize()==0)
        {
            throw new ZeroValue("Home size cannot be zero.");
        }
        //business logic: a home can't have furniture totaling more than half the size of a home
        //if furniture.getFurnitureSize > (sum of furniture_size in a home)/2

//        else if(home.getFurnitureSize() > )
//        {
//            throw new NoSpace("Limit reached: the house cannot hold any more furniture of this size");
//        }
        return homeDAOImp.createHome(home);
    }

    @Override
    public ArrayList<Home> ServiceDisplayAllHomes()
    {
        return homeDAOImp.displayAllHomes();
    }

    @Override
    public Home ServiceDisplaySingleHome(String homeName)
    {
        if(homeName.isEmpty())
        {
            throw new EmptyValue("Home name can't be empty");
        }
        return homeDAOImp.displaySingleHome(homeName);
    }
}
