package in.coder.dao;
import java.util.List;
import in.coder.pojo.*;
interface CartDao 
{
	boolean addToCart(Cart c);
	boolean deleteFromCart(int CartId);
	List<Cart> displayCartByCustomerEmail(String CustomerEmail);
	boolean PlaceOrder(String CustomerEmail);
	boolean DeleteFullCart(String CustomerEmail);
	

}
