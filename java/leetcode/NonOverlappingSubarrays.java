//Leetcode problem 689 Maximum Sum of # Non-Overlapping Subarrays
//Solution written by Xuqiang Fang on 28 Aug, 2018
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

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n-k+1];
        int s = 0;
        for(int i=0; i<k; ++i){
            s += nums[i];
        }
        for(int i=0; i<n-k; ++i){
            sum[i] = s;
            s -= nums[i]; 
            s += nums[i+k];
        }
        sum[n-k] = s;
        int[][] third = new int[n-k+1][2];
        int max = 0;
        int index = n-k;
        for(int i=n-k; i>=0; --i){
            if(sum[i] >= max){
                max = sum[i];
                index = i;
            }
            third[i][0] = max;
            third[i][1] = index;
        }
        /*
        for(int[] a : third){
            System.out.println(a[0] + "\t" + a[1]);
        }
        */
        int[][] second = new int[n-2*k+1][3];
        max = third[n-k][0];
        index = n-2*k;
        for(int i=n-2*k; i>=0; --i){
            if(sum[i] + third[i+k][0] >= max){
                max = sum[i] + third[i+k][0];
                index = i;
            }
            second[i][0] = max;
            second[i][1] = index;
            second[i][2] = third[index+k][1];
        }
        /*
        for(int[] a : second){
            System.out.println(a[0] + "\t" + a[1] + "\t" + a[2]);
        }
        */
        max = second[n-2*k][0];
        index = n-2*k;
        for(int i=n-3*k; i>=0; --i){
            if(sum[i]+second[i+k][0] >= max){
                max = sum[i] + second[i+k][0];
                index = i;
            }
        }
        int[] ans = {index, second[index+k][1], second[index+k][2]};
        return ans;
    }
}

public class NonOverlappingSubarrays{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,1,2,6,7,5,1};
        int[] ans = s.maxSumOfThreeSubarrays(nums, 2);
        for(int a : ans){
            System.out.println(a);
        }
	}
}
