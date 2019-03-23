/*
A frog jumps either 1, 2 or 3 steps to go to top. In how many ways can it reach the top
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HopsFrogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test_Cases = Integer.parseInt(reader.readLine());
        while(test_Cases-- >0)
        {
            int steps = Integer.parseInt(reader.readLine());
            int ways = countWays(steps);
            System.out.println(ways);
        }
    }
    static int countWays(int steps){
        int stepArr[] = new int[steps];
        if(steps==1)
            return 1;
        if(steps==2)
            return 2;
        if(steps==3)
            return 4;
        stepArr[0] = 1;
        stepArr[1] = 2;
        stepArr[2] = 4;
        for(int i=3; i<steps; i++){
            stepArr[i] = stepArr[i-1] + stepArr[i-2] + stepArr[i-3];
        }
        return stepArr[steps-1];

    }
}

