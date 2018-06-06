//Leetcode problem 315 Count of Smaller Numbers After Self
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
    //naive version
    public List<Integer> countSmaller_naive(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; ++i){
            int c = 0;
            for(int j=1+i; j<n; ++j){
                if(nums[j] < nums[i]){
                    c++;
                }
            }
            ans.add(c);
        }
        return ans;
    }

    //another method is to use merge sort, notice that the number of smaller elements
    //is exactly the number of elments which jump from the right side of a number to its left side
    //do the merge sort while keep the count, when the next number comes from the right,
    //we need to keep a count #, because when the next element to be
    //inserted comes from the left, # of elements are smaller than it(the number to to inserted)
    public List<Integer> countSmaller(int[] nums){
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[n];
        int[] index = new int[n];
        for(int i=0; i<n; ++i){
            index[i] = i;
        }
        mergesort(nums, count, index, 0, n-1);
        for(int i=0; i<n; ++i){
            ans.add(count[i]);
        }
        return ans;
    }
    private void mergesort(int[] nums, int[] count, int[] index, int start, int end){
        if(end <= start){
            return;
        } 
        int m = start + (end - start) / 2;
        mergesort(nums, count, index, start, m);
        mergesort(nums, count, index, m+1, end);
        merge(nums, count, index, start, end);
    }
    private void merge(int[] nums, int[] count, int[] index, int start, int end){
        int m = start + (end - start) / 2;
        int left = start;
        int right = m + 1;
        int smaller = 0;
        int[] update = new int[end-start+1];

        int i = 0;
        while(left <= m && right <= end){
            if(nums[index[right]] < nums[index[left]]){
                update[i++] = index[right++];
                smaller++;
            }
            else{
                update[i++] = index[left];
                //we have counted there were 'smaller' number of elements that are smaller than this one
                count[index[left++]] += smaller;
            }
        }

        while(left <= m){
            update[i++] = index[left];
            count[index[left++]] += smaller;
        }
        while(right <= end){
            update[i++] = index[right++];
        }
        System.arraycopy(update,0,index,start, end-start+1);
    }
}

public class CountSmaller{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {5, 2, 6, 1};
        System.out.println(s.countSmaller(nums));
	}
}
