/*
Question:
Given a M X N matrix with your initial position at top-left cell,
find the number of possible unique paths to reach the bottom right cell of the matrix from the initial position.
Note: Possible moves can be either down or right at any point in time, i.e., 
we can move to matrix[i+1][j] or matrix[i][j+1] from matrix[i][j]
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(reader.readLine());
		while(test_case -- >0)
		{
		    String input[] = reader.readLine().split(" ");
		    int row = Integer.parseInt(input[0]);
		    int col = Integer.parseInt(input[1]);
		    int matrix[][] = new int[row][col];
		    for(int i=0; i<row; i++)
		    {
		        matrix[i][0] = 1;
		    }
		    for(int j=0; j<col; j++)
		    {
		        matrix[0][j] = 1;
		    }
		    for(int i=1; i<row; i++)
		    {
		        for(int j=1; j<col; j++)
		        {
		            matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
		        }
		    }
		    
		    System.out.println(matrix[row-1][col-1]);
		}
	}
}
