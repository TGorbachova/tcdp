/**
 * This class finds return matrix
 * ©author Tetiana Horbachova
 * @version 1. 0
 */

package com.epam.programm.mentoring;

public class matrix {

	public static void main(String[] args) {
		
		double[][] matrix = new double [2][2];
		double[][] returnMatrix = new double [2][2];
		
		//Initialize matrix 
		
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[1][0] = 3;
		matrix[1][1] = 4;
				
		double oprMatrix;
		
		//Find determinant of matrix
		
		oprMatrix = 1/(matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]);
		
		//Check if return matrix exists
		
		if (oprMatrix != 0) {
			
			//Find return matrix
			
			returnMatrix[0][0] = oprMatrix*matrix[1][1];
			returnMatrix[0][1] = oprMatrix*matrix[1][0];
			returnMatrix[1][0] = oprMatrix*matrix[0][1];
			returnMatrix[1][1] = oprMatrix*matrix[0][0];
			
			//Matrix
			System.out.println("Matrix");
			System.out.println(matrix[0][0] + "  " + matrix[0][1]);
			System.out.println(matrix[1][0] + "  " + matrix[1][1]);
			//Print return matrix
			System.out.println("Return matrix is:");
			System.out.println(returnMatrix[0][0] + "  " + returnMatrix[0][1]);
			System.out.println(returnMatrix[1][0] + "  " + returnMatrix[1][1]); 
						
		}
		else {
			
			//Return matrix does not exist if determinant of matrix is equal to 0
			System.out.println("Return matrix does not exist");
		}	
		
	}

}
