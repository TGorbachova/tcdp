/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

import java.util.*;


public class Runner {

	public static void main(String[] args) throws Exception {
		
		 ArrayList<Toy> toys = new ArrayList<Toy>();
		 ArrayList<Room> rooms = new ArrayList<Room>();
		 		 
		 boolean toBeContinue = true;
         while (toBeContinue) {
             System.out.println("Select menu item ");
             //Get data from different sources - Hard coded, DataBase and XML
             System.out.println("1 - Hard coded data; 2 - DataBase; 3 - XML file; 0 - Exit");
             int data = new Scanner(System.in).nextInt();
             switch(data){
             case 0: toBeContinue = false; break;
             case 1: Room.setData(toys, rooms); break;
             case 2: Room.setData(DataBaseConnection.setDataUsingDB(), rooms);; break; 
             case 3: Room.setDataXml(toys, rooms); break; 
             }                     
             //Select action for the created data + second task: Comparative Analysis
             System.out.println("1 - Print; 2 - Sort; 3 - Search; 4 - Comparative Analysis; 0 - Exit");
             int item = new Scanner(System.in).nextInt();
             switch (item) {
                 case 0: toBeContinue = false; break;
                 case 1: Room.printRoomToys(rooms); break;
                 case 2: Room.sortData(rooms); break;
                 case 3: Room.searchToysInRooms(rooms); break;
                 case 4: CompareTypes.comparativeAnalysis(); break;   
             }
             //Exit from program
             if (item > 0) {
                 System.out.println("Do you want to continue? (y/n)");
                 String answer = new Scanner(System.in).nextLine();
                 if (answer.equals("y") || answer.equals("yes")) toBeContinue = true;
                 else toBeContinue = false;
             }
         }
    }	
}

