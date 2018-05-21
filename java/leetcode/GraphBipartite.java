//Leetcode problem 785 Is Graph Bipartitie
//Solution written by Xuqiang Fang on 21 May, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;

class Solution{
    public boolean isBipartite(int[][] graph) {
        Map<Integer,Integer> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<graph.length; ++i){
            if(!visited.containsKey(i)){
                visited.put(i, 0);
                queue.offer(i);
                while(!queue.isEmpty()){
                    //the size of each level
                    int size = queue.size();
                    while(size-- > 0){
                        int x = queue.poll();
                        int[] p = graph[x];
                        for(int j : p){
                            if(!visited.containsKey(j)){
                                //for this level, all nodes should belong to the other group
                                visited.put(j, 1-visited.get(x));
                                queue.offer(j);
                            }
                            //and if there is a contradiction, it is not bipartite
                            else if(visited.get(j) == visited.get(x)){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
}

public class GraphBipartite{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        int[][] graph2= {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph3 = {
        {},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}
        };
        System.out.println(s.isBipartite(graph));
        System.out.println(s.isBipartite(graph2));
        System.out.println(s.isBipartite(graph3));
	}
}
