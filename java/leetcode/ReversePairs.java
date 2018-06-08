//Leetcode problem 493 Reverse Pairs
//Solution written by Xuqiang Fang on 6 June, 2018
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
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n);
    }
    private int mergeSort(int[] nums, int left, int right){
        if(right - left <= 1){
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid, right);
        int[] cache = new int[right-left];
        int i = left, j = mid, k = 0;
        //use binary search to boost search
        for(int x=mid; x<right; ++x){
            if(((long)nums[x])*2 < (long)nums[mid-1]){
                count += binarySearch(nums, left, mid, nums[x]);
            }
        }
        //the following is a standard merge sort routine
        while(i < mid && j < right){
            if(nums[j] < nums[i] ){
                cache[k++] = nums[j++];
            }
            else{
                cache[k++] = nums[i++];
            }
        }
        while(i < mid){
            cache[k++] = nums[i++];
        }
        while(j < right){
            cache[k++] = nums[j++];
        }
        for(int x=0; x<right-left; ++x){
            nums[left+x] = cache[x];
        }
        return count;
    }
    private int binarySearch(int[] nums, int left, int right, int t){
        //search for the number of elements that meet the requirements
        //left <= i < right
        int l = left;
        int r = right;
        while(l < r){
            int m = l + (r - l) / 2;
            if((long)nums[m] > (long)t * 2){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return right - l;
    }
}

public class ReversePairs{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,3,2,3,1};
        int[] num = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};//overflow, should be 0
        System.out.println(s.reversePairs(nums));
        System.out.println(s.reversePairs(num));
	}
}
