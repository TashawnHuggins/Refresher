package com.furnituremover.dao;

import com.furnituremover.entitiy.Furniture;
import com.furnituremover.entitiy.Home;

import java.util.ArrayList;

public interface FurnitureDAOInt
{

    Furniture CreateFurniture(Furniture furniture);

    int SelectFurnitureName(String furnitureName);

    ArrayList<Furniture> displayHomeFurniture(String homeName);
}
