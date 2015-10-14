/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

import java.util.ArrayList;
import java.util.Scanner;

import com.epam.oop.java.Toy; 

public class Room {
	
	private String roomName;
	private int age;
	private int money;
	private int toysNumber;
	private ArrayList<Toy> toys = new ArrayList<Toy>();
	
	//Constructors of the class
	public Room() {}

	public Room(String roomName, int age, int money, int toysNumber, ArrayList<Toy> toys) {
		this.roomName = roomName;
		this.age = age;
		this.money = money;
		this.toysNumber = toysNumber;
		this.toys = toys;
	}
	
	//Get and set methods for the class
	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getToysNumber() {
		return toysNumber;
	}

	public void setToysNumber(int toysNumber) {
		this.toysNumber = toysNumber;
	}
	
	public ArrayList<Toy> getToy() {
		return toys;
	}

	public void setToys(ArrayList<Toy> toys) {
		this.toys = toys;
	}
	
	//Method implements print room name + list of toys.
	public static void printRoomToys(ArrayList<Room> rooms)
    {
		for (Room room: rooms){
			System.out.println("Room <<" + room.roomName + ">>");
	        System.out.println("Toys: ");
	        for (Toy toy: room.toys ) {			 
				System.out.println(toy.name + "\t" + toy.size + "\t" + toy.price + "\t" + toy.color + "\t" + toy.age + "\t" + toy.material); 
			 }     	         	
		}                
         
     }
	
	

	// Method filter out list of toys based on price, group and size
	private static ArrayList<Toy> setToysToRoom(int count, int amount, ArrayList<Toy> toys) {
		
		int averagePrice = amount/count;
		ArrayList<Toy> toysToSet = new ArrayList<Toy>();
		
		int i = 0;
		
		//Creation of list of available sizes
		ArrayList<String> sizes = new ArrayList();
		sizes.add("Small");
		sizes.add("Big");
		sizes.add("Medium");
		
		//Creation of list of available groups
		ArrayList<String> names = new ArrayList();
		names.add("ball");
		names.add("doll");
		names.add("cube");
		names.add("car");
		
		//filter out toys based on price, group and size
		while(i < count){
			
			for (String size: sizes){
				
				for (String name: names){
					Toy newToy = Toy.searchToysForRoom(averagePrice, name, size, toys);
					toysToSet.add(newToy);
					i++;
					if (i == count){
						break;
					}
				}
				if (i == count){
					break;
				}				
			}			
		}
		return toysToSet;
	}
	
	/*Method implements creation of room, adding list of toys to the room based on the following criteria:
	1. Toys according to the age group added to the initial list of toys
	2. Toys with price less or equal to average price is added to final list of toys
	3. All groups and size are present in the final list of toys.
	Average price is amount of money for the room divide to count of the toys in the room*/
	public static Room createRoom(int age, int numberOfToys, int amountOfMoney, ArrayList<Toy> toys){
		
		Room room1 = new Room();
		ArrayList<Toy> toyToSet = new ArrayList<Toy>();
		ArrayList<Toy> toySearchResult = new ArrayList<Toy>();
		int startAge = 0;
		int endAge = 0;
				
		//set room attributes
		room1.setAge(age);
		room1.setMoney(amountOfMoney);
		room1.setToysNumber(numberOfToys);
		
		//set room name regarding to specified age
		if ((age >= 3)&&(age<=5)){
			room1.setRoomName("Room 1 for 3-5 year old");
			startAge = 3;
			endAge = 5;			
		}
		if ((age>=6)&&(age<=9)){
			room1.setRoomName("Room 2 for 6-9 year old");
			startAge = 6;
			endAge = 9;			
		} 
		if ((age>=10)&&(age<=12)){
			room1.setRoomName("Room 3 for 10-12 year old");
			startAge = 10;
			endAge = 12;
		}
		//creation initial list of toys which are filtered out by age
		for (Toy toy: toys){
			if ((toy.age >= startAge)&&(toy.age<=endAge)){
				toyToSet.add(toy);
				
			}		
		}
		//filter out list of toys based on price, group and size
		toySearchResult.addAll(setToysToRoom(numberOfToys, amountOfMoney, toyToSet));
			
		
		room1.toys = toySearchResult;
		return room1;
	}
	
	//Method implements set data for toys and rooms lists
	public static void setData(ArrayList<Toy> toys, ArrayList<Room> rooms) {
		if (toys.isEmpty()){
			Toy.setHardCodedData(toys);	
		}
		rooms.add(Room.createRoom(5, 12, 12000, toys));
		rooms.add(Room.createRoom(8, 24, 25000, toys));
		rooms.add(Room.createRoom(12, 12, 18000, toys));
	}	
	
	//Method implements set data for toys and rooms lists using data from xml file
	public static void setDataXml(ArrayList<Toy> toys, ArrayList<Room> rooms) {
		Files workWithFiles = new XmlParser();
		workWithFiles.setFileName("./resources/toys");
		//get list of toys
		toys.addAll(workWithFiles.readFromFile());
		//room creation
		Room.setData(toys, rooms);
	}
	
	//Method implements sort toys in the room by selected option
		public static void sortData(ArrayList<Room> rooms) throws Exception {
			System.out.println("Select field for sorting.");
			//specify sort criteria
			 System.out.println("1 - Name; 2 - Size; 3 - Price; 4 - Color; 5 - Age; 6 - Material; 0 - Ex1it");
			 int sort = new Scanner(System.in).nextInt();
			 //perform sorting toys in the room
			 for (Room room: rooms){
				 //using user difined exception
				 if (room.getToy().isEmpty()){
					 throw(new EmptyToyException("List of toys is empty"));
				 } else {
					 Toy.sortToy(room.getToy(), sort);
				 }                   	 
			 }   
			 if (rooms.isEmpty()){
				 throw(new EmptyToyException("Room is empty"));
			 } else {
				 Room.printRoomToys(rooms);	 
			 }
			 
		}
		
	//Method implements search of toys in the rooms by selected criteria 
	public static void searchToysInRooms(ArrayList<Room> rooms) {
		System.out.println("Please specify parameters for search. Leave parameter empty for size, color and material if you don't need to provide search with these croteria");
		System.out.println("Specify 0 for price and age if you don't need to provide search with these criteria ");
		
		//specify search criteria
		System.out.println("Enter size criteria");
		String size = new Scanner(System.in).nextLine();
		System.out.println("Enter price criteria");
		int price = new Scanner(System.in).nextInt();           	 
		System.out.println("Enter color criteria");
		String color = new Scanner(System.in).nextLine();
		System.out.println("Enter age criteria");
		int age = new Scanner(System.in).nextInt(); 
		System.out.println("Enter material criteria");
		String material = new Scanner(System.in).nextLine();
		
		//perform search toys in the room
		for (Room room: rooms){
			 System.out.println("Room: \t " + room.roomName);
			 Toy.searchToyByParam(size, price, color, age, material, room.getToy());                    	 
		}
	}
}

