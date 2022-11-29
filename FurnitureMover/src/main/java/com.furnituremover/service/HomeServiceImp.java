package com.furnituremover.service;

import com.furnituremover.dao.HomeDAOImp;
import com.furnituremover.entitiy.Home;
import org.apache.commons.text.WordUtils;

import java.util.ArrayList;

public class HomeServiceImp implements HomeServiceInt
{
    HomeDAOImp  homeDAOImp;

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
            return homeDAOImp.createHome(home);
        }
        if(home.getHomeSize()==0)
        {

        }
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
        return homeDAOImp.displaySingleHome(homeName);
    }
}
