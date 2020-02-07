package in.coder.dao;

import java.sql.*;

import in.coder.pojo.*;
import in.coder.utility.DBConnection;

import java.util.ArrayList;
import java.util.List;
public class CartDaoImpl implements CartDao
{
	Connection conn=null;
	public boolean addToCart(Cart c)
	{
		try
		{
			conn=DBConnection.getDBConnect();
			String sql="insert into Cart_Arif(CustomerEmail,FoodId,FoodQuantity) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCustomerEmail());
			ps.setInt(2, c.getFoodId());
			ps.setInt(3, c.getFoodQuantity());
			int i=ps.executeUpdate();
			{
				System.out.println("Successfully Updates");
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
public boolean deleteFromCart(int CartId)
{
	try
	{
		conn=DBConnection.getDBConnect();
		String sql="delete from Cart_Arif where CartId=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, CartId);
		int i=ps.executeUpdate();
		{
			System.out.println("Successfully deleted");
			return true;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return false;
}
	public List<Cart> displayCartByCustomerEmail(String CustomerEmail)
	{
		List<Cart> fList=new ArrayList<Cart>();
		try
		{
			
			conn=DBConnection.getDBConnect();
			String sql="Select c.CartId,f.FoodId,f.FoodName,f.FoodPrice,c.FoodQuantity from Cart_Arif as c inner join Food_Arif as f on c.FoodId=f.FoodId where c.CustomerEmail=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, CustomerEmail);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Cart c=new Cart();
				c.setCartId(rs.getInt("CartId"));
				c.setFoodId(rs.getInt("FoodId"));
				c.setFoodName(rs.getString("FoodName"));
				c.setFoodPrice(rs.getDouble("FoodPrice"));
				c.setFoodQuantity(rs.getInt("FoodQuantity"));
				fList.add(c);
			}
			return fList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public boolean PlaceOrder(String CustomerEmail) 
	{
		double TotalBill=0.0;
		try
		{
			conn=DBConnection.getDBConnect();
			String sql="Select Sum(f.FoodPrice*c.FoodQuantity) as Total from Food_Arif as f inner join Cart_Arif as c on c.FoodId=f.FoodId where c.CustomerEmail=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, CustomerEmail);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				TotalBill=rs.getDouble("Total");
			}
			System.out.println("TotalBill = "+TotalBill);
			String sql1="Insert into PlaceOrder_Arif(CustomerEmail,TotalBill) values(?,?)";
			PreparedStatement ps1=conn.prepareStatement(sql1);
			ps1.setString(1, CustomerEmail);
			ps1.setDouble(2, TotalBill);
			int i=ps1.executeUpdate();
			if(i>0){
				System.out.println("Successfully Placed Order");
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean DeleteFullCart(String CustomerEmail)
	{
		try
		{
			conn=DBConnection.getDBConnect();
			String sql="Delete from Cart_Arif where CustomerEmail=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, CustomerEmail);
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Successfully Deleted");
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}
	
}

