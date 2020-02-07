package in.coder.pojo;
import java.util.*;
public class Food 
{
private int foodId;
private String foodName,foodType;
private double foodPrice;
public int getFoodId() 
{
	return foodId;
}
public void setFoodId(int foodId) 
{
	this.foodId = foodId;
}
public String getFoodName() 
{
	return foodName;
}
public void setFoodName(String foodName) 
{
	this.foodName = foodName;
}
public String getFoodType() 
{
	return foodType;
}
public void setFoodType(String foodType) 
{
	this.foodType = foodType;
}
public double getFoodPrice() 
{
	return foodPrice;
}
public void setFoodPrice(double foodPrice) 
{
	this.foodPrice = foodPrice;
}
public String toString() {
	return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodType="
			+ foodType + ", foodPrice=" + foodPrice + "]";
}

}
