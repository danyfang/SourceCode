//Leetcode problem 684 Redundant Connection 
//Leetcode problem 685 Redundant Connection II
//Solution written by Xuqiang Fang on 18 May, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution{
    //first solution, use dfs to find cycle
    public int[] findRedundantConnection(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>(); 
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            Set<Integer> visited = new HashSet<>();
            if(hasPath(u, v, graph, visited)){
                return edge;
            }
            if(!graph.containsKey(u)){
                List<Integer> neighbor = new ArrayList<>();
                graph.put(u, neighbor);
            }
            if(!graph.containsKey(v)){
                List<Integer> neighbor = new ArrayList<>();
                graph.put(v, neighbor);
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[]{};
    }
    private boolean hasPath(int u, int v, Map<Integer, List<Integer>> graph, Set<Integer> visited){
        if(u == v){
            return true;
        }
        visited.add(u);
        if(!graph.containsKey(u) || !graph.containsKey(v)){
            return false;
        }
        for(int neighbor : graph.get(u)){
            if(visited.contains(neighbor)){
                continue;
            }
            if(hasPath(neighbor, v, graph, visited)){
                return true;
            }
        }
        return false;
    }
    
    //use union find, path compression
    //中文名： 并查集
    public int[] findRedundantConnection_(int[][] edges){
        //each node will have a parent, firstly it is its parent itself
        int[] parents = new int[edges.length+1];
        //keep the size of each forest so we can always merge the small one to the big one
        int[] sizes = new int[edges.length+1];
        Arrays.fill(sizes, 1);
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(parents[u] == 0){
                parents[u] = u;
            }
            if(parents[v] == 0){
                parents[v] = v;
            }
            
            //find corresponding parents
            int pu = find(u, parents);
            int pv = find(v, parents);

            if(pu == pv){
                return edge;
            }

            if(sizes[pv] > sizes[pu]){
                int temp = pu;
                pu = pv;
                pv = temp;
            }
            parents[pv] = pu;
            sizes[pu] += sizes[pv];
        }
        return new int[]{};
    }
    private int find(int child, int[] parents){
        while(parents[child] != child){
            parents[child] = parents[parents[child]];
            child = parents[child];
        }
        return child;
    }
    public int[] findRedundantDirectedConnection(int[][] edges){
        int n = edges.length;
        int[] parents = new int[n+1];
        int[] roots = new int[n+1];
        int[] sizes = new int[n+1];
        Arrays.fill(sizes, 1);

        List<int[]> ans1 = new ArrayList<>();
        List<int[]> ans2 = new ArrayList<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            //a node has two parents
            if(parents[v] > 0){
                ans1.add(new int[]{parents[v], v});
                ans2.add(new int[]{edge[0], edge[1]});

                //delete the latter edge
                edge[0] = edge[1] = -1;
            }

            parents[v] = u;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            //invalid edges that are deleted
            if(u < 0 || v < 0){
                continue;
            }
            if(roots[u] == 0){
                roots[u] = u;
            }
            if(roots[v] == 0){
                roots[v] = v;
            }
            int pu = find(u, roots);
            int pv = find(v, roots);

            if(pu == pv){
                return ans1.isEmpty() ? edge : ans1.get(0);
            }

            if(sizes[pv] > sizes[pu]){
                int temp = pu;
                pu = pv;
                pv = temp;
            }

            roots[pv] = pu;
            sizes[pu] += sizes[pv];
        }
        return ans2.get(0);
    }
}

public class RedundantConnection{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[][] edges2 = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] remove = s.findRedundantConnection_(edges2);
        if(remove.length >= 2){
            System.out.println(remove[0] + "\t" + remove[1]);
        }
	}
}
