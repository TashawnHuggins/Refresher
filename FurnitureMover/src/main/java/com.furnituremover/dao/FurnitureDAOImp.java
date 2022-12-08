package com.furnituremover.dao;

import com.furnituremover.entitiy.Furniture;
import com.furnituremover.utility.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;


public class FurnitureDAOImp implements FurnitureDAOInt {

    @Override
    public Furniture CreateFurniture(Furniture furniture)
    {
        try (Connection connection = ConnectionDB.createConnection())
        {
            String sql = "insert into furniture values(default,NULL,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1, furniture.getFurnitureId());
            //ps.setInt(2, furniture.setHomeId(NULL));
            ps.setString(1, furniture.getFurnitureName());
            ps.setString(2, furniture.getFurnitureColor());
            ps.setInt(3, furniture.getFurnitureSize());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            furniture.setFurnitureId(rs.getInt("furniture_id"));
            return furniture;

        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int SelectFurnitureName(String furnitureName)
    {
        try (Connection connection = ConnectionDB.createConnection())
        {
            String sql = "select count (furniture_name) from furniture where furniture_name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, furnitureName);

            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next())
            {
                count++;
            };
            return count;


        } catch (SQLException e){
            System.out.println(e);
            return 0;
        }
    }

    //Displays a home's furniture's name and size.
    @Override
    public ArrayList<Furniture> displayHomeFurniture(String homeName)
    {
        try (Connection connection = ConnectionDB.createConnection())
        {
            String sql = "select furniture.home_name, furniture.furniture_color, furniture.furniture_size inner join home on furniture.home_id = home.home_id where home_name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, homeName);

            ResultSet rs = ps.getResultSet();  //furnitureId, homeId, furnitureName, furnitureColor, furnitureSize
            ArrayList <Furniture> furnitures = new ArrayList<>();
            while (rs.next()) {
                Furniture furniture = new Furniture(
                        rs.getInt("furniture_id"),
                        rs.getInt("home_id"),
                        rs.getString("furniture_name"),
                        rs.getString("furniture_color"),
                        rs.getInt("furniture_size")
                );
                furnitures.add(furniture);
            }

            return furnitures; //see names and sizes of all furnitures in a home

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
