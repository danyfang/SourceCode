//Leetcode problem 749 Contain Virus
//Solution written by Xuqiang Fang on 3 Sep, 2018
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
    int[][] copy;
    public int containVirus(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        copy = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                copy[i][j] = grid[i][j];
            }
        }
    }
}

public class ContainVirus{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
