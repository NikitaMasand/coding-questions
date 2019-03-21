/*
For a particular theory, the time at which it was proposed be T1
and the time at which it becomes invalid be T2.
We define the theory period for this particular theory as [T1, T2).
Both T1 and T2 are recorded in seconds from some reference point, B.
We are given the theory periods for a number of theories.
It is possible that more than one theory in the field A
might be valid at some second, T (Recorded with reference to B ).
Let us call the value of the number of valid theories at the second T
as popularity of the field at second T.
The popularity of the field would be maximum at some point in time.
Your task is simple,
that is calculate this maximum value of popularity for the field A.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class prateekTheory {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(reader.readLine());
        while (test_cases-- >0)
        {
            int n = Integer.parseInt(reader.readLine());
            int left[]=new int[n];
            int right[]=new int[n];
            int max=0;
            int min = 0;
            for(int i=0;i<n;i++)
            {
                String input[]=reader.readLine().split(" ");
                left[i] = Integer.parseInt(input[0]);
                right[i] = Integer.parseInt(input[1])-1;
                if(right[i]>max)
                    max = right[i];
                if(left[i]<min)
                    min = left[i];
            }
            int arr[] = new int[max+1];
            for(int i=0;i<n;i++)
            {
                for(int k=left[i];k<=right[i];k++)
                    arr[k]++;
            }
            int result = 0;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]>=result)
                    result = arr[i];
            }
            System.out.println(result);

        }
    }
}
