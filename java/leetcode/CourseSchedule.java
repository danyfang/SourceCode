//Leetcode problem 207 Course Schedule
//Solution written by Xuqiang Fang on 25 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Solution{
    public boolean canFinish(int num, int[][] pre){
        List<Integer>[] courses = new ArrayList[num];  
        for(int i=0; i<num; ++i){
            courses[i] = new ArrayList<>();
        }
        for(int[] p : pre){
            courses[p[0]].add(p[1]);
        }
        
        //mark node state, 0 means unvisited, 1 means visiting, 2 means visited
        int[] state = new int[num];
        for(int i=0; i<num; ++i){
            if(dfs(courses, state, i))
                return false;
        }
        return true;
    }

    private boolean dfs(List<Integer>[] courses, int[] state, int node){
        if(state[node] == 1)// if there is a cycle, returns true
            return true;
        else if(state[node] == 2)
            return false;//if the node is visited, return false

        state[node] = 1;
        for(int p : courses[node]){
            if(dfs(courses, state, p))
                return true;
        }

        state[node] = 2;
        return false;
    }

    public int[] findOrder(int num, int[][] pre){
        List<Integer>[] courses = new ArrayList[num];  
        for(int i=0; i<num; ++i){
            courses[i] = new ArrayList<>();
        }
        for(int[] p : pre){
            courses[p[0]].add(p[1]);
        }
        
        //mark node state, 0 means unvisited, 1 means visiting, 2 means visited
        int[] state = new int[num];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<num; ++i){
            if(order(courses, state, i, stack))
                return new int[0];
        }
        int[] ans = new int[num];
        System.out.println(stack.size());
        for(int i=num-1; i>=0; --i){
            ans[i] = stack.pop();
        }

        return ans;
    }

    private boolean order(List<Integer>[] courses, int[] state, int node, Stack<Integer> stack){
        if(state[node] == 1)
            return true;
        if(state[node] == 2)
            return false;

        state[node] = 1;
        for(int p : courses[node]){
            if(order(courses, state, p, stack))
                return true;
        }
        state[node] = 2;
        stack.push(node);
        return false;
    }
}

public class CourseSchedule{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] prev = {{1,0},{0,2}};
        System.out.println(s.canFinish(3, prev));
        int[] ans = s.findOrder(3, prev);
        for(int i : ans){
            System.out.println(i);
        }
	}
}
