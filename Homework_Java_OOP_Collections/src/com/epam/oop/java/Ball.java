/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

public class Ball extends Toy {
	
	private String type;
	
	//Constructors of the class
	public Ball() {
	}

	public Ball(String name, String size, int price, String color, int age,	String material, String type) {
		super(name, size, price, color, age, material);
		this.type = type;
		
	}
	//Get and set methods for the class
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	

}
