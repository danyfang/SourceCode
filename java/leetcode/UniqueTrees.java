//Leetcode problem 96 Unique Binary Search Trees
//Solution written by Xuqiang Fang on 25 March 2018 
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x){
		val = x;
	}
}
class Solution{
	public int numTrees(int n){
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				dp[i] += dp[j-1] * dp[i-j];
			}
		}
		return dp[n];
	}	
}

public class UniqueTrees{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.numTrees(Integer.valueOf(args[0])));
	}
}
