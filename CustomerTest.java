package in.coder.Test;
import java.util.*;

import in.coder.dao.*;
import in.coder.pojo.Customer;
import in.coder.pojo.Food;

import java.util.Scanner;

public class CustomerTest 
{
	public static void main(String[] args) {
		
	int CustomerId,choice;
	String CustomerName,CustomerAddress,CustomerEmail,CustomerPassword;
	long Customercontact;
	Scanner sc=new Scanner(System.in);
	Customer c=new Customer();
	CustomerDaoImpl cd=new CustomerDaoImpl();
	System.out.println("Enter 1 to Add Customer\nEnter 2 to Update Customer By Id\nEnter 3 to Delete Single Customer By Id\nEnter 4 to Display Customer By Id\nEnter 5 to Display All Customers");
	System.out.println("Enter your choice");
	choice=sc.nextInt();
	switch(choice)
	{
	case 1: 
		System.out.println("ADD CUSTOMER");
		System.out.println("Enter Customer Name = ");
		CustomerName=sc.next();
		System.out.println("Enter Customer Address = ");
		CustomerAddress=sc.next();
		System.out.println("Enter Customer Contact = ");
		Customercontact=sc.nextLong();
		System.out.println("Enter Customer EmailId = ");
		CustomerEmail=sc.next();
		System.out.println("Enter Customer Password = ");
		CustomerPassword=sc.next();
		c.setCustomerName(CustomerName);
		c.setCustomerAddress(CustomerAddress);
		c.setCustomerContact(Customercontact);
		c.setCustomerEmail(CustomerEmail);
		c.setCustomerPassword(CustomerPassword);
		boolean b1=cd.addCustomer(c);
	    if(b1)
	    {
	    	System.out.println("Food Added Successfully");
	    }
	    else
	    {
	    	System.out.println("Error");
	    }
	break;
	case 2:
		System.out.println("UPDATE CUSTOMER");
		System.out.println("Enter Customer Id = ");
		CustomerId=sc.nextInt();
		System.out.println("Enter Customer Name = ");
		CustomerName=sc.next();
		System.out.println("Enter Customer Address = ");
		CustomerAddress=sc.next();
		System.out.println("Enter Customer Contact = ");
		Customercontact=sc.nextLong();
		System.out.println("Enter Customer EmailId = ");
		CustomerEmail=sc.next();
		System.out.println("Enter Customer Password = ");
		CustomerPassword=sc.next();
		c.setCustomerId(CustomerId);
		c.setCustomerName(CustomerName);
		c.setCustomerAddress(CustomerAddress);
		c.setCustomerContact(Customercontact);
		c.setCustomerEmail(CustomerEmail);
		c.setCustomerPassword(CustomerPassword);
		boolean b2=cd.updateCustomer(c);
	    if(b2)
	    {
	    	System.out.println("Food Added Successfully");
	    }
	    else
	    {
	    	System.out.println("Error");
	    }
	    break;
	case 3:
	    System.out.println("DELETE CUSTOMER");
	    System.out.println("Enter Customer Id = ");
	    CustomerId=sc.nextInt();
	    boolean b3=cd.deleteCustomerById(CustomerId);
	    if(b3)
	    {
	    	System.out.println("Food Deleted Successfully");
	    }
	    else
	    {
	    	System.out.println("Error");
	    }
	    break;
	case 4:
		System.out.println("DISPLAY CUSTOMER");
		System.out.println("Enter Customer ID = ");
		CustomerId=sc.nextInt();
		c=cd.displaySingleCustomer(CustomerId);
		if(c!=null)
		{
			System.out.println(c);
		}
		else
		{
			System.out.println("No Customer available to Display");
		}
	break;
	case 5:
		System.out.println("LIST OF CUSTOMER");
		List<Customer> flist=cd.displayAllCustomer();
		for(Customer c1:flist)
		{
			System.out.println(c1);
		}
		break;
}
}
}