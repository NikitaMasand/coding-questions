class LongestCommonSubsequence{
    static char[] lcs_dp(char[]string_1,char[]string_2){
        int length_1 = string_1.length;
        int length_2 = string_2.length;
        int sub_store[][] = new int[length_1+1][length_2+1];
        for(int index_1 =1;index_1<sub_store.length;index_1++){
            for(int index_2=1;index_2<sub_store[0].length;index_2++){
                if(string_1[index_1-1]==string_2[index_2-1])
                {
                    sub_store[index_1][index_2] = 1+sub_store[index_1 - 1][index_2 - 1];
                }
                else
                {
                    sub_store[index_1][index_2] = Math.max(sub_store[index_1 - 1][index_2],sub_store[index_1][index_2-1]);
                }
            }

        }
        int index = sub_store[length_1][length_2];
        int temp = index;
        char[]lcs = new char[index];
        int index_1 = length_1, index_2 = length_2;
        while(index_1>0 && index_2>0 )
        {
            if(string_1[index_1-1]==string_2[index_2-1])
            {
                lcs[index-1]=string_1[index_1-1];
                index--;
                index_1--;
                index_2--;
            }
            else if(sub_store[index_1-1][index_2]>sub_store[index_1][index_2-1])
            {
                index_1--;
            }
            else {
                index_2--;
            }
        }
        return lcs;
    }
    public static void main(String[]args){
        String a = "I am waiting";
        String b = "I've been waiting";
       char arr[] = new char [a.length()];
             arr =  lcs_dp(a.toCharArray(),b.toCharArray());
       for(int i = 0;i<arr.length;i++)
       {
           System.out.print(arr[i]);
       }
    }
}