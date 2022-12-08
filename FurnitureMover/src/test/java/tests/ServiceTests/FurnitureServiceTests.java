package tests.ServiceTests;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.entitiy.Furniture;
import com.furnituremover.exceptions.EmptyValue;
import com.furnituremover.service.FurnitureServiceImp;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FurnitureServiceTests
{
    public FurnitureDAOImp furnitureDAOImp;
    public FurnitureServiceImp furnitureServiceImp;
    public Furniture furniture;

    @Test
    public void ServiceCreateFurniture()
    {
        furniture = new Furniture(-1, -1, "couch", "cerulean", 24);
        Furniture resultingFurniture = furnitureServiceImp.ServiceCreateFurniture(furniture);
        Assert.assertNotEquals(resultingFurniture.getFurnitureId(), -1);
    }

    @Test(expectedExceptions = EmptyValue.class, expectedExceptionsMessageRegExp = "Furniture name can't be blank.")
    public void ServiceCreateFurnitureBlankName()
    {
        furniture = new Furniture(-1, -1, "", "cerulean", 24);
        furnitureServiceImp.ServiceCreateFurniture(furniture);
    }

    @Test(expectedExceptions = EmptyValue.class, expectedExceptionsMessageRegExp = "Furniture color can't be blank.")
    public void ServiceCreateFurnitureBlankColor()
    {
        furniture = new Furniture(-1, -1, "couch", "", 24);
        furnitureServiceImp.ServiceCreateFurniture(furniture);
    }

    @Test(expectedExceptions = EmptyValue.class, expectedExceptionsMessageRegExp = "Furniture size cannot be zero or negative!")
    public void ServiceCreateFurnitureSizeZero()
    {
        furniture = new Furniture(-1, -1, "couch", "cerulean", 0);
        furnitureServiceImp.ServiceCreateFurniture(furniture);
    }

    @Test(expectedExceptions = EmptyValue.class, expectedExceptionsMessageRegExp = "Furniture size cannot be zero or negative!")
    public void ServiceCreateFurnitureSizeNegative()
    {
        furniture = new Furniture(-1, -1, "couch", "cerulean", -1);
        furnitureServiceImp.ServiceCreateFurniture(furniture);
    }

    @Test
    public void ServiceSelectFurnitureNameNonexistent()
    {
        int resultingFurniture = furnitureServiceImp.ServiceSelectFurnitureName("carpet");
        Assert.assertEquals(resultingFurniture, 0);
    }

    @Test
    public void ServiceSelectFurnitureNamePositive()
    {
        int resultingFurniture = furnitureServiceImp.ServiceSelectFurnitureName("bar stool");
        Assert.assertEquals(resultingFurniture, 1);
    }

    @Test
    public void ServiceDisplaySingleHomes()
    {
        furnitureServiceImp.ServiceDisplayHomeFurniture("Asjsoifsn");
    }

}
