package com.furnituremover.service;


import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.entitiy.Furniture;
import com.furnituremover.exceptions.EmptyValue;
import com.furnituremover.exceptions.NegativeValue;
import org.apache.commons.text.WordUtils;

import static java.sql.Types.NULL;

public class FurnitureServiceImp implements FurnitureServiceInt
{
    private final FurnitureDAOImp furnitureDAOImp;

    public FurnitureServiceImp(FurnitureDAOImp furnitureDAOImp) {
        this.furnitureDAOImp = furnitureDAOImp;
    }

    @Override
    public Furniture ServiceCreateFurniture(Furniture furniture)
    {
        //Business logic: if a house name or furniture name has multiple words, convert it to title-case
        if(furniture.getFurnitureName().matches(".*\\s+.*"))
        {
            WordUtils.capitalizeFully(furniture.getFurnitureName());
            furniture.setFurnitureName(furniture.getFurnitureName().replaceAll("\\s", ""));
        }
        else if(furniture.getFurnitureSize()<=0)
        {
            throw new NegativeValue("Furniture size cannot be zero or negative!");
        }
        else if(furniture.getFurnitureName().isEmpty())
        {
            throw new EmptyValue("Furniture name can't be blank");
        }
        else if(furniture.getFurnitureColor().isEmpty())
        {
            throw new EmptyValue("Furniture color can't be blank");
        }
        else if(furniture.getFurnitureSize() == NULL)
        {
            throw new EmptyValue("Furniture size can't be null");
        }
        return furnitureDAOImp.CreateFurniture(furniture);

    }

    @Override
    public int ServiceSelectFurnitureName(String furnitureName)
    {
        if(furnitureName.matches(".*\\s+.*"))
        {
            WordUtils.capitalizeFully(furnitureName);
            String name = furnitureName.replaceAll("\\s", "");
            return furnitureDAOImp.SelectFurnitureName(name);
        }
        else if(furnitureName.isEmpty())
        {
            throw new EmptyValue("Furniture name cannot be empty!");
        }
        return furnitureDAOImp.SelectFurnitureName(furnitureName);
    }
}
