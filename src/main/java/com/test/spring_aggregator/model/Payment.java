package com.test.spring_aggregator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
	
	private String type;
	private int amount;
	private String mode;
	
	public Payment(){}
	
	public Payment(String type, int amount, String mode){
		this.type = type;
		this.amount = amount;
		this.mode = mode;
	}
	
	
	public String getType(){
		return this.type;
	}

	@Override
	public String toString(){
		return "Payment[ type=" + this.type + " ,mode= " + this.mode + " ,amount= " + this.amount + "]" ;
	}
}
