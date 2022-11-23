package com.furnituremover.dao;

import com.furnituremover.entitiy.Furniture;

public interface FurnitureDAOInt
{

    Furniture CreateFurniture(Furniture furniture);

    int SelectFurnitureName(String furnitureName);


}
