package com.furnituremover.service;


import com.furnituremover.entitiy.Furniture;

public class FurnitureServiceImp implements FurnitureServiceInt
{

    @Override
    public Furniture ServiceCreateFurniture(Furniture furniture)
    {
        //business logic: a home can't have furniture totaling more than half the size of a home
        //Business logic: if a house name or furniture name has multiple words, convert it to titlecase
        return null;
    }

    @Override
    public int ServiceSelectFurnitureName(String furnitureName)
    {
        //My business logic: furniture name must be a string; can't be an integer
        // do we have to convert to titlecase?
        return 0;
    }
}
