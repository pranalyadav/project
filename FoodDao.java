package in.coder.dao;
import java.sql.*;

import java.util.*; // Imported List package

import in.coder.pojo.*; // Imported Pojo package
import in.coder.utility.DBConnection; // Imported DBUtility package
interface FoodDao 
{
boolean addFood(Food f);
boolean updateFood(Food f);
boolean deleteFoodById(int FoodId);
Food displaySingleFood(int FoodId);
List<Food> displayAllFood();
}
 