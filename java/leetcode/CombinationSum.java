//Leetcode problem 216 Combination Sum III
//Leetcode problem 377 Combination Sum IIII
//Solution written by Xuqiang Fang on 5 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution{
    //Solution provided by user@tinawma
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> list = new ArrayList<>();
        if(n < k || k * 9 < n)
            return list;
        combination(list, new ArrayList<>(), k, n, 1);
        return list;
    }	
    private void combination(List<List<Integer>> list, List<Integer> temp, int k, int n, int index){
        if(temp.size() == k && n == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index; i<=9 && k>0 && n>0; i++){
            temp.add(i);
            combination(list, temp, k, n-i, i+1);
            temp.remove(temp.size()-1);
        }
    }
    
    //this solution now can't pass because of exceeding time limit
    public int combinationSum4(int[] nums, int target){
        if(nums == null || nums.length == 0 || target <= 0)
            return 0;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), nums, 0, target);
        for(List<Integer> l : list){
            System.out.println(l);
        }
        return list.size();
    }
    private void dfs(List<List<Integer>> list, List<Integer> temp, int[] nums, int level, int gap){
        if(gap == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=level; i<nums.length; ++i){
            if(gap < nums[i])
                return;
            temp.add(nums[i]);
            dfs(list, temp, nums, i, gap-nums[i]);
            temp.remove(temp.size()-1);
        }
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int combinationSum5(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length ==0 || target < 0 ) return 0;
        if ( target ==0 ) return 1;
        if (map.containsKey(target)) return map.get(target);
        for (int num: nums){
            count += combinationSum5(nums, target-num);
        }
        map.put(target, count);
        return count;
    }
}

public class CombinationSum{
	public static void main(String[] args){
		Solution s = new Solution();
        //System.out.println(s.combinationSum3(3,7));
        int[] nums = {1,2,3};
        System.out.println(s.combinationSum4(nums, 4));
	}
}
