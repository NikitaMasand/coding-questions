//recursive approach
// time complexity : O(2^n)
// space complexity : O(1) (no extra arrays or anything is used)
// however recursive calls to the same function will take memory in the call stack


//Problem statement:
//Find the subsequence of the given sequence of positive numbers
// such that subsequence sum is as high as possible and all the elements
//of the subsequence are in sorted order, from lowest to highest
//The subsequence is not necessarily contiguous or unique


//Our approach will be to everytime check if the encountered element
// should(only if it's less than the previous element if the previous one is included)
// or should not be included in the subseq.
//For each of that condition we will check for other elements too in the recursive approach
//Thus the recursion tree formed will have 2 raised to n possibilities
import java.util.Scanner;
public class msis {
    public static void main(String[] args) {
        System.out.println("What is the size of your array?");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arr[] = new int[k];
        System.out.println("Enter the elements: ");
        for(int i=0;i<k;i++)
        {
            arr[i] = sc.nextInt();
        }
        int sum = calcSum(arr,0,arr.length,Integer.MIN_VALUE,0);
        System.out.println(sum);


    }
    public static int calcSum(int arr[], int index, int n, int prev, int sum)
    {
        //base case
        if(index == n)
        {
            return sum;
        }
        //excluding the current element and processing the other remaning elements
        int excl = calcSum(arr,index+1, n, prev, sum);
        //including the current element but only if it is lesser than the previous one
        int incl = sum;
        if(arr[index]>prev)
        {
            incl = calcSum(arr,index+1, n, arr[index],arr[index]+sum);
        }
        return Integer.max(excl,incl);
    }

}

