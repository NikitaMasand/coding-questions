import java.util.Scanner;

//This program will calculate the distance between two words.
//problem statement:
//Given two strings and operations edit, delete and add,
//how many minimum operations would it take to convert one string to another string.
/*
for eg. hlllo and hello are 1 edit away. changing l to e in hlllo will give hello
three types of edit can take place:
1. insert
2. delete
3. modify

note: inserting a new element in str1 is similar to deleting an element from str2
Applications:
Autocorrect uses min edit distance to find the correct word from the incorrect word you are typing
minEditDistance has a lot of applications in Natural Language Processing
 */


public class mineditdist {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word you typed: ");
        String a = sc.next();
        System.out.println("Enter the actual word in dictionary");
        String b = sc.next();
        mineditdist obj = new mineditdist();
        int out = obj.EditDist(a.toCharArray(),b.toCharArray());
        System.out.println("The minimum dist is: " + out);
    }
    public int EditDist(char [] str1, char[]str2)
    {
        int temp[][] = new int[str1.length+1][str2.length+1];
        for(int i=0;i<temp[0].length;i++)
        {
            temp[0][i] = i;
        }
        for(int i=0; i <temp.length;i++)
        {
            temp[i][0] = i;
        }
        for(int i=1;i<=str1.length;i++)
        {
            for(int j=1;j<=str2.length;j++)
            {
                if(str1[i-1]==str2[j-1])
                {
                    temp[i][j] = temp[i-1][j-1];
                }
                else
                {
                    temp[i][j] = 1 + Math.min((Math.min(temp[i-1][j-1], temp[i-1][j])),temp[i][j-1]);
                }
            }
        }
        printEdits(temp,str1,str2);
        return temp[str1.length][str2.length];
    }
    public void printEdits(int [][] temp, char[] str1, char[]str2)
    {
        int i = temp.length - 1;
        int j = temp[0].length - 1;
        while(true)
        {
            if(i==0 || j==0)
            {
                break;
            }
            else if (str1[i-1]==str2[j-1])
            {
                i = i-1;
                j = j-1;
            }
            else if(temp[i][j] == 1+temp[i-1][j-1])
            {
                System.out.println("edit "+ str2[j-1] + " in str2 to "+ str1[i-1]+" in str1");
                i = i-1;
                j = j-1;
            }
            else if(temp[i][j]==1+temp[i-1][j])
            {
                System.out.println("delete in str1: "+str1[i-1]);
                i = i-1;
            }
            else if(temp[i][j] == 1+temp[i][j-1])
            {
                System.out.println("delete in str2: "+ str2[j-1]);
                j = j-1;
            }
            else
            {
                throw new IllegalArgumentException("Something wrong with the data");
            }
        }
    }
}
