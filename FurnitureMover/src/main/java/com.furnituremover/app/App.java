package com.furnituremover.app;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.service.FurnitureServiceImp;
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


         //App Controller
        //AppController appController = new AppController();



        //controllers are needed to handle the bottom (get, post, etc.) requests
        app.post("/createFurniture", furnitureController.createFurniture);

        app.get("/getfurnitureCount/{furniture_name}", furnitureController.selectFurnitureName);

        app.start();
    }
}
