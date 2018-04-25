//Leetcode problem 448 Find All Numbers Disappeared in an Array
//Solution written by Xuqiang Fang on 25 April, 2018 
import java.util.ArrayList;
import java.util.List;
class Solution{
    public List<Integer> findDisappeared(int[] nums){
        List<Integer> list = new ArrayList<>(nums.length); 
        int[] arr = new int[nums.length];
        for(int i : nums){
            arr[i-1] = i;
        }
        for(int i=0; i<arr.length; ++i){
            if(arr[i] == 0)
                list.add(i+1);
        }
        return list;
    }	
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; ++i){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = - nums[index];
            }
        }
        for(int i = 0; i<nums.length; ++i){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }
}

public class DisappearedNumbers{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(s.findDisappearedNumbers(nums));
	}
}
