/*
Given a string, count number of subsequences of the form aibjck, 
i.e., it consists of i ’a’ characters, followed by j ’b’ characters, followed by k ’c’ characters where i >= 1, j >=1 and k >= 1.
Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
*/
import java.util.*;
public class Subsequence 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sequence: ");
        String sequence = input.nextLine();
        System.out.println("Number of subsequences of type 'a^i b^j c^k' in given input are: "
                            + count_subseq(sequence));
        
    }
    static int count_subseq(String sequence)
    {
        int a_count = 0;
        int b_count = 0;
        int c_count = 0;
        for(int i = 0;i<sequence.length(); i++)
        {
            if( sequence.charAt(i) == 'a')
                a_count = 1 + (2*a_count);
            else if( sequence.charAt(i) == 'b' )
                b_count = a_count + (2*b_count);
            else if( sequence.charAt(i) == 'c')
                c_count = b_count + (2*c_count);
        }
        return c_count;
    }
}
