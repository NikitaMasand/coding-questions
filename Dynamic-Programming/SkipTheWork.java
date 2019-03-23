/*
Given an array A[ ] denoting the time taken to complete N tasks, determine the minimum amount of time 
required to finish the tasks considering that you can skip any task, 
but skipping two consecutive tasks is forbidden.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkipTheWork {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test_Cases = Integer.parseInt(reader.readLine());
        while(test_Cases-->0){
            int size = Integer.parseInt(reader.readLine());
            String input[] = reader.readLine().split(" ");
            int tasks[] = new int[size];
            for(int i=0;i<size;i++)
            {
                tasks[i] = Integer.parseInt(input[i]);
            }
            int minTime = calcMin(tasks);
            System.out.println(minTime);
        }
    }
    static int calcMin(int[]tasks)
    {
        int incl = tasks[0];
        int excl = 0;
        for(int i=1; i<tasks.length; i++)
        {
            int incl_new = tasks[i] + Math.min(incl,excl);
            int excl_new = incl;
            incl = incl_new;
            excl = excl_new;
        }
        return Math.min(incl,excl);
    }
}
