//Leetcode problem 51 N-Queens
//Leetcode problem 52 N-Queens II
//Solution written by Xuqiang Fang on 5 June, 2018
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
    //DFS is good but it takes too long for both questions
    //so whenever use dfs, think about how to prune
    //for No 52 
    private int count;
    public int totalNQueens(int n) {
        if(n == 1){
            return 1;
        }
        else if(n < 4){
            return 0;
        }
        count = 0;
        dfs2(new ArrayList<>(), n);
        return count; 
    }
    private void dfs2(List<Integer> l, int n){
        if(l.size() == n && check(l, n)){
            count++;
            return;
        }
        for(int i=0; i<n; ++i){
            if(!l.contains(i) && check(l, n)){// an pruning operation is added, do a pre-check
                l.add(i);
                dfs2(l, n);
                l.remove(l.size()-1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if(n == 1){
            List<String> temp = new ArrayList<>();
            temp.add("Q");
            ans.add(temp);
            return ans;
        }
        else if(n < 4){
            return ans;
        }
        List<List<Integer>> solution = new ArrayList<>();
        dfs(solution, new ArrayList<>(), n);
        //System.out.println("there are " + solution.size() + " solutions");
        for(List<Integer> l : solution){
            output(ans, l, n);
        }
        return ans;
    }
    private void dfs(List<List<Integer>> s, List<Integer> l, int n){
        if(l.size() == n && check(l, n)){
            s.add(new ArrayList<>(l)); 
            return;
        } 
        for(int i=0; i<n; ++i){
            if(!l.contains(i) && check(l, n)){
                l.add(i);
                dfs(s, l, n);
                l.remove(l.size()-1);
            }
        }
    }
    private boolean check(List<Integer> l, int n){
        boolean[] diag = new boolean[2*n-1];
        boolean[] counter_diag = new boolean[2*n-1];
        for(int i=0; i<l.size(); ++i){
            if(diag[i+l.get(i)]){
                return false;
             }
            else{
                diag[i+l.get(i)] = true;
            }
            if(counter_diag[i+n-1-l.get(i)]){
                return false;
            }
            else{
                counter_diag[i+n-1-l.get(i)] = true;
            }
        }
        return true;
    }
    private void output(List<List<String>> out, List<Integer> l, int n){
        List<String> one = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                sb.append('.');
            }
            sb.setCharAt(l.get(i), 'Q');
            one.add(sb.toString());
            sb.delete(0,n);
        }
        out.add(one);
    }
}

public class NQueens{
	public static void main(String[] args){
		Solution s = new Solution();
        List<List<String>> ans = s.solveNQueens(Integer.parseInt(args[0]));
        for(List<String> l : ans){
            System.out.println(l);
        }
        System.out.println(s.totalNQueens(Integer.parseInt(args[0])));
	}
}
