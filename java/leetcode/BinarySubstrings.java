//Leetcode problem 696 Count Binary Substrings
//Solution written by Xuqiang Fang on 10 May, 2018
class Solution{
    public int countBinarySubstrings(String s){
        //positive for 1
        //negative for 0
        char[] ch = s.toCharArray();
        int[] dp = new int[s.length()]; 
        if(ch[0] == '0'){
            dp[0] = -1;
        }
        else{
            dp[0] = 1;
        }
        for(int i=1; i<dp.length; ++i){
            if(ch[i] == ch[i-1]){
                if(ch[i] == '0'){
                    dp[i] = dp[i-1] - 1;
                } 
                else{
                    dp[i] = dp[i-1] + 1;
                }
            }
            else{
                if(ch[i] == '0'){
                    dp[i] = -1;
                }
                else{
                    dp[i] = 1;
                }
            }
        }

        int count = 0;
        for(int i=0; i<dp.length; ++i){
            //System.out.println(dp[i]);
            int j = Math.abs(dp[i]);
            if(i-j >= 0 && Math.abs(dp[i]) <= Math.abs(dp[i-j])){
                //print the legitimate substrings
                //System.out.println(s.substring(i-2*j+1,i+1));
                count++; 
            }
        }

        return count;
    }
}

public class BinarySubstrings{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.countBinarySubstrings("00110011"));
        System.out.println(s.countBinarySubstrings("10101"));
        System.out.println(s.countBinarySubstrings("10"));
	}
}
