//Leetcode problem 787 Cheapest Flights Within K Stops
//Solution written by Xuqiang Fang on 21 May, 2018
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
class Solution{
    private final int MAX_PRICE = 10000 * 10001;
    //method one, Bellman, single source, all destinations
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n];
        Arrays.fill(cost, MAX_PRICE);
        cost[src] = 0;
        for(int i=0; i<=K; ++i){
            int[] temp = cost.clone();
            for(int[] flight : flights){
                temp[flight[1]] = Math.min(temp[flight[1]], cost[flight[0]]+flight[2]);
            }
            cost = temp.clone();
            /*
            for(int j=0; j<n; ++j){
                if(cost[j] != temp[j]){
                    int t = temp[j];
                    temp[j] = cost[j];
                    cost[j] = t;
                }
            }
            */
        }

        return cost[dst] >= MAX_PRICE ? -1 : cost[dst];
    }


    //method 2, dfs
    public int findCheapestPrice_dfs(int n, int[][] flights, int src, int dst, int K){
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] f : flights){
            if(!map.containsKey(f[0])){
                map.put(f[0], new ArrayList<>());
            }
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        int[] visited = new int[n];
        visited[src] = 1;
        dfs(src, dst, K+1, 0, visited, map);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int ans = Integer.MAX_VALUE;
    private void dfs(int src, int dst, int k, int cost, int[] visited, Map<Integer,List<int[]>> map){
        if(src == dst){
            ans = cost;
            return;
        }    
        if(k == 0){
            return;
        }
        if(map.containsKey(src)){
            for(int[] f : map.get(src)){
                if(visited[f[0]] == 1){
                    continue;
                }
                //pruning, 剪枝，当价格大于当前最优价格的时候就返回
                if(cost + f[1] > ans){
                    continue;
                }
                visited[f[0]] = 1;
                dfs(f[0], dst, k-1, cost+f[1], visited, map);
                visited[f[0]] = 0;
            }
        }
    }


    //method 3 bfs
    public int findCheapestPrice_bfs(int n, int[][] flights, int src, int dst, int K){
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] f : flights){
            if(!map.containsKey(f[0])){
                map.put(f[0], new ArrayList<>());
            }
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        int res = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            //bfs every level 
            while(size-- > 0){
                int[] f = queue.poll();
                if(f[0] == dst){
                    res = Math.min(res, f[1]);
                }
                if(map.containsKey(f[0])){
                    for(int[] p : map.get(f[0])){
                        //pruning, 剪枝，当价格大于当前最优价格的时候就跳过
                        if(p[1] + f[1] > res){
                            continue;
                        }
                        queue.offer(new int[]{p[0], f[1]+p[1]});
                    }
                }
            }
            if(steps++ > K){
                break;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

public class FlightsWithinStops{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500},{2,3,600}};
        System.out.println(s.findCheapestPrice(4, flights, 0, 3, 1));
        System.out.println(s.findCheapestPrice_dfs(4, flights, 0, 3, 1));
        System.out.println(s.findCheapestPrice_bfs(4, flights, 0, 3, 1));
	}
}
