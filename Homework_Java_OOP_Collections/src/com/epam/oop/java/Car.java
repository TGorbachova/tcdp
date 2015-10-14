/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

public class Car extends Toy {
	
	private boolean auto;
	private int speed;
	
	//Constructors of the class
	public Car() {	
	}
	
	public Car(String name, String size, int price, String color, int age, String material, boolean auto, int speed) {
		super(name, size, price, color, age, material);
		this.auto = auto;
		this.speed = speed;
	}
	
	//Get and set methods for the class	
	public boolean isAuto() {
		return auto;
	}
	public void setAuto(boolean auto) {
		this.auto = auto;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
