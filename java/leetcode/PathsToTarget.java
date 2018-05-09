//Leetcode problem  797 All Paths From Source to Target
//Solution written by Xuqiang Fang on 8 May, 2018

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution{
    public List<List<Integer>> allPathsSource(int[][] graph){
        int N = graph.length;
        List<List<Integer>> list = new ArrayList<>(); 
        list.add(Arrays.asList(0));
    
        for(int i=0; i<N; ++i){
            List<List<Integer>> addition = new ArrayList<>();
            List<List<Integer>> subtract = new ArrayList<>();
            for(List<Integer> l : list){
                if(l.get(l.size()-1) == i){
                    for(int j : graph[i]){
                        List<Integer> temp = new ArrayList<>(l);
                        temp.add(j);
                        addition.add(temp);
                    } 
                    if(graph[i].length > 0)
                        subtract.add(l);
                }
            }
            list.removeAll(subtract);
            //System.out.println("list.size() after remove = " + list.size());
            list.addAll(addition);
            //System.out.println("list.size() after addition = " + list.size());
        }

        return list;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        int N = graph.length;
        List<List<Integer>> list = new ArrayList<>(); 
        dfs(list, new ArrayList<>(), graph, 0, N-1); 
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> temp, int[][] graph, int node, int dest){
        temp.add(node);
        if(node == dest){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int n : graph[node]){
            dfs(list, temp, graph, n, dest);
            temp.remove(temp.size()-1);
        }
    }
}

public class PathsToTarget{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] graph = {{1,2},{3,4},{3,4},{4},{}};
        List<List<Integer>> list = s.allPathsSourceTarget(graph);
        for(List<Integer> l : list)
            System.out.println(l);
	}
}
