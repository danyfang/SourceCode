//Leetcode problem 834 Sum of Distance in Tree
//Solution written by Xuqiang Fang on 18 May, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

class Solution{
    //TLE
    public int[] sumOfDistances(int N, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(); 
        for(int[] edge : edges){
            if(!graph.containsKey(edge[0])){
                Set<Integer> list = new HashSet<>();
                graph.put(edge[0], list);
            }
            graph.get(edge[0]).add(edge[1]);
            if(!graph.containsKey(edge[1])){
                Set<Integer> list = new HashSet<>();
                graph.put(edge[1], list);
            }
            graph.get(edge[1]).add(edge[0]);
        }
        int[] distance = new int[N];
        for(int i=0; i<N; ++i){
            distance[i] = dfs(graph, i, 1);
        }

        return distance;
    }
    private int dfs(Map<Integer, Set<Integer>> graph, int node, int level){
        if(!graph.containsKey(node) || graph.get(node).size() == 0 ){
            return 0;
        }
        int sum = 0;
        Set<Integer> children = graph.get(node);
        sum += level*children.size();
        for(int child : children){
            graph.get(child).remove(node);
            sum += dfs(graph, child, level+1); 
            graph.get(child).add(node);
        }
        return sum;
    }
   
    public int[] sumOfDistancesInTree(int N, int[][] edges){
        Set<Integer>[] graph = new HashSet[N];
        for(int[] edge : edges){
            if(graph[edge[0]] == null){
                graph[edge[0]] = new HashSet<>();
            }
            if(graph[edge[1]] == null){
                graph[edge[1]] = new HashSet<>();
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] distance = new int[N];
        int[] count = new int[N];
        dfs(graph, 0, new HashSet<>(), count, distance);
        dfs_(graph, 0, new HashSet<>(), count, distance);
        return distance;
    }
    
    /**
    Initial an array of hashset tree, tree[i] contains all connected nodes to i.
    Initial an array count, count[i] counts all nodes in the subtree i.
    Initial an array of res, res[i] counts sum of distance in subtree i.

    Post order dfs traversal, update count and res:
    count[root] = sum(count[i]) + 1
    res[root] = sum(res[i]) + sum(count[i])

    Pre order dfs traversal, update res:
    When we move our root from parent to its child i, count[i] points get 1 closer to root, 
    n - count[i] nodes get 1 futhur to root.
    count[i] = res[root] - count[i] + (n - count[i]);

    return res, done.
    */
    private void dfs(Set<Integer>[] graph, int root, HashSet<Integer> visited, int[] count, int[] distance){
        if(graph[root] == null){
            return;
        }
        visited.add(root);
        for(int i : graph[root]){
            if(!visited.contains(i)){
                dfs(graph, i, visited, count, distance); 
                count[root] += count[i];
                distance[root] += distance[i] + count[i];
            }
        }
        count[root]++;
    }

    private void dfs_(Set<Integer>[] graph, int root, HashSet<Integer> visited, int[] count, int[] distance){
        if(graph[root] == null){
            return;
        }
        visited.add(root);
        for(int i : graph[root]){
            if(!visited.contains(i)){
                distance[i] = distance[root] - count[i] + count.length - count[i];
                dfs_(graph, i, visited, count, distance);
            }
        }
    }
}

public class SumDistanceTree{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int[] distance = s.sumOfDistancesInTree(6,edges);
        for(int i : distance){
            System.out.println(i);
        }
	}
}
