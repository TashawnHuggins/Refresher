package tests.DAOTests;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.dao.HomeDAOImp;
import com.furnituremover.entitiy.Furniture;
import com.furnituremover.entitiy.Home;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HomeDaoTests
{
    HomeDAOImp HomeDAO = new HomeDAOImp();

    @Test
    public void createHome()
    {
        Home newHome = new Home(-1, -1, "Castlevannia", 1500);
        Home resultingHome = HomeDAO.createHome(newHome);
        Assert.assertTrue(resultingHome.getHomeId()!=-1);
    }

    @Test
    public void displayAllHomes()
    {
        List<Home> result = HomeDAO.displayAllHomes();
        Assert.assertTrue(result.size() > 1);
    }

    //***************************************************************
    @Test
    public void displaySingleHome() //home name, furniture id, furniture name, furniture size
    {
        Home result = HomeDAO.displaySingleHome("Greenacres");
        Assert.assertEquals(result.getHomeName(), "Greenacres");
    }
}
