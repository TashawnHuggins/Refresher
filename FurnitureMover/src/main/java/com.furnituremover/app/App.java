package com.furnituremover.app;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.dao.HomeDAOImp;
import com.furnituremover.service.FurnitureServiceImp;
import com.furnituremover.service.HomeServiceImp;
import io.javalin.Javalin;

public class App {
    /*
    Javalin is used to handle receiving HTTP requests and returning HTTP responses
     */
    public static void main(String[] args)
    {
        //This is the Javalin object; the create method will call the lambda directly.
        Javalin app = Javalin.create(config ->
        {
            //this is a lambda that set up some logging basics, and get around some cors issues
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        //Furniture Controller
        FurnitureController furnitureController = new FurnitureController();

        FurnitureDAOImp furnitureDAOImp = new FurnitureDAOImp();
        FurnitureServiceImp furnitureServiceImp = new FurnitureServiceImp(furnitureDAOImp);


         //Home Controller
        HomeController homeController = new HomeController();

        HomeDAOImp homeDAOImp = new HomeDAOImp();
        HomeServiceImp homeServiceImp = new HomeServiceImp(homeDAOImp);


        //controllers are needed to handle the bottom (get, post, etc.) requests
        //Furniture
        app.post("/createFurniture", furnitureController.createFurniture);
        app.get("/selectFurnitureName/{furnitureName}", furnitureController.selectFurnitureName);

        //Home
        app.post("/createHome", homeController.createHome);
        app.get("/displayAllHomes", homeController.displayAllHomes);
        app.get("/displaySingleHome/{homeName}", homeController.displaySingleHome);

        app.start();
    }
}
