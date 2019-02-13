//Using Dynamic Programming
//here we won't be calculating same sum again and again when including and excluding as done in the previous approach.
//Here we will follow a dynamic programming approach as shown
// Time complexity : O(n^2)
// Space complexity : O(n)

import java.util.Scanner;

public class msisdynamic {
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
            int sum = calcSum(arr);
            System.out.println(sum);
        }
        public static int calcSum(int arr[])
        {
            int temp[] = new int[arr.length];
            for(int i = 0;i<temp.length;i++)
            {
                temp[i]=arr[i];
            }
            for(int i = 1; i<arr.length;i++)
            {
                for(int j = 0;j<i;j++)
                {
                    if(arr[i]>arr[j])
                    {
                        temp[i] = Math.max(temp[i],temp[j]+arr[i]);
                    }
                }
            }
            int max = temp[0];
            for(int i = 1;i<temp.length;i++)
            {
                if(temp[i]>max)
                {
                    max = temp[i];
                }
            }
            return max;
        }
}
