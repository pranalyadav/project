package in.coder.dao;

import in.coder.pojo.Customer;
import in.coder.pojo.Food;
import in.coder.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao
{
	Connection conn=null;
	public boolean addCustomer(Customer c)
	{
		try
		{
			conn=DBConnection.getDBConnect();  //Establishing the Connection
			String sql="insert into Customer_Arif(CustomerName,CustomerAddress,CustomerContact,CustomerEmail,CustomerPassword) values(?,?,?,?,?)"; //Establishing the connection
			PreparedStatement ps=conn.prepareStatement(sql); //Creating the Statement
			ps.setString(1, c.getCustomerName()); //Creating the Statement
			ps.setString(2, c.getCustomerAddress()); //Creating the Statement
			ps.setLong(3, c.getCustomerContact()); //Creating the Statement
			ps.setString(4, c.getCustomerEmail()); //Creating the Statement
			ps.setString(5, c.getCustomerPassword()); //Creating the Statement
			int i=ps.executeUpdate();  //Process the Update
			{
		    	System.out.println("Succesfully Added");
		    	return true;
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateCustomer(Customer c)
	{
		try
		{
			conn=DBConnection.getDBConnect();
			String sql="Update Customer_Arif set CustomerName=?,CustomerAddress=?,CustomerContact=?,CustomerEmail=?,CustomerPassword=? where CustomerId=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(6, c.getCustomerId());
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerAddress());
			ps.setLong(3, c.getCustomerContact());
			ps.setString(4, c.getCustomerEmail());
			ps.setString(5,c.getCustomerPassword());
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
	public boolean deleteCustomerById(int CustomerId)
	{
		try
		{
			conn=DBConnection.getDBConnect();
			String sql="Delete from Customer_Arif where CustomerId=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1,CustomerId);
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
	public Customer displaySingleCustomer(int CustomerId)
	{
		try
		{
			conn=DBConnection.getDBConnect();
			String sql="Select*from Customer_Arif where CustomerId=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,CustomerId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCustomerId(rs.getInt("CustomerId"));
				c.setCustomerName(rs.getString("CustomerName"));
				c.setCustomerAddress(rs.getString("CustomerAddress"));
				c.setCustomerContact(rs.getLong("CustomerContact"));
				c.setCustomerEmail(rs.getString("CustomerEmail"));
				c.setCustomerPassword(rs.getString("CustomerPassword"));
				return c;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}
	public List<Customer> displayAllCustomer()
	{
		try
		{
			conn=DBConnection.getDBConnect();
			List<Customer> flist=new ArrayList<Customer>();
			String sql="Select*from Customer_Arif";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCustomerId(rs.getInt("CustomerId"));
				c.setCustomerName(rs.getString("CustomerName"));
				c.setCustomerAddress(rs.getString("CustomerAddress"));
				c.setCustomerContact(rs.getLong("CustomerContact"));
				c.setCustomerEmail(rs.getString("CustomerEmail"));
				c.setCustomerPassword(rs.getString("CustomerPassword"));
				flist.add(c);
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
