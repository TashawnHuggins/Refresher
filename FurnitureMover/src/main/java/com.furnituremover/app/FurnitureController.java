package com.furnituremover.app;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.entitiy.Furniture;
import com.furnituremover.entitiy.Home;
import com.furnituremover.exceptions.EmptyValue;
import com.furnituremover.exceptions.InvalidInput;
import com.furnituremover.exceptions.NegativeValue;
import com.furnituremover.service.FurnitureServiceImp;
import com.google.gson.Gson;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FurnitureController
{
    public static Logger logger = LogManager.getLogger(FurnitureController.class);

    FurnitureServiceImp furnitureServiceImp;
    FurnitureDAOImp furnitureDAOImp = new FurnitureDAOImp();
    public FurnitureController()
    {
        furnitureServiceImp = new FurnitureServiceImp(furnitureDAOImp);
    }

    //Handler is a func. interface provided by javalin
    //Handler takes
    public Handler createFurniture = ctx ->{
        try{
            logger.info("Starting process of getting furniture name and size from the user");
            logger.info("Getting the body of the request");
            String body = ctx.body(); //gets body of request
            Gson gson = new Gson(); //Gson converts java objects to Json and vice versa
            Furniture furniture = gson.fromJson(body, Furniture.class);
            Furniture result =  furnitureServiceImp.ServiceCreateFurniture(furniture);
            logger.info("converting furniture object to JSON");
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        }
        catch (InvalidInput | NegativeValue | EmptyValue e)
        {
            ctx.result(e.getMessage());
            ctx.status(400);
        }

    };

    //returns a count of furniture
    public Handler selectFurnitureName = ctx ->{
        try{
            logger.info("Getting the furnitureName from the path parameter");
            String furnitureName = (ctx.pathParam("furnitureName"));
            int furniture = furnitureServiceImp.ServiceSelectFurnitureName(furnitureName);
            Gson gson = new Gson();
            String productJson = gson.toJson(furniture);
            ctx.result(productJson);
            ctx.status(200);
        } catch (InvalidInput e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    //
    public Handler displayHomeFurniture = ctx ->{
        try{
            String homeName = (ctx.pathParam("homeName"));
            ArrayList<Furniture> furniture = furnitureServiceImp.ServiceDisplayHomeFurniture(homeName);
            Gson gson = new Gson();
            String productJson = gson.toJson(furniture);
            ctx.result(productJson);
            ctx.status(200);
        } catch (InvalidInput e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };


}
