//Leetcode problem 329 Longest Increasing Path in a Matrix
//Solution written by Xuqiang Fang on  23 May, 2018
class Solution{
    //Unfortunately, TLE
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                dp[i][j] = dfs(matrix, m, n, i, j, dp);
                max = Math.max(max, dp[i][j]);
                /*
                for(int x=0; x<m; ++x){
                    for(int y=0; y<n; ++y){
                        System.out.print(matrix[x][y]);
                    }
                    System.out.println("\n");
                }
                */
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] dp){
        if(i<0 || i>=m || j<0 || j>=n || matrix[i][j] == Integer.MIN_VALUE){
            return 0;
        }
        else if(dp[i][j] > 0){
            return dp[i][j];
        }
        System.out.println("i = " + i + " j = " + j);
        int sum = 1;
        int original = matrix[i][j];
        matrix[i][j] = Integer.MIN_VALUE;
        int l = 0, r = 0, u = 0, d = 0;
        if(i-1 >= 0 && matrix[i-1][j] > original){
            u = dfs(matrix, m, n, i-1, j, dp);
        }
        if(i+1 < m && matrix[i+1][j] > original){
            d = dfs(matrix, m, n, i+1, j, dp);
        }
        if(j-1 >= 0 && matrix[i][j-1] > original){
            l = dfs(matrix, m, n, i, j-1, dp);
        }
        if(j+1 < n && matrix[i][j+1] > original){
            r = dfs(matrix, m, n, i, j+1, dp);
        }
        sum +=  Math.max(Math.max(l,r), Math.max(u,d));
        matrix[i][j] = original;
        dp[i][j] = sum;
        return sum;
    }
}

public class IncreasingPath{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int[][] nums = {{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}};
        int[][] mat = {
        {0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}
        };
        System.out.println(s.longestIncreasingPath(matrix));
        System.out.println(s.longestIncreasingPath(nums));
        System.out.println(s.longestIncreasingPath(mat));
	}
}
