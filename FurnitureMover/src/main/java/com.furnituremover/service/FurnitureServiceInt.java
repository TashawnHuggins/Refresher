package com.furnituremover.service;

import com.furnituremover.entitiy.Furniture;
import com.furnituremover.entitiy.Home;
import com.furnituremover.exceptions.EmptyValue;

import java.util.ArrayList;

public interface FurnitureServiceInt
{
    Furniture ServiceCreateFurniture(Furniture furniture);

    int ServiceSelectFurnitureName(String furnitureName);

    ArrayList<Furniture> ServiceDisplayHomeFurniture(String homeName);
}
