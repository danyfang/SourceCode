//Leetcode problem 363 Max Sum of Rectangle No Larger Than K
//Solution written by Xuqiang Fang on 12 July, 2018
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
import java.util.Collections;
class Solution{
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = Math.min(matrix.length, matrix[0].length);   
        int n = Math.max(matrix.length, matrix[0].length);
        int ans = Integer.MIN_VALUE; 
        for(int i=0; i<m; ++i){
            int[] sum = new int[n];
            for(int j=i; j<m; ++j){
                for(int l=0; l<n; ++l){
                    if(m == l){
                        sum[l] += matrix[j][l];
                    }
                    else{
                        sum[l] += matrix[l][j];
                    }
                } 
                List<Integer> list = new ArrayList<>();
                int curr = 0;
                list.add(0);
                for(int x=0; x<n; ++x){
                    curr += sum[x];
                    int index = Collections.binarySearch(list, curr-k);
                    if(index < 0){
                        index = -1 - index; 
                    }
                    if(index != list.size()){
                        ans = Math.max(ans, curr-list.get(index));
                    }
                    list.add(index, curr);
                }
            }
        }
        return ans;
    }
}

public class MaxSumRectangle{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] matrix = {{1,0,1},{0,-2,3}};
        System.out.println(s.maxSumSubmatrix(matrix, 2));
	}
}
