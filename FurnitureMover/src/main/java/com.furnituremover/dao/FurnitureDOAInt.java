package com.furnituremover.dao;

import com.furnituremover.entitiy.Furniture;

public interface FurnitureDOAInt
{

    Furniture CreateFurniture(Furniture furniture);

    int SelectFurnitureName(String furnitureName);


}
