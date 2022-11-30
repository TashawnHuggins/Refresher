package com.furnituremover.app;



import com.furnituremover.dao.HomeDAOImp;
import com.furnituremover.entitiy.Home;
import com.furnituremover.exceptions.InvalidInput;
import com.furnituremover.service.HomeServiceImp;
import com.google.gson.Gson;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class HomeController
{

    HomeServiceImp homeServiceImp;

    HomeDAOImp homeDAOImp = new HomeDAOImp();
    public HomeController()
    {
        homeServiceImp = new HomeServiceImp(homeDAOImp);
    }

    //Handler is a func. interface provided by Javelin
    //
    public Handler createHome = ctx ->{
        try{
            Gson gson = new Gson();
            String body = ctx.body();
            Home home = gson.fromJson(body, Home.class);
            Home result =  homeServiceImp.ServiceCreateHome(home);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(200);
        } catch (InvalidInput e){
            ctx.result(e.getMessage());
            ctx.status(405);
        }
    };

    //
    public Handler displayAllHomes = ctx ->{
        try{
            ArrayList<Home> homes = homeServiceImp.ServiceDisplayAllHomes();
            Gson gson = new Gson();
            String productJson = gson.toJson(homes);
            ctx.result(productJson);
            ctx.status(200);
        } catch (InvalidInput e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

    //
    public Handler displaySingleHome = ctx ->{
        try{
            String homeName = (ctx.pathParam("homeName"));
            Home home = homeServiceImp.ServiceDisplaySingleHome(homeName);
            Gson gson = new Gson();
            String productJson = gson.toJson(home);
            ctx.result(productJson);
            ctx.status(200);
        } catch (InvalidInput e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };
}
