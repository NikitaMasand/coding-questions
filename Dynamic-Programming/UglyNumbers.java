//Ugly numbers are numbers whose only prime factors are 2, 3 or 5. By convention, 1 is included.
//Given a number n, find n’th Ugly number.

import java.util.Scanner;
import java.lang.Math;
public class UglyNumbers {
    public int getNthUglyNumber(int n)
    {
        int ugly[] = new int[n];
        ugly[0]=1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int next_multipleOf2 = ugly[i2]*2;
        int next_multipleOf3 = ugly[i3]*3;
        int next_multipleOf5 = ugly[i5]*5;
        for(int i = 1 ;i<n; i++)
        {
            ugly[i] = Math.min(next_multipleOf2,Math.min(next_multipleOf3,next_multipleOf5));
            if(ugly[i]==next_multipleOf2)
            {
                i2++;
                next_multipleOf2 = ugly[i2]*2;
            }
            if(ugly[i]==next_multipleOf3)
            {
                i3++;
                next_multipleOf3 = ugly[i3]*3;
            }
            if(ugly[i]==next_multipleOf5)
            {
                i5++;
                next_multipleOf5 = ugly[i5]*5;
            }
        }
        return ugly[n-1];
    }
    public static void main(String args[])
    {
        System.out.println("Enter the value of n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UglyNumbers obj = new UglyNumbers();
        System.out.println(n+"th ugly number is : "+ obj.getNthUglyNumber(n));
    }
}
