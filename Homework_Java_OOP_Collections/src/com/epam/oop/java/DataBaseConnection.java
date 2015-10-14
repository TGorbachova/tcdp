/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DataBaseConnection{
	
	//database information
	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://EPUADNIW0079:49753/toys";
	static String user = "root";
	static String pass = "admin";
	
	//Method implements get data from the DB 
	public static ArrayList<Toy> setDataUsingDB(){	
		
		ArrayList<Toy> toys = new ArrayList<Toy>();
		Toy toyToAdd = new Toy();
	try 
	{
		//register driver class using load class
		Class.forName(driverName);
		System.out.println("Ok");
				}
		catch(ClassNotFoundException ex) {
		   System.out.println("JDBC driver not found");		   
		}

	Connection c = null;
	
	try {
		//Get connection to database
		c = DriverManager.getConnection(url, user, pass);
		System.out.println("Connect");
	} catch (SQLException e) {
		System.out.println("SQLException" + e.getMessage());
	}
	
	ResultSet rs = null;
	Statement s = null;
	
	try {
		//Creation statement object
		s = c.createStatement();
		//Creation and execution of the result
		rs = s.executeQuery("SELECT NAME, SIZE, PRICE, COLOR, AGE, MATERIAL FROM TOYS");
		//parse result
		while( rs.next() ) {
			toyToAdd.name = rs.getString("NANE");
			toyToAdd.size = rs.getString("SIZE");
			toyToAdd.price = rs.getInt("PRICE");
			toyToAdd.color = rs.getString("COLOR");
			toyToAdd.age = rs.getInt("AGE");
			toyToAdd.material = rs.getString("MATERIAL");
			
			toys.add(toyToAdd);
			}
	}	catch (SQLException e1){
			System.out.println("SQLException" + e1.getMessage());
		}
	finally {
		try{ 
			if (rs!=null){
				//Close object ResultSet
				rs.close();
			}
		} catch (SQLException e2){			
		}
		try{
			if(s!=null) s.closeOnCompletion();
				
		} catch (SQLException e3){			
		}
		try{
			if (c!=null){
				c.close();
			}
		} catch (SQLException e4){			
		}
	}
	return toys;
	}
}