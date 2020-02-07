package in.coder.pojo;
import java.util.*;
public class Cart 
{
	
	int CartId,FoodId,FoodQuantity;
	String CustomerEmail,FoodName;
	double FoodPrice;
	public int getCartId() {
		return CartId;
	}
	public void setCartId(int cartId) 
	{
		CartId = cartId;
	}
	public int getFoodId() 
	{
		return FoodId;
	}
	public void setFoodId(int foodId) 
	{
		FoodId = foodId;
	}
	public int getFoodQuantity() 
	{
		return FoodQuantity;
	}
	public void setFoodQuantity(int foodQuantity) 
	{
		FoodQuantity = foodQuantity;
	}
	public String getCustomerEmail() 
	{
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) 
	{
		CustomerEmail = customerEmail;
	}
	public String getFoodName() 
	{
		return FoodName;
	}
	public void setFoodName(String foodName) 
	{
		FoodName = foodName;
	}
	public double getFoodPrice() 
	{
		return FoodPrice;
	}
	public void setFoodPrice(double foodPrice) 
	{
		FoodPrice = foodPrice;
	}
	public String toString() 
	{
		return "Cart [CartId=" + CartId + ", FoodId=" + FoodId
				+ ", FoodQuantity=" + FoodQuantity + ",+ FoodName=" + FoodName + ", FoodPrice="
				+ FoodPrice + "]";
	}
	

}
