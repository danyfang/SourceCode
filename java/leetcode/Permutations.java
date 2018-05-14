//Leetcode problem 46 Permutations
//Leetcode problem 47 Permutations II
//Solution written by Xuqiang Fang on 14 May, 2018

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs_unique(res, used, nums, new ArrayList<>());
        return res;
    }

    /*
    the important thing here to remember is that for the duplciate items, there should be an internal
    order between them, that way we can avoid duplicates in the final result
    */
    private void dfs_unique(List<List<Integer>> res, boolean[] used, int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        } 

        for(int i=0; i<nums.length; ++i){
            if(used[i])
                continue;
            if(i > 0 && nums[i-1] == nums[i] && !used[i-1])
                continue;
            
            used[i] = true;
            temp.add(nums[i]);
            dfs_unique(res, used, nums, temp);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        dfs(res, nums, new ArrayList<>(), used);
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] used){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; ++i){
            if(used[i])
                continue;
            used[i] = true;
            temp.add(nums[i]);
            dfs(res, nums, temp, used);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}

public class Permutations{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3,3,0,3};
        int[] nums2 = {1,2,3};
        //List<List<Integer>> list = s.permuteUnique(nums);
        List<List<Integer>> list = s.permute(nums2);
        for (List<Integer> l : list)
            System.out.println(l);
	}
}
