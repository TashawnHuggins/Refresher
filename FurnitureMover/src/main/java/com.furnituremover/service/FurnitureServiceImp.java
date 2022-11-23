package com.furnituremover.service;


import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.entitiy.Furniture;
import org.apache.commons.text.WordUtils;

public class FurnitureServiceImp implements FurnitureServiceInt
{
    private final FurnitureDAOImp furnitureDAOImp;

    public FurnitureServiceImp(FurnitureDAOImp furnitureDAOImp) {
        this.furnitureDAOImp = furnitureDAOImp;
    }

    @Override
    public Furniture ServiceCreateFurniture(Furniture furniture)
    {
        //business logic: a home can't have furniture totaling more than half the size of a home
        //Business logic: if a house name or furniture name has multiple words, convert it to titlecase

        if(furniture.getFurnitureName().matches(".*\\s+.*"))
        {
            WordUtils.capitalizeFully(furniture.getFurnitureName());
            furniture.setFurnitureName(furniture.getFurnitureName().replaceAll("\\s", ""));
        }
//        else if(furniture.getFurnitureSize()<0)
//        {
//            furniture.getFurnitureSize();
//        }
          return furnitureDAOImp.CreateFurniture(furniture);

    }

    @Override
    public int ServiceSelectFurnitureName(String furnitureName)
    {
        //My business logic: furniture name must be a string; can't be an integer
        if(furnitureName.matches(".*\\s+.*"))
        {
            WordUtils.capitalizeFully(furnitureName);
            String name = furnitureName.replaceAll("\\s", "");
            return furnitureDAOImp.SelectFurnitureName(name);
        }

        else
            return 0;
    }
}
