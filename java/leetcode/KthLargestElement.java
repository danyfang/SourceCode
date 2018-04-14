//Leetcode problem 215 Kth Largest Element in an Array
//Solution written by Xuqiang Fang on 13 April, 2018 
//You may always assume k is valid, 1 <= k <= array.length
import java.util.Arrays;
import java.util.PriorityQueue;
class Solution{
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            que.offer(nums[i]); 
        }
        for(int i=k; i<nums.length; i++){
            if(nums[i] <= que.peek())
                continue;
            else{
                que.poll();
                que.offer(nums[i]);
            }
        }
        return que.peek();
    }	
}

public class KthLargestElement{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(s.findKthLargest(nums, 2));
	}
}
