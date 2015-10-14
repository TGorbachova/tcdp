/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

import java.util.*;

public class Toy implements Comparable<Toy> {
	
	protected String name;
	protected String size;
	protected int price;
	protected String color;
	protected int age;
	protected String material;
	
	//Constructors of the class
	public Toy () {
	}
			
	public Toy(String name, String size, int price, String color, int age, String material) {
		this.name = name;
		this.size = size;
		this.price = price;
		this.color = color;
		this.age = age;
		this.material = material;
	}
	
	//Get and set methods for the class
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	//CompareTo method 
	public int compareTo(Toy compareToy) {
		return Comparators.NAME.compare(this, compareToy);
	}
	
	//Comparators for sorting method by specified attribute
	public static class Comparators {

        public static Comparator<Toy> NAME = new Comparator<Toy>() {
            public int compare(Toy i1, Toy i2) {
                return i1.name.compareTo(i2.name);
            }
        };
        public static Comparator<Toy> SIZE = new Comparator<Toy>() {
                public int compare(Toy i1, Toy i2) {
                return i1.size.compareTo(i2.size);
            }
        };
        public static Comparator<Toy> PRICE = new Comparator<Toy>() {
            public int compare(Toy i1, Toy i2) {
                return (int) (i1.price - i2.price);
            }
        };
        public static Comparator<Toy> COLOR = new Comparator<Toy>() {
            public int compare(Toy i1, Toy i2) {
            return i1.color.compareTo(i2.color);
            }
        };
        public static Comparator<Toy> AGE = new Comparator<Toy>() {
        	public int compare(Toy i1, Toy i2) {
                return (int) (i1.age - i2.age);
            }
        };
        public static Comparator<Toy> MATERIAL = new Comparator<Toy>() {
            public int compare(Toy i1, Toy i2) {
            return i1.material.compareTo(i2.material);
            }
        };
    }	
	
	//Methods implements sorting list of toys for different params
	public static ArrayList<Toy> sortToysByName(ArrayList<Toy> toys) {	        
	    Collections.sort(toys, Toy.Comparators.NAME);
	    return toys;
	 }	
	
	public static ArrayList<Toy> sortToysBySize(ArrayList<Toy> toys) {	        
	    Collections.sort(toys, Toy.Comparators.SIZE);
	    return toys;
	 }
	public static ArrayList<Toy> sortToysByPrice(ArrayList<Toy> toys) {	        
	    Collections.sort(toys, Toy.Comparators.PRICE);
	    return toys;
	 }
	public static ArrayList<Toy> sortToysByColor(ArrayList<Toy> toys) {	        
	    Collections.sort(toys, Toy.Comparators.COLOR);
	    return toys;
	 }
	public static ArrayList<Toy> sortToysByAge(ArrayList<Toy> toys) {	        
	    Collections.sort(toys, Toy.Comparators.AGE);
	    return toys;
	 }
	public static ArrayList<Toy> sortToysByMaterial(ArrayList<Toy> toys) {	        
	    Collections.sort(toys, Toy.Comparators.MATERIAL);
	    return toys;
	 }

	//Method implements call specified sort option for toy list
	public static void sortToy(ArrayList<Toy> listOfToy, int paramNumber) 
    { 
			//Perform sorting by specified param
            switch (paramNumber) { 
                case 1: 
                default:{ 
               	 Toy.sortToysByName(listOfToy); 
                    break; 
                } 
                case 2: { 
               	 Toy.sortToysBySize(listOfToy); 
                    break; 
                } 
                case 3: { 
               	 Toy.sortToysByPrice(listOfToy); 
                    break; 
                } 
                case 4: { 
               	 Toy.sortToysByColor(listOfToy); 
                   break; 
                } 
                case 5: { 
               	 Toy.sortToysByAge(listOfToy); 
                    break; 
                } 
                case 6: { 
               	 Toy.sortToysByMaterial(listOfToy); 
                   break; 
                } 
            } 
    }
	
	
	//Method implements search toys in the list by specified parameters
	public static void searchToyByParam (String size, int price, String color, int age, String material, ArrayList<Toy> toys){
		
		ArrayList<Toy> searchedToys = new ArrayList<Toy>();
		ArrayList<Toy> searchedToys1 = new ArrayList<Toy>();
		ArrayList<Toy> searchedToys2 = new ArrayList<Toy>();
		ArrayList<Toy> searchedToys3 = new ArrayList<Toy>();
		ArrayList<Toy> searchedToys4 = new ArrayList<Toy>();
		
		//filter out toys by specified params
		if (!(size.isEmpty())){
			for (Toy toy: toys){
				if (toy.size.contains(size)){
					searchedToys.add(toy);
				}
			}
		}
		else searchedToys.addAll(toys);
		
		if (!(color.isEmpty())){
			for (Toy toy: searchedToys){
				if (toy.color.contains(color)){
					searchedToys1.add(toy);
				}
			}
		}
		else searchedToys1.addAll(searchedToys);
		
		if (!(material.isEmpty())){
			for (Toy toy: searchedToys1){
				if (toy.material.contains(material)){
					searchedToys2.add(toy);
				}					
			}
		}	
		else searchedToys2.addAll(searchedToys1);
		
		if (price>0){
			for (Toy toy: searchedToys2){
				if (toy.price==price){
					searchedToys3.add(toy);
				}					
			}						
		}
		else searchedToys3.addAll(searchedToys2);
		
		if (age>0){
			for (Toy toy: searchedToys3){
				if (toy.age==age){
					searchedToys4.add(toy);
				}					
			}
		}
		else searchedToys4.addAll(searchedToys3);				
			
		if (searchedToys4.isEmpty()){
			System.out.println("No toys matched search criteria");
		}
		else{
			printToys(searchedToys4);	
		}
	}
	
