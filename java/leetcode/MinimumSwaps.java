//Leetcode problem 801 Minimum Swaps To Make Sequences Increasing 
//Solution written by Xuqiang Fang on 2 June, 2018
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
    public int minSwap(int[] A, int[] B){
        int n = A.length;
        int[] keep = new int[n];
        int[] swap = new int[n];
        Arrays.fill(keep, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);
        keep[0] = 0;
        swap[0] = 1;
        for(int i=1; i<n; ++i){
            if(A[i] > A[i-1] && B[i] > B[i-1]){
                //in this case, both keep or both swap
                keep[i] = keep[i-1];
                swap[i] = swap[i-1] + 1;
            }
            if(A[i] > B[i-1] && B[i] > A[i-1]){
                //in this case, one swap and one keep
                swap[i] = Math.min(swap[i], keep[i-1]+1);
                keep[i] = Math.min(swap[i-1], keep[i]);
            }
        }
        return Math.min(swap[n-1], keep[n-1]);
    }
}

public class MinimumSwaps{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {1,3,5,4};
        int[] B = {1,2,3,7};
        System.out.println(s.minSwap(A, B));
	}
}
