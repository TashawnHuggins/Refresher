package com.furnituremover.app;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args)
    {
        Javalin app = Javalin.create(config ->
        {
//            config.enableCorsForAllOrigins();
//            config.enableDevLogging();
        });

        //Furniture Controller
//        FurnitureDAO furnitureDAO = new FurnitureDAO();
//        FurnitureService furnitureService = new FurnitureService(furnitureDAO);
//        FurnitureController furnitureController = new FurnitureController(furnitureService);

        // App Controller
        //AppController appController = new AppController(app, furnitureController);

        app.start(8000);
    }
}
