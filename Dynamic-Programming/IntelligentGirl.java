import java.io.BufferedReader;

/*
IntelligentGirl:
Soumika has a string S and its starting index is 1.
The string S consists of characters from 1-9.
As she is very intelligent, she wants to test his brother Vinay Tendulkar.
She asked her brother Vinay Tendulkar to count the number of even numbered characters
 ( i.e 2,4,6,8 ) for every index i.
 For an index i, the result should be calculated from i to the end of the string.
 As Vinay doesn't know about programming, he wants you to help him find the solution.
 */

import java.io.IOException;
import java.io.InputStreamReader;

public class IntelligentGirl {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int output[] = calculate_even(input);
        for(int i=0;i<output.length;i++)
        {
            System.out.print(output[i]+" ");
        }
    }
    static int[] calculate_even(String input)
    {
        int size = input.length();
        int store[] = new int[size];
        if( input.charAt(size-1)%2==0)
            store[size-1]=1;
        else
            store[size-1]=0;
        for(int i=size-2;i>=0;i--)
        {
            if( input.charAt(i)%2==0)
                store[i]=store[i+1]+1;
            else
                store[i] = store[i+1];
        }
        return store;
    }
}
