//Leetcode problem  221 Maximal Square
//Solution written by Xuqiang Fang on 12 May, 2018
class Solution{
    public int maximalSquare(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
       
        for(int i=1; i<=m; ++i){
            for(int j=1; j<=n; ++j){
                dp[i][j] = matrix[i-1][j-1] - '0' + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        
        for(int i=1; i<=m; ++i){
            for(int j=1; j<=n; ++j){
                for(int k = Math.min(m-i+1, n-j+1); k>0; --k){
                    int sum = dp[i+k-1][j+k-1] - dp[i+k-1][j-1] - dp[i-1][j+k-1] + dp[i-1][j-1];            
                    if(sum == k * k){
                        max = Math.max(max, sum);
                        break;
                    }
                }
            }
        }
        return max;
    }
}

public class MaximalSquare{
	public static void main(String[] args){
		Solution s = new Solution();
        char[][] matrix = { {'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};
        System.out.println(s.maximalSquare(matrix));
	}
}
