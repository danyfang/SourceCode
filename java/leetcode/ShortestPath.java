//Leetcode problem 847 Shortest Path Visiting All Nodes
//Solution written by Xuqiang Fang on 4 June, 2018
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
    public int shortestPathLength(int[][] graph){
        int n = graph.length;
        for(int i=0; i<n; ++i){
            Arrays.fill(dis[i], 0x3f);
        }
        for(int i=0; i<n; ++i){
            for(int j=0; j<graph[i].length; ++j){
                dis[i][graph[i][j]] = 1; 
            }
        }
        floyd(n);
        /*
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                System.out.print(dis[i][j] + " ");
            }
            System.out.println("");
        }
        */
        int min = dpfunc(n);
        return min;
    }
    private int dpfunc(int n){
        for(int i=0; i<dp.length; ++i){
            Arrays.fill(dp[i], 0x3f);
        }
        for(int i=0; i<n; ++i){
            dp[1<<i][i] = 0;
        }
        for(int g=1; g<(1<<n); g++){
            for(int u=0; u<n; ++u){
                for(int v=0; v<n; ++v){
                    int src = 1 << u;
                    int dst = 1 << v;
                    if((g&src) != 0 && (g&dst) == 0){
                        //System.out.println("src : " + src + ", dst : " + dst);
                        dp[g|dst][v] = Math.min(dp[g|dst][v], dp[g][u] + dis[u][v]);
                    }
                }
            }
        }
        int min = 0x3f3f3f;
        for(int i=0; i<n; ++i){
            min = Math.min(dp[(1<<n)-1][i], min);
        }
        return min;
    }
    private void floyd(int n){
        for(int k=0; k<n; ++k){
            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
    }
    private int[][] dis = new int[15][15];
    private int[][] dp = new int[1<<13][13];
}

public class ShortestPath{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] graph = {{1,2,3},{0},{0},{0}};
        System.out.println(s.shortestPathLength(graph));
	}
}
