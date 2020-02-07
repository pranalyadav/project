package in.coder.pojo;
import java.util.*;
public class Customer 
{
	private int customerId;
	private String customerName,customerAddress,customerEmail,customerPassword;
	private long customerContact;
	public int getCustomerId() 
	{
		return customerId;
	}
	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}
	public String getCustomerName() 
	{
		return customerName;
	}
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}
	public String getCustomerAddress() 
	{
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) 
	{
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmail() 
	{
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) 
	{
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() 
	{
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) 
	{
		this.customerPassword = customerPassword;
	}
	public long getCustomerContact() 
	{
		return customerContact;
	}
	public void setCustomerContact(long customerContact) 
	{
		this.customerContact = customerContact;
	}
	public String toString() 
	{
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + ", customerAddress=" + customerAddress
				+ ", customerEmail=" + customerEmail + ", customerPassword="
				+ customerPassword + ", customercontact=" + customerContact + "]";
	}
	

}
