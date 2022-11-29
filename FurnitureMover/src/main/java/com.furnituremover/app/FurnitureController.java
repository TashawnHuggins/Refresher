package com.furnituremover.app;

import com.furnituremover.dao.FurnitureDAOImp;
import com.furnituremover.entitiy.Furniture;
import com.furnituremover.service.FurnitureServiceImp;
import com.google.gson.Gson;
import io.javalin.http.Handler;

public class FurnitureController
{
//    FurnitureServiceImp furnitureServiceImp;
//    FurnitureDAOImp furnitureDAOImp = new FurnitureDAOImp();
//    public FurnitureController()
//    {
//        furnitureServiceImp = new FurnitureServiceImp(furnitureDAOImp);
//
//    }
//
    //Handler is a func. interface provided by javalin
    //Handler takes
//    public Handler createFurniture = ctx ->{
//        try{
//            Gson gson = new Gson();
//            String body = ctx.body();
//            Furniture furniture = gson.fromJson(body, Furniture.class);
//            Furniture result =  furnitureServiceImp.ServiceCreateFurniture(furniture);
//            String resultJson = gson.toJson(result);
//            ctx.result(resultJson);
//            ctx.status(200);
////        } catch (BadInput e){
////            ctx.result(e.getMessage());
////            ctx.status(405);
////        }
//    };
//
//    public Handler selectFurnitureName = ctx ->{
//        try{
//            String furnitureName = (ctx.pathParam("furnitureName"));
//            int furniture = furnitureServiceImp.ServiceSelectFurnitureName(furnitureName);
//            Gson gson = new Gson();
//            String productJson = gson.toJson(furniture);
//            ctx.result(productJson);
//            ctx.status(200);
////        } catch (IdNotFound e){
////            ctx.result(e.getMessage());
////            ctx.status(404);
////        }
//    };


}
