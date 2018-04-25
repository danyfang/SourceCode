//Leetcode problem 310 Minimum Height Trees
//Solution written by Xuqiang Fang on 25 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
class Solution{
    //this solution exceeded time limit
    public List<Integer> findMinHeightTrees_(int n, int[][] edges){
        List<Integer> list = new ArrayList<>();
        if(n == 0)
            return list;

        if(n == 1){
            list.add(0);
            return list;
        }
        if(edges == null || edges.length == 0 || edges[0].length == 0){
            for(int i=0; i<n; ++i)
                list.add(i);
            return list;
        }

        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] num : edges){
            if(map.containsKey(num[0])){
                map.get(num[0]).add(num[1]);
            }
            else{
                Set<Integer> temp = new HashSet<>();
                temp.add(num[1]);
                map.put(num[0], temp);
            }

            if(map.containsKey(num[1])){
                map.get(num[1]).add(num[0]);
            }
            else{
                Set<Integer> temp = new HashSet<>();
                temp.add(num[0]);
                map.put(num[1], temp);
            }
        }
        if(map.size() < n){//this means there is a single node, then the distance is infinitive
            return list;
        } 
        Map<Integer, Integer> height = new HashMap<>();
        int max = 0;
        for(int i : map.keySet()){
            Set<Integer> set = new HashSet<>();
            int h = height(i, map, set);
            System.out.println("i = " + i + " h = " + h);
            max = Math.max(max, h);
            height.put(i, h);
        }
        for(int h : height.keySet()){
            if(height.get(h) == (max+1) / 2){
                list.add(h);
            }
        }

        return list;
    }	

    public int height(int n, Map<Integer,Set<Integer>> map, Set<Integer> set){
        int h = 0;
        if(set.contains(n))
            return h;
        set.add(n);
        for(int i : map.get(n)){
            if(!set.contains(i)){
                h = Math.max(h, 1 + height(i, map, set));
            }
        } 
        return h;
    }


    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        if(n == 1)
            return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for(int i=0; i<n; ++i){
            adj.add(new HashSet<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; ++i){
            if(adj.get(i).size() == 1){
                leaves.add(i);
            }
        }
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves){
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size() == 1){
                    newLeaves.add(j);
                }
                leaves = newLeaves;
            }
        }
        return leaves;
    }
}

public class MinimumHeight{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        int[][] edges2 = {{1,0},{1,2}};
        int[][] edges3 = {{1,0}};
        System.out.println(s.findMinHeightTrees(6, edges));
        System.out.println(s.findMinHeightTrees(3, edges2));
        System.out.println(s.findMinHeightTrees(2, edges3));
	}
}
