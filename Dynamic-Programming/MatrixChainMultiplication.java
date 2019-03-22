import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter number of matrices: ");
	    int num = Integer.parseInt(reader.readLine());
	    int dimensions[] = new int[num+1];
	    System.out.println("Enter the dimensions of matrix in an array form");
	    /*
	    For [5,4,6,2,7] given Array
	    Matrices are
	    5X4
	    4X6
	    6X2
	    2X7
	    */
	    String input[] = reader.readLine().split(" ");
		for(int k=0; k<=num; k++)
		{
		    dimensions[k] = Integer.parseInt(input[k]);
		}
		Main object = new Main();
		int cost = object.findMinCost(dimensions);
		System.out.println("Min matrix multiplication cost is : "+cost);
	}
	// matrix Ai will have dimensions (dimensions[i-1] X dimensions[i])
	int findMinCost(int[]dimensions){
	    int n = dimensions.length;
	    int sub_mul[][] = new int[n][n];
	    //for simplicity of problem we will allocate one extra row and column 
	    //i.e 0th row and 0th column which are not in use
	    for(int k=1; k<n; k++)
	    {
	        sub_mul[k][k] = 0;
	    }
	    int left,right,temp_cost,c_length,variable_index;
	    //temp_cost is cost/scalar multiplication
	    /*
	    
	    length can be either 1,2,3,4
	    m[i][j] implies cost in multiplying matrices[i...j]
	    eg: m[1][2] implies cost in multiplying A1 A2
	    m[2][4] implies cost in multiplying A2 A3 A4
	    For length = 1, no cost as matrix is not multipled with anything, thus we assign m[i][i] = 0
	    
	    For length = 2
	    we can have A1XA2 or A2XA3 or A3XA4 
	    
	    For length = 3 
	    we can have A1XA2XA3 or A2XA3XA4 
	    For A1XA2XA3 
	    we have to find min of (A1)(A2XA3), (A1XA2)(A3)
	    and so on
	    
	    For length = 4 
	    we can have A1XA2XA3XA4 
	    and we need to find min of cost from  (A1)(A2XA3XA4), (A1XA2)(A3XA4), (A1XA2XA3)(A4)
	    
	    */
	    
	    // c_length is chain length
	    for(c_length=2; c_length<n; c_length++)
	    {
	        for(left=1; left< n-c_length+1; left++)
	        {
	            right = left+c_length-1;
	            sub_mul[left][right] = Integer.MAX_VALUE;
	            for(variable_index = left; variable_index<=right-1; variable_index++)
	            {
	                temp_cost = sub_mul[left][variable_index] +
	                            sub_mul[variable_index+1][right]+
	                            (dimensions[left-1]*dimensions[variable_index]*dimensions[right]);
                   if(temp_cost<sub_mul[left][right])
                   {
                       sub_mul[left][right] = temp_cost;
                   }
	            }
	        }
	    }
	    return sub_mul[1][n-1];
	}
	
}
