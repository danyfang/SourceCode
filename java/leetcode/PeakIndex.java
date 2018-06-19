//Leetcode problem 852 Peak Index in a Mountain Array
//Solution written by Xuqiang Fang on 18 June, 2018
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
    public int peakIndexInMountainArray(int[] A) {
        int ans = 0;
        int n = A.length;
        for(int i=1; i<n-1; ++i){
            if(A[i] > A[i-1] && A[i] > A[i+1]){
                ans = i;
                break;
            }
        }
        return ans;
    }

    public int peakIndexInMountainArray_binary(int[] A){
        int ans = 1;
        int n = A.length;
        int l = 0;
        int r = n-2;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(A[m] < A[m+1]){
                l = m + 1;
            }
            else if(A[m] < A[m-1]){
                r = m;
            }
            else{
                ans = m;
                break;
            }
        }
        return ans;
    }
}

public class PeakIndex{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {2,3,1,0};
        System.out.println(s.peakIndexInMountainArray(A));
        System.out.println(s.peakIndexInMountainArray_binary(A));
	}
}
