//Leetcode problem 886 Reachable Nodes in Subdivided Graph
//Solution written by Xuqiang Fang on 5 Aug, 2018
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
    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph = new int[N][N];     
        for(int i=0; i<N; ++i){
            Arrays.fill(graph[i], -1);
        }
        for(int[] e : edges){
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(b[1]-a[1]));
        boolean[] visited = new boolean[N];
        pq.offer(new int[]{0, M});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int start = cur[0];
            int move = cur[1];
            if(visited[start]){
                continue;
            }
            visited[start] = true;
            ans++;
            for(int i=0; i<N; ++i){
                if(graph[start][i] > -1){
                    if(move > graph[start][i] && !visited[i]){
                        pq.offer(new int[]{i, move-graph[start][i]-1});
                    }
                    graph[i][start] -= Math.min(move, graph[start][i]);
                    ans += Math.min(move, graph[start][i]);
                }
            }
        }
        return ans;
    }
}

public class ReachableNodes{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] edges = new int[][]{{0,1,10}, {0,2,1},{1,2,2}};
        System.out.println(s.reachableNodes(edges, 6, 3));
        edges = new int[][]{{0,1,4},{1,2,6},{0,2,8},{1,3,1}};
        System.out.println(s.reachableNodes(edges, 10, 4));
	}
}
