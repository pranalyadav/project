package in.coder.Test;
import java.util.*;

import in.coder.dao.*;
import in.coder.pojo.*;
public class CartTest 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int CartId,FoodId,FoodQuantity,Choice;
		String CustomerEmail,FoodName;
		double FoodPrice;
		Cart c=new Cart();
		CartDaoImpl cdi=new CartDaoImpl();
		System.out.println("Enter 1 to Add to Cart\nEnter 2 to Delete From Cart\nEnter 3 to Display List by Customer Email\nEnter 4 to Place Order Or Delete Full Cart");
		System.out.println("Enter your Choice");
		Choice=sc.nextInt();
		switch(Choice)
		{
		case 1:
			System.out.println("ADD TO CART");
			System.out.println("Enter Customer Email ID = ");
			CustomerEmail=sc.next();
			System.out.println("Enter Food ID = ");
			FoodId=sc.nextInt();
			System.out.println("Enter Food Quantity = ");
			FoodQuantity=sc.nextInt();
		    c.setCustomerEmail(CustomerEmail);
		    c.setFoodId(FoodId);
		    c.setFoodQuantity(FoodQuantity);
		    boolean b1=cdi.addToCart(c);
		    if(b1)
		    {
		    	System.out.println("Successfully Added to Cart");
		    }
		    else
		    {
		   System.out.println("Error");
		    }
		    break;
		case 2:
			System.out.println("DELETE FROM CART");
			System.out.println("Enter Cart ID which you want to Delete = ");
			CartId=sc.nextInt();
			c.setCartId(CartId);
			boolean b2=cdi.deleteFromCart(CartId);
			if(b2)
			{
				System.out.println("Successfully Deleted from Cart");
			}
			else
			{
				System.out.println("Error");
			}
			break;
		case 3:
			System.out.println("DISPLAY LIST BY CUSTOMER EMAIL");
			System.out.println("Enter Customer Email = ");
			CustomerEmail=sc.next();
			List<Cart> fList=cdi.displayCartByCustomerEmail(CustomerEmail);
			for(int i=0;i<fList.size();i++)
			{
				System.out.println(fList.get(i));
			}
			break;
		case 4:
			System.out.println("PLACE ORDER OR DELETE FULL CART");
			System.out.println("Enter Customer Email = ");
			CustomerEmail=sc.next();
		
			boolean b3=cdi.PlaceOrder(CustomerEmail);
			if(b3)
			{
				System.out.println("Order Placed Successfully");
				boolean b4=cdi.DeleteFullCart(CustomerEmail);
				
				if(b4)
				{
					System.out.println("Cart Deleted Successfully");
				}
			}
			else
			{
				System.out.println("Error");
			}
		
		}
		
	}

}
