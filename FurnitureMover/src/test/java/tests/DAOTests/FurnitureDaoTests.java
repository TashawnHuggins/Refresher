package tests.DAOTests;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.entitiy.Furniture;
import com.furnituremover.entitiy.Home;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class FurnitureDaoTests
{
    FurnitureDAOImp furnitureDAO = new FurnitureDAOImp();

    @Test
    public void CreateFurniture()
    {
        Furniture newFurniture = new Furniture(-1, -1, "desk", "orange", 6);
        Furniture resultingFurniture = furnitureDAO.CreateFurniture(newFurniture);
        Assert.assertTrue(resultingFurniture.getFurnitureId()!=-1);
    }

    //Returns the sum of the furniture names provided in the database
    @Test
    public void SelectFurnitureName()
    {
        int testFurniture = furnitureDAO.SelectFurnitureName("bar stool");
        Assert.assertEquals(testFurniture, 1);
    }

    @Test
    public void SelectFurnitureNameSuccess2()
    {
        int testFurniture = furnitureDAO.SelectFurnitureName("Couch");
        Assert.assertEquals( testFurniture, 3);
    }

    @Test
    public void SelectFurnitureNameNonexistent()
    {
        int testFurniture = furnitureDAO.SelectFurnitureName("jacuzzi");
        Assert.assertTrue(testFurniture == 0);
    }

    //***************************************************************
    @Test
    public void displayHomeFurniture() //home name, furniture id, furniture name, furniture size, home size
    {
        List<Furniture> result = furnitureDAO.displayHomeFurniture("Greenacres");
        Assert.assertTrue(result.size() >= 1);
    }




}
