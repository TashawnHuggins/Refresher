package tests;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.entitiy.Furniture;
import org.junit.Assert;
import org.junit.Test;

public class FurnitureDaoTests
{
    FurnitureDAOImp furnitureDAO = new FurnitureDAOImp();

    @Test
    public void CreateFurniture()
    {
        Furniture newFurniture = new Furniture(-1, "desk", "orange", 6);
        Furniture resultingFurniture = furnitureDAO.CreateFurniture(newFurniture);
        Assert.assertTrue(resultingFurniture.getFurnitureId()!=-1);
    }

    //Returns the sum of the furniture names provided in the database
    @Test
    public void SelectFurnitureName()
    {
        int testFurniture = furnitureDAO.SelectFurnitureName("bar stool");
        Assert.assertEquals(1, testFurniture);
    }

    @Test
    public void SelectFurnitureNameNonexistent()
    {
        int testFurniture = furnitureDAO.SelectFurnitureName("jacuzzi");
        Assert.assertEquals(0, testFurniture);
    }





}
