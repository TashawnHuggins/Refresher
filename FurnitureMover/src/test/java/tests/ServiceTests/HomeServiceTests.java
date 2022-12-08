package tests.ServiceTests;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.dao.HomeDAOImp;
import com.furnituremover.entitiy.Furniture;
import com.furnituremover.entitiy.Home;
import com.furnituremover.exceptions.*;
import com.furnituremover.service.FurnitureServiceImp;
import com.furnituremover.service.HomeServiceImp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeServiceTests
{
    public HomeDAOImp homeAOImp;
    public HomeServiceImp homeServiceImp;
    public Home home;

    @Test
    public void ServiceCreateHome()
    {
        home = new Home(-1, -1, "Belair", 1400);
        Home resultingHome = homeServiceImp.ServiceCreateHome(home);
        Assert.assertNotEquals(resultingHome.getHomeId(),-1);
    }

    @Test
    public void ServiceCreateHomeSpacedName()
    {
        home = new Home(-1, -1, "Hollow Hills", 1400);
        Home resultingHome = homeServiceImp.ServiceCreateHome(home);
        Assert.assertNotEquals(resultingHome.getHomeId(),-1);
    }

    @Test(expectedExceptions = EmptyValue.class, expectedExceptionsMessageRegExp = "Home name can't be blank.")
    public void ServiceCreateHomeBlankHomeName()
    {
        home = new Home(-1, -1, "", 1200);
        homeServiceImp.ServiceCreateHome(home);
    }

    @Test(expectedExceptions = ZeroValue.class, expectedExceptionsMessageRegExp = "Home size cannot be zero.")
    public void ServiceCreateHomeSizeZero()
    {
        home = new Home(-1, -1, "LaPlaya", 0);
        homeServiceImp.ServiceCreateHome(home);
    }


    @Test
    public void ServiceDisplaySingleHomes()
    {
        homeServiceImp.ServiceDisplaySingleHome("Asjsoifsn");
    }

    @Test
    public void ServiceDisplayAllHome()
    {
        Assert.assertFalse(homeServiceImp.ServiceDisplayAllHomes().isEmpty());
    }

}
