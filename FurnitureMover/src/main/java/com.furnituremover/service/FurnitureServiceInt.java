package com.furnituremover.service;

import com.furnituremover.entitiy.Furniture;

public interface FurnitureServiceInt
{
    Furniture ServiceCreateFurniture(Furniture furniture);

    int ServiceSelectFurnitureName(String furnitureName);
}
