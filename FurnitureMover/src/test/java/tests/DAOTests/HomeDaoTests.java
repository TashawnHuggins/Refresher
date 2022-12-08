package tests.DAOTests;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.dao.HomeDAOImp;
import com.furnituremover.entitiy.Furniture;
import com.furnituremover.entitiy.Home;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

public class HomeDaoTests
{
    HomeDAOImp HomeDAO = new HomeDAOImp();

    @Test
    public void createHome()
    {
        Home newHome = new Home(-1,"Castlevania", 1500);
        Home resultingHome = HomeDAO.createHome(newHome);
        Assert.assertSame("Castlevania", resultingHome.getHomeName());
    }

    @Test
    public void displayAllHomes()
    {
        List<Home> result = HomeDAO.displayAllHomes();
        Assert.assertTrue(result.size() > 1);
    }
}
