package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.exception.PlanNotFoundException;
import com.customer.exception.UserAlreadyExistsException;
import com.customer.exception.UserNotFoundException;
import com.customer.model.Customer;
import com.customer.model.Plan;
import com.customer.service.CustomerServiceImpl;

@RestController
@RequestMapping("/singtel/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@PostMapping("/addNewCustomer")
	public ResponseEntity<?> addNewCustomerHandler(@RequestBody Customer customer) throws UserAlreadyExistsException {
		Customer createdCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerId, @RequestBody Customer updatedCustomer) throws UserNotFoundException {
        Customer updated = customerService.updateCustomer(customerId, updatedCustomer);
        return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId) throws UserNotFoundException {
        boolean deleted = customerService.deleteCustomer(customerId);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<?> getAllCustomersHandler(){
		List<Customer> all = this.customerService.getAllCustomers();
		return new ResponseEntity<>(all,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllCustomersByCurrentPlan/{planName}")
	public ResponseEntity<?> getAllCustomersByCurrentPlanHandler(@PathVariable String planName){
		List<Customer> all = this.customerService.getCustomersBySelectedPlan(planName);
		return new ResponseEntity<>(all,HttpStatus.OK);
		
	}
	
	
	
	@PatchMapping("/subscribePlan/{customerId}")
    public ResponseEntity<Customer> subscribePlanHandler(@PathVariable Integer customerId, @RequestBody Plan plan) throws PlanNotFoundException {
        Customer updated = customerService.selectPlan(customerId, plan);
        return new ResponseEntity<>(updated,HttpStatus.NOT_FOUND);
        
    }
	
	@PatchMapping("/addAddOns/{customerId}")
    public ResponseEntity<Customer> addAddOnHandler(@PathVariable Integer customerId, @RequestBody Customer customer) throws UserNotFoundException {
        Customer updated = customerService.addAddOns(customerId, customer);
        if (updated == null) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@PatchMapping("/removeAddOns/{customerId}")
    public ResponseEntity<Customer> removeAddOnsHandler(@PathVariable Integer customerId, @RequestBody Customer customer) throws UserNotFoundException {
        Customer updatedCustomer = customerService.removeAddOns(customerId, customer);

        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	

}
