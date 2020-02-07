package in.coder.dao;
import in.coder.*;

import in.coder.pojo.*;
import in.coder.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class FoodDaoImpl implements FoodDao
{
Connection conn=null;
public boolean addFood(Food f)
{
	try
	{
		conn=DBConnection.getDBConnect();
		String sql="insert into Food_Arif(FoodName,FoodPrice,FoodType) values(?,?,?)";  //Establishing the connection
		PreparedStatement ps=conn.prepareStatement(sql);     // Creating the Statement
		ps.setString(1, f.getFoodName());                    // getting and setting food name from pojo
		ps.setDouble(2, f.getFoodPrice());                   // getting and setting food price from pojo
		ps.setString(3, f.getFoodType());                    // getting and setting food type from pojo
		int i=ps.executeUpdate();                            // Updating the data in database
		{
	    	System.out.println("Succesfully updated");
	    	return true;
	    }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return false;
	}

public boolean updateFood(Food f)
{
	try
	{
		conn=DBConnection.getDBConnect();
		String sql="Update Food_Arif set FoodName=?,FoodPrice=?,FoodType=? where FoodId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(4, f.getFoodId());
		ps.setString(1, f.getFoodName());
		ps.setDouble(2, f.getFoodPrice());
		ps.setString(3, f.getFoodType());
		int i=ps.executeUpdate();
		{
			System.out.println("Successfully Updated");
			return true;
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

return false;	
}

public boolean deleteFoodById(int FoodId)
{
	try
	{
		conn=DBConnection.getDBConnect();
		String sql="Delete from Food_Arif where FoodId=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,FoodId);
				int i=ps.executeUpdate();
				{
					//System.out.println("Successfully deleted");
					return true;
				}
	}
				catch(Exception e)
				{
					e.printStackTrace();
				}
	
	return false;
}
public Food displaySingleFood(int FoodId)
{
	try
	{
		conn=DBConnection.getDBConnect();
		String sql="Select*from Food_Arif where FoodId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,FoodId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Food f=new Food();
			f.setFoodId(rs.getInt("FoodId"));
			f.setFoodName(rs.getString("FoodName"));
			f.setFoodPrice(rs.getDouble("FoodPrice"));
			f.setFoodType(rs.getString("FoodType"));
			return f;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}
public List<Food> displayAllFood()
{
	try
	{
		conn=DBConnection.getDBConnect();
		List<Food> flist=new ArrayList<Food>();
		String sql="Select*from Food_Arif";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Food f=new Food();
			f.setFoodId(rs.getInt("FoodId"));
			f.setFoodName(rs.getString("FoodName"));
			f.setFoodPrice(rs.getDouble("FoodPrice"));
			f.setFoodType(rs.getString("FoodType"));
			flist.add(f);
	}
		return flist;
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return null;
}

}


