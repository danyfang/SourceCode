//Leetcode problem 719 Find K-th Smallest Pair Distance
//Solution written by Xuqiang Fang on 19 June, 2018
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
    /*
    * The same problem as search in a virtual matrix
    * This matrix has some key attributes:
    *   Each of its row and column is sorted!!
    * We don't need to create the virtual matrix
    */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);    
        int n = nums.length;
        int l = 0;
        int r = nums[n-1];
        while(l <= r){
            int m = (l + r) / 2;
            int total = 0, dis = 0;
            int j = n-1;
            for(int i=n-2; i>=0; --i){
                while(j > i && nums[j] - nums[i] > m){
                    --j;
                } 
                total += j - i;
                if(nums[j] - nums[i] > dis){
                    dis = nums[j] - nums[i];
                }
            }
            System.out.println("mid = " + m);
            System.out.println("total = " + total);
            if(total == k || l == r){
                return dis;
            }
            else if(total > k){
                r = m;
            }
            else{
                l = m+1;
            }
        }
        throw null;
    }
}

public class PairDistance{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,3,1};
        System.out.println(s.smallestDistancePair(nums, 1));
        //System.out.println(s.smallestDistancePair(nums, 2));
        //System.out.println(s.smallestDistancePair(nums, 3));
        int[] num = {9,10,7,10,6,1,5,4,9,8};
        System.out.println(s.smallestDistancePair(num, 18));
	}
}
