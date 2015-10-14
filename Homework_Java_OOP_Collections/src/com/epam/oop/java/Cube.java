/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

public class Cube extends Toy {
	
	private int weight;
		
	//Constructors of the class
	public Cube() {
	}

	public Cube(String name, String size, int price, String color, int age, String material, int weight) {
		super(name, size, price, color, age, material);
		this.weight = weight;
	}
	
	//Get and set methods for the class	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
