package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.exception.PlanNotFoundException;
import com.customer.exception.UserAlreadyExistsException;
import com.customer.exception.UserNotFoundException;
import com.customer.feignConfig.PlanFeignController;
//import com.customer.model.AddOn;
import com.customer.model.Customer;
import com.customer.model.Plan;
import com.customer.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	//Synchronous communication with Plan Microservice using FeignClient
	@Autowired
	private PlanFeignController planRepo;

	@Override
	public Customer addCustomer(Customer customer) throws UserAlreadyExistsException{
		Optional<Customer> optional = this.customerRepo.findById(customer.getCutomerId());
		if(optional.isPresent()) {
			throw new UserAlreadyExistsException();
		}else {
			return this.customerRepo.save(customer);
		}
	}

	@Override
	public Customer updateCustomer(Integer customerId, Customer updatedCustomer) throws UserNotFoundException {
		Optional<Customer> optionalCustomer = this.customerRepo.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setCustomerName(updatedCustomer.getCustomerName());
            customer.setCustomerPhoneNo(updatedCustomer.getCustomerPhoneNo());
            customer.setCurrentPlanId(updatedCustomer.getCurrentPlanId());
            customer.setSelectedAddOnIds(updatedCustomer.getSelectedAddOnIds());
            return this.customerRepo.save(customer);
        }else {
        	throw new UserNotFoundException();
        }

	}

	@Override
	public boolean deleteCustomer(Integer customerId) throws UserNotFoundException{
		Optional<Customer> optional = this.customerRepo.findById(customerId);
		boolean status = false;
		if(optional.isPresent()) {
			this.customerRepo.delete(optional.get());
			status = true;
		}else {
			System.out.println("Customer doesn't exists");
			throw new UserNotFoundException();
		}
		return status;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.customerRepo.findAll();

	}

	@Override
	public Customer selectPlan(Integer customerId, Plan plan) throws PlanNotFoundException{
		Optional<Customer> optionalCustomer = this.customerRepo.findById(customerId);
		
		
		//Using PlanFeignController through FeignClient to check if the plan with expected planId exists or not
		Plan planObj = this.planRepo.getPlanById(plan.getPlanId());
		
		Customer updated = null;
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();

        	if(planObj.getPlanId() != plan.getPlanId()) {
        		
        		throw new PlanNotFoundException();
        		
        		
        	}
        	        	
            customer.setCurrentPlanId(planObj.getPlanId());
            customer.setCurrentPlanName(planObj.getPlanName());
            updated = this.customerRepo.save(customer);
        }
        return updated;
	}

	@Override
	public Customer addAddOns(Integer customerId, Customer addOn) throws UserNotFoundException{
		Optional<Customer> optionalCustomer = this.customerRepo.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setSelectedAddOnIds(addOn.getSelectedAddOnIds());
            return this.customerRepo.save(customer);
        }else {
        	throw new UserNotFoundException();
        }

        	}

	@Override
	public Customer removeAddOns(Integer customerId, Customer addOn) throws UserNotFoundException {
		
		Optional<Customer> optionalCustomer = this.customerRepo.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.getSelectedAddOnIds().removeAll(addOn.getSelectedAddOnIds());
            return this.customerRepo.save(customer);
        }else {
        	throw new UserNotFoundException();
        }
		
		
	}

	@Override
	public List<Customer> getCustomersBySelectedPlan(String planName) {
		// TODO Auto-generated method stub
		return this.customerRepo.findByCurrentPlanNameContainingIgnoreCase(planName);
	}

}
