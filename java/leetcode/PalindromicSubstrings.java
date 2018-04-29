//Leetcode problem 647 Palindromic Substrings
//Solution written by Xuqiang Fang on 29 April, 2018 


//here dp[i][j] substring of length i+1, end with j
class Solution{
    public int countSubstrings(String s){
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = n;
        //length 1
        for(int i = 0; i<n; ++i){
            dp[0][i] = 1;
        }
        //length 2
        for(int i=1; i<n; ++i){
            if(s.charAt(i) == s.charAt(i-1)){
                dp[1][i] = 1;
                count++;
            }
        }
        //length 3 and above
        for(int i=2; i<n; ++i){
            for(int j=i; j<n; ++j){
                if(dp[i-2][j-1] == 1 && s.charAt(j-i) == s.charAt(j)){
                    dp[i][j] = 1;
                    //System.out.println(s.substring(j-i,j+1));
                    count++;
                }
            }
        }

        return count;
    }	

}

public class PalindromicSubstrings{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.countSubstrings(args[0]));
	}
}
