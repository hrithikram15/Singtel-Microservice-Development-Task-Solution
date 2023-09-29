package com.customer.model;

public class Plan {
	
	private Integer planId;
	private String planName;
	private String cost;
	private String details;
	
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plan(Integer planId, String planName, String cost, String details) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.cost = cost;
		this.details = details;
	}
	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planName=" + planName + ", cost=" + cost + ", details=" + details + "]";
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	

}
