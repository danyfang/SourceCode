//Leetcode problem 815 Bus Routes
//Solution written by Xuqiang Fang on 21 June, 2018
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
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T){
            return 0;
        }
        int n = routes.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; ++i){
            for(int j : routes[i]){
                if(!graph.containsKey(j)){
                    graph.put(j, new ArrayList<>());
                }
                graph.get(j).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int bus = 0;
        int[] visited = new int[n];
        while(!queue.isEmpty()){
            bus++;
            for(int i=queue.size(); i>0; --i){
                int s = queue.poll();
                for(int b : graph.get(s)){
                    if(visited[b] == 1){
                        continue;
                    }
                    visited[b] = 1;
                    for(int t : routes[b]){
                        if(t == T){
                            return bus;
                        }
                        queue.offer(t);
                    }
                }
            }
        }
        return -1;
    }
}

public class BusRoutes{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(s.numBusesToDestination(routes, 1, 6));
        System.out.println(s.numBusesToDestination(routes, 1, 3));
        System.out.println(s.numBusesToDestination(routes, 1, 4));
	}
}
