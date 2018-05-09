//Leetcode problem 18 4Sum
//Leetcode problem 454 4Sum II
//Solution written by Xuqiang Fang on 22 Feb, 2018

/*
the solution set must not contain duplicate quadruplets.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       	List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; ++i){
            list.addAll(threeSum(nums, target-nums[i], i+1, nums.length-1, target));
            while(i < nums.length -4 && nums[i+1] == nums[i]){
                i++;
            }
        }
		return list;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int low, int high, int original){
        if(target == -6)
            System.out.println("low = " + low + "   " + high );
        List<List<Integer>> list = new ArrayList<>();
        if(high - low < 2)
            return list;

        int i = low;
        while(i < high - 1){
            int j = i + 1;
            int k = high;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target)
                    list.add(Arrays.asList(original-target, nums[i], nums[j], nums[k]));
                if(sum <= target)
                    while(nums[j] == nums[++j] && j < k);
                if(sum >= target)
                    while(nums[k--] == nums[k] && j < k);
            }

            while(nums[i] == nums[++i] && i < high-1);
        }

        return list;
    }


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.length; ++i){
            for(int j=0; j<B.length; ++j){
                int key = A[i] + B[j]; 
                int count = map.getOrDefault(-key, 0);
                map.put(-key, count+1);
            }
        }
        
        int sum = 0;
        for(int i=0; i<C.length; ++i){
            for(int j=0; j<D.length; ++j){
                int key = C[i] + D[j];
                if(map.containsKey(key)){
                    sum += map.get(key);
                }
            }
        }

        return sum;
    }
}
public class FourSum{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] test = new int[] {1,-2,-5,-4,-3,3,3,5};
        //{-5,-4,-3,-2,1,3,3,5}
		print(s.fourSum(test,-11));

        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        System.out.println(s.fourSumCount(A,B,C,D));
	}
	public static void print(List<List<Integer>> a){
        for(List<Integer> list : a){
            System.out.println(list);
        }
	}
}
