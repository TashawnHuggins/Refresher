package com.furnituremover.dao;

import com.furnituremover.entitiy.Furniture;
import com.furnituremover.utility.ConnectionDB;

import java.sql.*;

public class FurnitureDOAImp implements FurnitureDOAInt{

    @Override
    public Furniture CreateFurniture(Furniture furniture)
    {
        try (Connection connection = ConnectionDB.createConnection())
        {
            String sql = "insert into furniture values(default,? ,?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, furniture.getFurnitureId());
            ps.setString(2, furniture.getFurnitureName());
            ps.setString(3, furniture.getFurnitureColor());
            ps.setInt(4, furniture.getFurnitureSize());
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
            String sql = "select count (furniture_name) from furniture where furnitureName = ?";
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
}
