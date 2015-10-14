/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

public class Doll extends Toy {
	
	private String type;
	private boolean audio;	
	
	//Constructors of the class
	public Doll() {
	}
	
	public Doll(String name, String size, int price, String color, int age, String material, String type, boolean audio) {
		super(name, size, price, color, age, material);
		this.type = type;
		this.audio = audio;
	}
	
	//Get and set methods for the class	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAudio() {
		return audio;
	}
	public void setAudio(boolean audio) {
		this.audio = audio;
	}
}
