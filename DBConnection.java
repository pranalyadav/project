package in.coder.utility;

import java.sql.*;

public class DBConnection
{
public static Connection getDBConnect()
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");  //Load and Register the Driver
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodPlazaArif","root","root");  //EStablishing the Connection
	return conn;
}
	catch(Exception e)
	{
		e.printStackTrace();
	}
return null;
}
}