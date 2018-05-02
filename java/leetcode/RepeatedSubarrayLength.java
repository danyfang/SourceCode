//Leetcode problem 718 Maximum Length of Repeated Subarray
//Solution written by Xuqiang Fang on 1 May, 2018 
// the subarray has to be contiguous
class Solution{
    public int findLength(int[] A, int[] B){
        int a = A.length;
        int b = B.length;
        int[][] dp = new int[a+1][b+1];
        //dp[i][j] maximum length of A[0,...,i] and B[0,...,j]
        int max = 0;
        for(int i=1; i<=a; ++i){
            for(int j=1; j<=b; ++j){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }	
}

public class RepeatedSubarrayLength{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(s.findLength(A,B));
	}
}
