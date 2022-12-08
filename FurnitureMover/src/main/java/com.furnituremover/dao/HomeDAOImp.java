package com.furnituremover.dao;

import com.furnituremover.entitiy.Home;
import com.furnituremover.utility.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;

public class HomeDAOImp implements HomeDAOInt
{

    @Override
    public Home createHome(Home home)
    {
        try (Connection connection = ConnectionDB.createConnection())
        {
            String sql = "insert into home values(default,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1, home.getHomeId());
            ps.setString(1, home.getHomeName());
            ps.setInt(2, home.getHomeSize());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            //home.setHomeId(rs.getInt("home_id"));
            return home;

        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }

    //Displays all homes' names and sizes
    @Override
    public ArrayList<Home> displayAllHomes()
    {
        try (Connection connection = ConnectionDB.createConnection())
        {
            String sql = "select * from home";
            Statement s = connection.createStatement();
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            ArrayList<Home> homes = new ArrayList<>();
            while (rs.next()) {
                Home home = new Home(
                        rs.getInt("home_id"),
                        rs.getString("home_name"),
                        rs.getInt("home_size")
                );
                homes.add(home);
            }
            return homes;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
