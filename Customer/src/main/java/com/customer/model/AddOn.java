package com.customer.model;

import java.util.Collection;

public class AddOn {
	
	private Long addOnId;
	private String category;
	private String featureName;
	private String cost;
	
	public AddOn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddOn(Long addOnId, String category, String featureName, String cost) {
		super();
		this.addOnId = addOnId;
		this.category = category;
		this.featureName = featureName;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "AddOn [addOnId=" + addOnId + ", category=" + category + ", featureName=" + featureName + ", cost="
				+ cost + "]";
	}
	public Long getAddOnId() {
		return addOnId;
	}
	public void setAddOnId(Long addOnId) {
		this.addOnId = addOnId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
	
	
	

}
