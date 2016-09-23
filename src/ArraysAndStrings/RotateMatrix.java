package ArraysAndStrings;

import java.util.Scanner;

public class RotateMatrix {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of matrix: ");
		int n = scan.nextInt();
		System.out.println("Enter all elements of the matrix: ");
		int[][] matrix = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]= scan.nextInt();
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
		scan.close();
		System.out.println("<-Reversed Matrix->");
		int[][] newMatrix = matrixRotate(matrix, n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(newMatrix[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	static int[][] matrixRotate(int[][] matrix, int n){
		for(int layer=0;layer<n/2;layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i=first;i<last;i++){
				int offset=i-first;
				//saving top element to temporary variable
				int top = matrix[first][i];
				//saving left element to top position
				matrix[first][i]=matrix[last-offset][first];
				//saving bottom element to left position
				matrix[last-offset][first]=matrix[last][last-offset];
				//saving right element to bottom
				matrix[last][last-offset]=matrix[i][last];
				//saving top element to right
				matrix[i][last]= top;				
			}
		}
		return matrix;
	}

}
