package ArraysAndStrings;

import java.util.Scanner;

public class ZeroMatrix {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no. of rows in the matrix: ");
		int rows = scan.nextInt();
		System.out.println("Enter the no. of columns in the matrix: ");
		int cols = scan.nextInt();
		int[][] matrix = new int[rows][cols];
		boolean[] row = new boolean[rows];
		boolean[] column = new boolean[cols];
		for(int i=0;i<rows;++i){
			for(int j=0;j<cols;++j){
				matrix[i][j]=scan.nextInt();
				if(matrix[i][j]==0){
					row[i] = true;
					column[j] = true;
				}
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println(" ");
		} 
		scan.close();
		for(int i=0;i<row.length;++i){
			if(row[i]) nullifyRow(matrix, i);
		}
		for(int j=0;j<column.length;++j){
			if(column[j]) nullifyColumn(matrix, j);
		}
		System.out.println("New Matrix");
		for(int i=0;i<matrix.length;++i){
			for(int j=0;j<matrix[0].length;++j){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
	static int[][] nullifyRow(int[][] matrix, int row){
		for(int j=0;j<matrix[0].length;++j){
			matrix[row][j] = 0;
		}
		return matrix;
	}
	
	static int[][] nullifyColumn(int[][] matrix, int column){
		for(int i=0;i<matrix.length;++i){
			matrix[i][column]=0;
		}
		return matrix;
	}

}
