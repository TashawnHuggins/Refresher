package com.furnituremover.service;

import com.furnituremover.entitiy.Home;

import java.util.ArrayList;

public interface HomeServiceInt
{
    Home ServiceCreateHome(Home home);

    ArrayList<Home> ServiceDisplayAllHomes();

    Home ServiceDisplaySingleHome(String homeName);

}
