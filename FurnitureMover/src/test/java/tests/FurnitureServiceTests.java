package tests;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.entitiy.Furniture;
import com.furnituremover.service.FurnitureServiceImp;
import org.junit.Assert;
import org.junit.Test;

public class FurnitureServiceTests
{
    public FurnitureDAOImp furnitureDAOImp;
    public FurnitureServiceImp furnitureServiceImp;
    public Furniture furniture;

    @Test
    public void ServiceCreateFurniture()
    {
     //Test furniture name with spaces, test blank inputs
        furniture = new Furniture(-1, "couch", "cerulean", 24);
        Furniture resultingFurniture = furnitureServiceImp.ServiceCreateFurniture(furniture);
        Assert.assertNotEquals(resultingFurniture.getFurnitureId(),-1);
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
        Assert.assertEquals(resultingFurniture, 0);
    }


}
