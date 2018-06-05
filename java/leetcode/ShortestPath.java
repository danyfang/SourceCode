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
/*
A path 'state' can be represented as the subset of nodes visited, plus the current 'head' node. 
Then, the problem reduces to a shortest path problem among these states, which can be solved with 
a breadth-first search.
Let's call the set of nodes visited by a path so far the cover, and the current node as the head. 
We'll store the cover states using set bits: k is in the cover if the kth bit of cover is 1.
*/
class State{
    int cover, head;
    State(int c, int h){
        cover = c;
        head = h;
    }
}
class Solution{
    //solution provided by user@awice
    //still cannot understand this
    public int shortestPathLength(int[][] graph){
        int N = graph.length;
        Queue<State> q = new LinkedList<>();
        int[][] dist = new int[1<<N][N];
        for(int[] row : dist){
            Arrays.fill(row, N*N);
        }
        for(int x=0; x<N; ++x){
            q.offer(new State(1<<x, x));
            dist[1<<x][x] = 0;
        }
        while(!q.isEmpty()){
            State node = q.poll();
            int d = dist[node.cover][node.head];
            if(node.cover == (1<<N)-1){
                return d;
            }
            for(int child : graph[node.head]){
                int cover2 = node.cover | (1 << child);
                if(d + 1 < dist[cover2][child]){
                    dist[cover2][child] = d + 1;
                    q.offer(new State(cover2, child));
                }
            }
        }
        throw null;
    }
    //solution by user@site1997
    public int shortestPathLength_(int[][] graph){
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
        System.out.println(s.shortestPathLength_(graph));
	}
}
