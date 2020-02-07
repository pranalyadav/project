package in.coder.Test;
import in.coder.pojo.*;

import java.util.*;
import in.coder.dao.*;
public class FoodTest 
{
public static void main(String[] args) 
{
int FoodId,choice;
String FoodName,FoodType;
double FoodPrice;
Scanner sc=new Scanner(System.in);
Food f=new Food();
FoodDaoImpl fd=new FoodDaoImpl();
System.out.println("Enter 1 to Add Food\nEnter 2 to Update Food By Id\nEnter 3 to Delete Food By Id\nEnter 4 to Display Food By Id\nEnter 5 to Display All Food");
System.out.println("Enter your choice");
choice=sc.nextInt();
switch(choice)
{
case 1: 
	System.out.println("ADD FOOD");
	System.out.println("Enter Food Name = ");
	FoodName=sc.next();
	System.out.println("Enter Food Price = ");
	FoodPrice=sc.nextInt();
	System.out.println("Enter Food Type = ");
	FoodType=sc.next();
	f.setFoodName(FoodName);
	f.setFoodPrice(FoodPrice);
	f.setFoodType(FoodType);
	boolean b1=fd.addFood(f);
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
	 System.out.println("UPDATE FOOD");
	 System.out.println("Enter Food Id = ");
	 FoodId=sc.nextInt();
	 System.out.println("Enter Food Name = ");
		FoodName=sc.next();
		System.out.println("Enter Food Price = ");
		FoodPrice=sc.nextInt();
		System.out.println("Enter Food Type = ");
		FoodType=sc.next();
		f.setFoodId(FoodId);
		f.setFoodName(FoodName);
		f.setFoodPrice(FoodPrice);
		f.setFoodType(FoodType);
		boolean b2=fd.updateFood(f);
	    if(b2)
	    {
	    	System.out.println("Food Updated Successfully");
	    }
	    else
	    {
	    	System.out.println("Error");
	    }
	break;
case 3:
	System.out.println("DELETE FOOD");
System.out.println("Enter Food Id = ");
FoodId=sc.nextInt();
boolean b3=fd.deleteFoodById(FoodId);
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
	System.out.println("DISPLAY FOOD");
	System.out.println("Enter Food ID = ");
	FoodId=sc.nextInt();
	f=fd.displaySingleFood(FoodId);
	if(f!=null)
	{
		System.out.println(f);
	}
	else
	{
		System.out.println("No Food available to Display");
	}
break;
case 5:
	System.out.println("LIST OF FOOD");
	List<Food> flist=fd.displayAllFood();
	for(Food f1:flist)
	{
		System.out.println(f1);
	}
}
}
}

