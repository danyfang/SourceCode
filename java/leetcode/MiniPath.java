//Leetcode problem 64 Minimum Path Sum
//Solution written by Xuqiang Fang on 08 March 2018
//solution accepted, using dynamic programming
class Solution{
	public int minPathSum(int[][] grid){
		int row = grid.length;
		int col = grid[0].length;

		int[][] dp = new int[row][col];
		dp[0][0] = grid[0][0];
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(i == 0 && j >= 1 )
					dp[i][j] = grid[i][j]+dp[i][j-1];
				if(j == 0 && i>= 1)
					dp[i][j] = grid[i][j]+dp[i-1][j];
				if(i>=1 && j>=1)	
					dp[i][j] = grid[i][j] + ((dp[i-1][j] > dp[i][j-1]) ? dp[i][j-1] : dp[i-1][j]);
			}
		}

		return dp[row-1][col-1];
	}	
}

public class MiniPath{
	public static void main(String[] args){
		Solution s = new Solution();
		int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(s.minPathSum(grid));
	}
}
