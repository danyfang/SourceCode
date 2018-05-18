//Leetcode problem 802 Find Eventual Safe States
//Solution written by Xuqiang Fang on 18 May, 2018
import java.util.ArrayList;
import java.util.List;
class Solution{
    public List<Integer> eventualSafeNodes(int[][] graph) {
        State[] states = new State[graph.length];
        for(int i=0; i<states.length; ++i){
            states[i] = State.UNKNOWN;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<graph.length; ++i){
            if(dfs(graph, i, states) == State.SAFE){
                ans.add(i);
            }
        }
        ans.sort((a,b)->(a-b));
        return ans;
    }

    private State dfs(int[][] graph, int node, State[] states){
        if(states[node] == State.VISITING){
            return State.UNSAFE;
        }
        if(states[node] != State.UNKNOWN){
            return states[node];
        }
        states[node] = State.VISITING;
        for(int next : graph[node]){
            if(dfs(graph, next, states) == State.UNSAFE){
                return states[node] = State.UNSAFE;
            }
        }
        return states[node] = State.SAFE;
    }
    private enum State {UNKNOWN, VISITING, SAFE, UNSAFE};
}

public class SafeStates{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(s.eventualSafeNodes(graph));
	}
}
