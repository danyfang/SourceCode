//Leetcode problem 576 Out of Boundary Paths
//Solution written by Xuqiang Fang on 16 Junw, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    /*
    * Key observation:
        # of paths start from (i, j) to out of boundary <=>
        # of paths start from out of boundary to (i,j)
    * The number of paths is directly related to its neighbor
    */
    public int findPaths(int m, int n, int N, int a, int b) {
        int mod = 1000000007;
        int[][][] dp = new int[N+1][m][n]; 
        int[] dir = {0,1,0,-1,0};
        for(int k=1; k<=N; ++k){
            for(int i=0; i<m; ++i){
                for(int j=0; j<n; ++j){
                    for(int d=0; d<4; ++d){
                        int x = i+dir[d];
                        int y = j+dir[d+1];
                        if(x<0 || x>=m || y<0 ||y>=n){
                            dp[k][i][j] += 1;
                        }
                        else{
                            dp[k][i][j] += dp[k-1][x][y];
                            dp[k][i][j] %= mod;
                        }
                    }
                }
            }
        }
        return dp[N][a][b];
    }
}

public class BoundaryPaths{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.findPaths(2,2,2,0,0));
        System.out.println(s.findPaths(1,3,3,0,1));
	}
}
