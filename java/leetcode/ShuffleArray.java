//Leetcode problem 384 Shuffle an Array
//Solution written by Xuqiang Fang on 17 May, 2018
import java.util.Random;
class Solution {
    public Solution(int[] nums) {
        copy = new int[nums.length];
        for(int i=0; i<copy.length; ++i){
            copy[i] = nums[i];
        }
        this.nums = nums;
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return copy; 
    }
    
    /** Returns a random shuffling of the array. */
    /** Use Fisher-Yates shuffle, modern version */
    /**
    -- To shuffle an array a of n elements (indices 0..n-1):
    for i from n−1 downto 1 do
        j ← random integer such that 0 ≤ j ≤ i
        exchange a[j] and a[i]
    */
    public int[] shuffle() {
        if(nums == null || nums.length == 0)
            return nums;
        for(int i=nums.length-1; i>=1; --i){
            int j = r.nextInt(i+1);
            swap(nums, i, j);
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int[] copy;
    private int[] nums;
    Random r;
}

public class ShuffleArray{
	public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
		Solution s = new Solution(nums);
	}
}
