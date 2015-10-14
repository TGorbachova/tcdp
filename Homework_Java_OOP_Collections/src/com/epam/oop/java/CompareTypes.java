/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

import java.util.*;

public class CompareTypes {
	
	//Method implements comparation of the adding new elements to collections 
	 private static void compareAddElementToCollections() { 
	          System.out.println("Second task:");
	          System.out.println("1. Add element to collection:"); 
	          ArrayList<Integer> arrayList = new ArrayList<Integer>(); 
	          long start = System.nanoTime(); 
	          for(int i = 1; i<10000; i += 1) { 
	              arrayList.add(i); 
	          } 
	          long finish = System.nanoTime(); 
	          System.out.println("\t Adding 10 000 elements to ArrayList collection takes " + (finish - start) + " milisec"); 
	   
	          LinkedList<Integer> linkedList = new LinkedList<Integer>(); 
	          start = System.nanoTime(); 
	          for(int i = 1; i<10000; i += 1) {  
	              linkedList.add(i); 
	          } 
	          finish = System.nanoTime(); 
	          System.out.println("\t Adding 10 000 elements to LinkedList collection takes" + (finish - start) + " milisec"); 
	   
	          HashSet<Integer> hashSet = new HashSet<Integer>();
	          start = System.nanoTime(); 
	          for(int i = 1; i<10000; i += 1) {  
	              hashSet.add(i); 
	          } 
	          finish = System.nanoTime(); 
	          System.out.println("\t Adding 10 000 elements to HashSet collection takes" + (finish - start) + " milisec"); 
	   
	          TreeSet<Integer> treeSet = new TreeSet<Integer>(); 
	          start = System.nanoTime(); 
	          for(int i = 1; i<10000; i += 1) {  
	              treeSet.add(i); 
	          } 
	          finish = System.nanoTime(); 
	          System.out.println("\t Adding 10 000 elements to TreeSet collection takes" + (finish - start) + " milisec"); 
	   
	          HashMap<String, Integer> hashMap = new HashMap<String, Integer>(); 
	          start = System.nanoTime(); 
	          for(int i = 1; i<10000; i += 1) {  
	              hashMap.put("value "+i, i); 
	          } 
	          finish = System.nanoTime(); 
	          System.out.println("\t Adding 10 000 elements to HashMap collection takes" + (finish - start) + " milisec"); 
	   
	          TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(); 
	          start = System.nanoTime(); 
	          for(int i = 1; i<10000; i += 1) {  
	              treeMap.put("value "+i, i); 
	          } 
	          finish = System.nanoTime(); 
	          System.out.println("\t Adding 10 000 elements to TreeMap collection takes" + (finish - start) + " milisec"); 
	      } 
	   
	//Method implements comparation of the search element in the collections
	      private static void compareSearchInCollections() 
	      { 
	          long start, finish; 
	          System.out.println("2. Search element in collection:"); 
	          ArrayList<Integer> arrayList = new ArrayList<Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	        	  arrayList.add(i); 
	          } 
	          start = System.nanoTime(); 
	          boolean value = arrayList.contains(5489); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Search element in ArrayList collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          LinkedList<Integer> linkedList = new LinkedList<Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	              linkedList.add(i); 
	          } 
	          start = System.nanoTime(); 
	          value = linkedList.contains(5489); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Search element in LinkedList collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          HashSet<Integer> hashSet = new HashSet<Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	              hashSet.add(i); 
	          } 
	          start = System.nanoTime(); 
	          value = hashSet.contains(5489); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Search element in HashSet collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          TreeSet<Integer> treeSet = new TreeSet<Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	              treeSet.add(i); 
	          } 
	          start = System.nanoTime(); 
	          value = treeSet.contains(5489); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Search element in TreeSet collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          int intValue; 
	          HashMap<String, Integer> hashMap = new HashMap<String, Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	              hashMap.put("value "+i, i); 
	          } 
	          start = System.nanoTime(); 
	          intValue = hashMap.get("value 5489"); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Search element in HashMap collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(); 
	          for(int i = 1; i<10000; i += 1) {
	              treeMap.put("value "+i, i); 
	          } 
	          start = System.nanoTime(); 
	          intValue = treeMap.get("value 5489"); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Search element in TreeMap collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	      } 
	   
	    //Method implements comparation of the remove elements from the collections
	      private static void compareRemoveFromCollections() 
	      { 
	          long start, finish; 
	          System.out.println("3. Remove from collections:"); 
	          ArrayList<Integer> arrayList = new ArrayList<Integer>(); 
	          for(int i = 1; i<10000; i += 1) {  
	              arrayList.add(i); 
	          } 
	          start = System.nanoTime(); 
	          arrayList.clear(); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Remove from ArrayList collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          LinkedList<Integer> linkedList = new LinkedList<Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	              linkedList.add(i); 
	          } 
	          start = System.nanoTime(); 
	          linkedList.clear(); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Remove from LinkedList collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          HashSet<Integer> hashSet = new HashSet<Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	              hashSet.add(i); 
	          } 
	          start = System.nanoTime(); 
	          hashSet.clear(); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Remove from HashSet collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          TreeSet<Integer> treeSet = new TreeSet<Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	              treeSet.add(i); 
	          } 
	          start = System.nanoTime(); 
	          treeSet.clear(); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Remove from TreeSet collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          HashMap<String, Integer> hashMap = new HashMap<String, Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	              hashMap.put("value "+i, i); 
	          } 
	          start = System.nanoTime(); 
	          hashMap.clear(); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Remove from HashMap collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	   
	          TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(); 
	          for(int i = 1; i<10000; i += 1) { 
	              treeMap.put("value "+i, i); 
	          } 
	          start = System.nanoTime(); 
	          treeMap.clear(); 
	          finish = System.nanoTime(); 
	          System.out.println("\t Remove from TreeMap collection with 10 000 elements takes " + (finish - start) + " milisec"); 
	      } 
	   
	   //Method implements start comparation for the collection
	      public static void comparativeAnalysis() 
	     { 
	    	  compareAddElementToCollections(); 
	          compareSearchInCollections(); 
	          compareRemoveFromCollections(); 
	      } 


}
