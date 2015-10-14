/**
 * ©author Tetiana Horbachova
 * @version 1. 0
 */
package com.epam.oop.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser extends Files {
	
	private static int convertFromStringToInteger(String value){
		return Integer.parseInt(value);
	}
	
	
	public ArrayList<Toy> readFromFile() {
		//read data from XML file
		ArrayList<Toy> toys = new ArrayList<Toy>();
		try{
			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			fileExist = true;

			doc.getDocumentElement().normalize();
			//add data from XML file to the list of toys
			NodeList nList = doc.getElementsByTagName("toy");
			for (int i = 0; i< nList.getLength(); i++){
				Node nNode = nList.item(i);
				Toy toy = new Toy();
				if (nNode.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) nNode;
                    toy.setName(element.getAttribute("name"));
                    toy.setSize(element.getElementsByTagName("size").item(0).getTextContent());
                    toy.setPrice(convertFromStringToInteger(element.getElementsByTagName("price").item(0).getTextContent()));
                    toy.setColor(element.getElementsByTagName("color").item(0).getTextContent());
                    toy.setAge(convertFromStringToInteger(element.getElementsByTagName("age").item(0).getTextContent()));
                    toy.setMaterial(element.getElementsByTagName("material").item(0).getTextContent());
               
				}
				toys.add(toy);
			}
		} catch (FileNotFoundException e){
			System.out.println("File does not found");
            fileExist = false;			
		} catch (NullPointerException e){
			System.out.println("File does not found");
            fileExist = false;
		} catch (Exception e) {
            e.printStackTrace();
            fileExist = false;
        }
		
		return toys;
	}
	//Set file name
	@Override
	public void setFileName(String fileName) {
        this.fileName = fileName + ".xml";		
	}
	

}
