package com.addOn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addOn.model.AddOn;
import com.addOn.service.AddOnService;

@RestController
@RequestMapping("/singtel/addOn")
public class AddOnController {
	
	@Autowired
	private AddOnService addOnService;
	
	@PostMapping("/addNewAddOn")
	public ResponseEntity<?> addAddOnHandler(@RequestBody AddOn aObj){
		AddOn newAddOn = this.addOnService.addNewAddOn(aObj);
		return new ResponseEntity<>(newAddOn,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllAddOns")
	public ResponseEntity<?> getAllAddOnsHandler(){
		List<AddOn> allAddOns = this.addOnService.getAllAddOns();
		return new ResponseEntity<>(allAddOns,HttpStatus.OK);
	}
	
	@GetMapping("/getAddOnsByCategory/{category}")
	public ResponseEntity<?> getAddOnsByCategoryHandler(@PathVariable String category){
		List<AddOn> allAddOns = this.addOnService.getAddOnsByCategory(category);
		return new ResponseEntity<>(allAddOns,HttpStatus.OK);
	}

	@GetMapping("/getAddOnsByFeatureName/{featureName}")
	public ResponseEntity<?> getAddOnsByFeatureNameHandler(@PathVariable String featureName){
		List<AddOn> addOns = this.addOnService.getAddOnsByFeatureName(featureName);
		return new ResponseEntity<>(addOns,HttpStatus.OK);
	}
	
	@GetMapping("/getAddOnsByCost/{cost}")
	public ResponseEntity<?> getAddOnsByCosteHandler(@PathVariable String cost){
		List<AddOn> plans = this.addOnService.getAddOnsByCost(cost);
		return new ResponseEntity<>(plans,HttpStatus.OK);
	}
	
	@GetMapping("/getAddOnsById/{addOnId}")
	public ResponseEntity<?> getAddOnsByIdHandler(@PathVariable Integer addOnId){
		AddOn addOn = this.addOnService.getPlanById(addOnId);
		return new ResponseEntity<>(addOn,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAddOn/{addOnId}")
	public ResponseEntity<?> deleteAddOnByIdHandler(@PathVariable Integer addOnId){
		boolean status = this.addOnService.deleteAddOn(addOnId);
		if(status) {
			return new ResponseEntity<>("AddOn removed Successfully..",HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateAddOn/{addOnId}")
	public ResponseEntity<?> updateAddonrHandler(@RequestBody AddOn aObj,@PathVariable Integer addOnId){
		AddOn updatedPlan = this.addOnService.updateAddOn(aObj, addOnId);
		return new ResponseEntity<>(updatedPlan,HttpStatus.CREATED);
	}

}
