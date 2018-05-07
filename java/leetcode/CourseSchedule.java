//Leetcode problem 207 Course Schedule
//Leetcode problem 210 Course Schedule II
//Solution written by Xuqiang Fang on 25 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
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




    //this solution is provided by user@jiayou.liu.961
    //it is dfs not recursion but iteration
    public boolean canF(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];
        
        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }
        
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
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
