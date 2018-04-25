//Leetcode problem 442 Find All Duplicates in an Array
//Solution written by Xuqiang Fang on 15 April, 2018 
import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<Integer> findDuplicates(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; ++i){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                list.add(index+1);
            }
            nums[index] = - nums[index];
        } 
        for(int i : nums)
            System.out.println(i);

        return list;
    }	
}

public class FindDuplicatesArray{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3,4,7,2,8,2,3,1};
        System.out.println(s.findDuplicates(nums));
	}
}
