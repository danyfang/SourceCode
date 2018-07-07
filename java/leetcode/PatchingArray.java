//Leetcode problem  300 Patching Array
//Solution written by Xuqiang Fang on 6 July, 2018
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
    public int minPatches(int[] nums, int n) {
        int m = nums.length;
        long miss = 1;
        int i = 0, added = 0;
        while(miss <= n){
            if(i < m && nums[i] <= miss){
                miss += nums[i++];
            }
            else{
                miss += miss;
                added++;
            }
        }
        return added;
    }
}

public class PatchingArray{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,5,10};
        System.out.println(s.minPatches(nums, 20));
	}
}
