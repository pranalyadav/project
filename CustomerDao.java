package in.coder.dao;

import java.util.List;
import in.coder.pojo.*;

interface CustomerDao 
{
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomerById(int CustomerId);
	Customer displaySingleCustomer(int CustomerId);
	List<Customer> displayAllCustomer();


}
