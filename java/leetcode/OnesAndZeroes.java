//Leetcode problem 474 Ones and Zeroes
//Solution written by Xuqiang Fang on 26 April, 2018 
//dp[i][j] means the maximum number of strings that can be formed with i ones and j zeros
class Solution{
    //solution @yangluphil
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];    
        int zero = 0;
        int one = 0;
        for(String s : strs){
            zero = 0;
            one = 0;
            for(char c : s.toCharArray()){
                if(c == '1'){
                    one++;
                }
                else{
                    zero++;
                }
            }
            for(int i=m; i>=zero; --i){
                for(int j=n; j>=one; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-zero][j-one]+1);
                }
            }
        }

        return dp[m][n];
    }	
}

public class OnesAndZeroes{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] strs = {"10","0001","111001","1","0"};
        System.out.println(s.findMaxForm(strs, 5,3));
	}
}
