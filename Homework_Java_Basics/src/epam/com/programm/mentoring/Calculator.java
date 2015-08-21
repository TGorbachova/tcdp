/**
 * This class performs addition, subtraction, multiplication and division
 * ©author Tetiana Horbachova
 * @version 1. 0
 */

package epam.com.programm.mentoring;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		//Get first operand
		System.out.println("Please enter first variable");
		Scanner scFirst = new Scanner(System.in);
		double i = scFirst.nextDouble();
		
		//Get second operand
		System.out.println("Please enter second variable");
		Scanner scSecond = new Scanner(System.in);
		double n = scSecond.nextDouble();
		
		//Get operation type
		System.out.println("Please enter operation, avaiable type are / + - *");
		Scanner scOper = new Scanner(System.in);
		String op = scOper.nextLine();
		
		double k = 0;
		
		//Call method which performs identification and performs operation defined by user
		k = getOperator(i, n, op, k);
		
		//Print result
		System.out.print("Result is ");
		System.out.println(k);
		
		//Close scanners 
		scFirst.close();
		scSecond.close();
		scOper.close();
	}

	//Method identifies and perform operation defined by user
	private static double getOperator(double i, double n, String op, double k) {
		switch (op) {
		case "/": k = i/n; break;
		case "+": k = i+n; break;
		case "-": k = i-n; break;
		case "*": k = i*n; break;
		default: System.out.println("Incorrect operation entered");
		}
		return k;
	}

}
