//Leetcode problem 46&47 permutations
//solution written by Xuqiang Fang on 23 Feb, 2018
//solution is accepted
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import java.util.Arrays;

class Solution{
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();	
		int len = nums.length;
		int sum = (len-1)*len/2;
		if(len == 1){
			List<Integer> list = new ArrayList<>();
			list.add(nums[0]);
			result.add(list);
		}else{
			for(int i=0; i<len; i++){
				List<List<Integer>> temp = this.permute(this.subarr(nums,i));	
				int size = temp.size();
				for(int j=0; j<size; j++){
					temp.get(j).add(nums[i]);
					result.add(temp.get(j));
				}
			}
		}
		return result;
	}	
	public int[] subarr(int[] nums, int i){
		if(i>=nums.length){
			System.out.println("Error! Index must be smaller than the length of array");
			return null;
		}
		int[] arr = new int[nums.length-1];
		int foot1 = 0;
		int foot2 = 0;
		int len = arr.length;
		while(foot1<len){
			if(foot2 != i){
				arr[foot1] = nums[foot2];
				foot1++;
			}
			foot2++;
		}
		return arr;
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();	
		int len = nums.length;
		int sum = (len-1)*len/2;
		if(len == 1){
			List<Integer> list = new ArrayList<>();
			list.add(nums[0]);
			result.add(list);
		}else{
			for(int i=0; i<len; i++){
				List<List<Integer>> temp = this.permute(this.subarr(nums,i));	
				int size = temp.size();
				for(int j=0; j<size; j++){
					temp.get(j).add(nums[i]);
					if(! result.contains(temp.get(j))){
						result.add(temp.get(j));
					}
				}
			}
		}

		return result;
    }
}

public class DistinctPermu{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] test = {1,2,3};
		int[] test2 = {1,1,2,2,2};
		print(s.subarr(test,1));
		//print(test2);
		System.out.println(s.permute(test));
		System.out.println(s.permuteUnique(test2));
		return;
	}
	public static void print(int[] nums){
		int i=0;
		while(nums != null && i<nums.length){
			System.out.println(nums[i]);
			i++;
		}
	}
}
