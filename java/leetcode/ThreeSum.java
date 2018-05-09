//Leetcode problem 15 3 Sum
//Solution written by Xuqiang Fang on  6 May, 2018

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution{
    //this one exceedes time limit
    public List<List<Integer>> three(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 3) 
            return list;
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int index){
        if(temp.size() == 3 && !list.contains(temp)){
            if(temp.get(0)+temp.get(1)+temp.get(2) == 0)
                list.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<nums.length; ++i){
            temp.add(nums[i]);
            backtrack(list, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return list;
        }

        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2){
            if(nums[i] > 0)
                break;
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0)
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0)
                    while( nums[j] == nums[++j] && j < k );
                if(sum >= 0)
                    while( nums[k--] == nums[k] && j < k );
            }

            while( nums[i] == nums[++i] && i < nums.length-2 );
        }
        return list;
    }

}

public class ThreeSum{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = s.threeSum(nums);
        for(List<Integer> l : list){
            System.out.println(l);
        }
	}
}
