//Leetcode problem 845 Longest Mountain in Array
//Solution written by Xuqiang Fang on 3 June, 2018
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
    public int longestMountain(int[] A) {
        int n = A.length;
        if(n < 3){
            return 0;
        }
        int m = 0;
        for(int i=1; i<n-1; ++i){
            if(A[i-1] < A[i] && A[i+1] < A[i]){
                m = Math.max(m, 1+left(A, i-1)+right(A, i+1)); 
            }
        }
        return m;
    }
    private int left(int[] A, int index){
        int c = 1;
        for(int i=index-1; i>=0; --i){
            if(A[i] < A[i+1]){
                c++;
            }
            else{
                break;
            }
        }
        return c;
    }
    private int right(int[] A, int index){
        int c = 1;
        for(int i=index+1; i<A.length; ++i){
            if(A[i-1] > A[i]){
                c++;
            }
            else{
                break;
            }
        }
        return c;
    }
}

public class LongestMountain{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {2,1,4,7,3,2,5};
        int[] B = {2,2,2};
        System.out.println(s.longestMountain(A));
        System.out.println(s.longestMountain(B));
	}
}
