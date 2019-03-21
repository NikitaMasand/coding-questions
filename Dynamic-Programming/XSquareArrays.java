/*
Xsquare loves to play with arrays a lot. Today, he has two arrays named as A and B.
Each array consists of N positive integers.

Xsquare has decided to fulfill following types of queries over his array A and array B.

1 L R : Print the value of AL + BL+1 + AL+2 + BL+3 + ... upto Rth term.
2 L R : Print the value of BL + AL+1 + BL+2 + AL+3 + ... upto Rth term.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class XSquareArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = reader.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        long queryNo = Long.parseLong(input[1]);
        String arr_1[] = reader.readLine().split(" ");
        String arr_2[] = reader.readLine().split(" ");
        long A[] = new long[size];
        long B[] = new long[size];
        for(int i=0;i<size;i++)
        {
            A[i] = Integer.parseInt(arr_1[i]);
            B[i] = Integer.parseInt(arr_2[i]);
        }
        for( int i=0;i<queryNo;i++)
        {
            String qinput[] = reader.readLine().split(" ");
            int choice = Integer.parseInt(qinput[0]);
            int L = Integer.parseInt(qinput[1])-1;
            int R = Integer.parseInt(qinput[2])-1;
            boolean flag;
            if( choice==1)
                flag = false;
            else
                flag = true;
            long sum = 0;
            for(int k=L;k<=R;k++)
            {
                if(flag==false)
                {
                    sum+=A[k];
                    flag=true;
                }
                else
                {
                    sum+=B[k];
                    flag=false;
                }
            }
            System.out.println(sum);

        }
    }
}
