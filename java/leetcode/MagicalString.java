//Leetcode problem 481 Magical String
//Solution written by Xuqiang Fang on 2 May, 2018 

class Solution{
    public int magicalString(int n){
        if(n == 0)
            return 0;
        else if(n <= 3)
            return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        int index = 1;
        int next = 1;
        while(next < n){
            if(index % 2 != 0){//this index is for 2
                int temp = dp[index];
                while(temp-- > 0 && next < n){
                    dp[next++] = 2;
                }
            }
            else{//this index is for 1
                int temp = dp[index]; 
                while(temp-- > 0 && next < n){
                    dp[next++] = 1;
                }
            }
            index++;
        }
        int count = 0;
        for(int i : dp){
            System.out.println(i);
            if(i == 1)
                count++;
        }
        return count;
    }	
}

public class MagicalString{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.magicalString(Integer.valueOf(args[0])));
	}
}
