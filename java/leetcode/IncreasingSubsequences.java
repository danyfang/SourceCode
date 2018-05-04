//Leetcode problem 491 Increasing Subsequences
//Solution written by Xuqiang Fang on 4 may, 2018
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
class Solution{
    public List<List<Integer>> findSubsequences(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length <= 1)
            return list;
        Set<List<Integer>> set = new HashSet<>();
        backtrack(set, new ArrayList<>(), 0, nums);
        list = new ArrayList<>(set);
        return list;
    }

    private void backtrack(Set<List<Integer>> set, List<Integer> tmp, int index, int[] nums){
        if(tmp.size() >= 2){
            set.add(new ArrayList<>(tmp));
        }
        for(int i=index; i<nums.length; ++i){
            if(tmp.size() == 0 || tmp.get(tmp.size()-1) <= nums[i]){
                tmp.add(nums[i]);
                backtrack(set, tmp, i+1, nums);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    //this one exceeds time limit
    private List<List<Integer>> find(int[] nums, int i){
        List<List<Integer>> list = new ArrayList<>();
        if(i >= nums.length){
            return list;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[i]);
        for(int j=i+1; j<nums.length; ++j){
            if(nums[i] <= nums[j]){
                temp.add(nums[j]);
                if(!list.contains(temp))
                    list.add(new ArrayList<>(temp));
                temp = temp.subList(0,1);
            }
        }
        List<List<Integer>> ret = find(nums, i+1);
        for(List<Integer> sub : ret){
            if(nums[i] <= sub.get(0)){
                temp.addAll(sub);
                if(!list.contains(temp))
                    list.add(new ArrayList<>(temp));
                temp = temp.subList(0,1);
            }
        } 
        list.addAll(ret);

        return list;
    }
    //this one exceeds time limit
    private Set<List<Integer>> findSet(int[] nums, int i){
        Set<List<Integer>> set = new HashSet<>();
        if(i >= nums.length)
            return set;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[i]);
        for(int j=i+1; j<nums.length; ++j){
            if(nums[i] <= nums[j]){
                temp.add(nums[j]);
                set.add(new ArrayList<>(temp));
                temp = temp.subList(0,1);
            }
        }
        Set<List<Integer>> ret = findSet(nums, i+1);
        //this step takes a lot of time, it is (1+...+n^2) 
        for(List<Integer> sub : ret){
            if(nums[i] <= sub.get(0)){
                temp.addAll(sub);
                set.add(new ArrayList<>(temp));
                temp = temp.subList(0,1);
            }
        } 
        set.addAll(ret);
        return set;
    }
}

public class IncreasingSubsequences{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {4,6,7,7};
        List<List<Integer>> ret = s.findSubsequences(nums);
        for(List<Integer> l : ret){
            System.out.println(l);
        }
	}
}
