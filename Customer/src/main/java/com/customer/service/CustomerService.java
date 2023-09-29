package com.customer.service;

import java.util.List;

import com.customer.exception.PlanNotFoundException;
import com.customer.exception.UserAlreadyExistsException;
import com.customer.exception.UserNotFoundException;
import com.customer.model.AddOn;
import com.customer.model.Customer;
import com.customer.model.Plan;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws UserAlreadyExistsException;
	public Customer updateCustomer(Integer customerId, Customer customer) throws UserNotFoundException;
	public boolean deleteCustomer(Integer customerId) throws UserNotFoundException;
	public List<Customer> getAllCustomers();

	public Customer selectPlan(Integer customerId, Plan plan) throws PlanNotFoundException;
	public Customer addAddOns(Integer customerId, Customer addOn) throws UserNotFoundException;
	public Customer removeAddOns(Integer customerId, Customer addOn) throws UserNotFoundException;
	
	public List<Customer> getCustomersBySelectedPlan(String planName);

}