	//Method implements filter out toys for the room based on average price, size and group (room creation)
	public static Toy searchToysForRoom(int averagePrice, String name, String size, ArrayList<Toy> toys){
		
		Toy searchResult = new Toy();
		for (Toy toy: toys){
			if ((toy.price <= averagePrice)&&(toy.size.contains(size))&&(toy.name.contains(name))){
				searchResult= toy;
			}
		}		
		return searchResult;
	}
	
	//Method adds hard coded data to the toy list
	public static void setHardCodedData(ArrayList<Toy> toys) {
		 toys.add(new Ball ("ball", "Big", 150, "Red", 5, "rezin", "sport" ));
		 toys.add(new Ball ("ball", "Big", 150, "Red", 7, "rezin", "sport" ));
		 toys.add(new Ball ("ball", "Big", 150, "Red", 11, "rezin", "sport" ));
		 toys.add(new Ball ("basket ball ", "Medium", 250, "Orange", 12, "rezin", "sport" ));
		 toys.add(new Ball ("basket ball ", "Medium", 250, "Orange", 8, "rezin", "sport" ));
		 toys.add(new Ball ("basket ball ", "Medium", 250, "Orange", 4, "rezin", "sport" ));
		 toys.add(new Ball ("pingpong ball", "Small", 120, "White", 10, "plastick", "sport" ));
		 toys.add(new Ball ("pingpong ball", "Small", 120, "White", 5, "plastick", "sport" ));
		 toys.add(new Ball ("pingpong ball", "Small", 120, "White", 8, "plastick", "sport" ));
		 toys.add(new Car ("mersedes car", "Small", 500, "White", 10, "metal", true, 15));
		 toys.add(new Car ("mersedes car", "Small", 500, "White", 8, "metal", true, 15));
		 toys.add(new Car ("mersedes car", "Small", 500, "White", 4, "metal", true, 15));
		 toys.add(new Car ("car", "Big", 320, "Black", 5, "plastick", false, 2 ));
		 toys.add(new Car ("car", "Big", 320, "Black", 8, "plastick", false, 2 ));
		 toys.add(new Car ("car", "Big", 320, "Black", 11, "plastick", false, 2 ));
		 toys.add(new Car ("car porshe", "Medium", 400, "Red", 8, "plastick", false, 10 ));
		 toys.add(new Car ("car porshe", "Medium", 400, "Red", 4, "plastick", false, 10 ));
		 toys.add(new Car ("car porshe", "Medium", 400, "Red", 11, "plastick", false, 10 ));
		 toys.add(new Cube ("cube big", "Big", 50, "White", 3, "plastick", 15 ));
		 toys.add(new Cube ("cube big", "Big", 50, "White", 7, "plastick", 15 ));
		 toys.add(new Cube ("cube big", "Big", 50, "White", 11, "plastick", 15 ));
		 toys.add(new Cube ("cube small", "Small", 25, "Green", 3, "plastick", 5 ));
		 toys.add(new Cube ("cube small", "Small", 25, "Green", 6, "plastick", 5 ));
		 toys.add(new Cube ("cube small", "Small", 25, "Green", 11, "plastick", 5 ));
		 toys.add(new Cube ("cube medium", "Medium", 35, "Red", 5, "plastick", 10 ));
		 toys.add(new Cube ("cube medium", "Medium", 35, "Red", 7, "plastick", 10 ));
		 toys.add(new Cube ("cube medium", "Medium", 35, "Red", 12, "plastick", 10 ));
		 toys.add(new Doll ("baby doll", "Big", 350, "White", 3, "plastick", "baby", false ));
		 toys.add(new Doll ("baby doll", "Big", 350, "White", 7, "plastick", "baby", false ));
		 toys.add(new Doll ("baby doll", "Big", 350, "White", 12, "plastick", "baby", false ));
		 toys.add(new Doll ("barby doll", "Medium", 850, "White", 4, "plastick", "grown up", false ));
		 toys.add(new Doll ("barby doll", "Medium", 850, "White", 7, "plastick", "grown up", false ));
		 toys.add(new Doll ("barby doll", "Medium", 850, "White", 11, "plastick", "grown up", false ));
		 toys.add(new Doll ("doll syster", "Small", 250, "White", 8, "plastick", "grown up", true ));
		 toys.add(new Doll ("doll syster", "Small", 250, "White", 12, "plastick", "grown up", true ));
		 toys.add(new Doll ("doll syster", "Small", 250, "White", 3, "plastick", "grown up", true ));
	}
	
	//Methods implements print list of toys
	public static void printToys(ArrayList<Toy> toys){
      	 for (Toy toy: toys ) {			 
			System.out.println(toy.name + "\t" + toy.size + "\t" + toy.price + "\t" + toy.color + "\t" + toy.age + "\t" + toy.material); 
		 }
	}
}
