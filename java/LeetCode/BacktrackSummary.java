//Leetcode summary
/*
A general approach to backtracking questions in java(Subsets, Permutations,
Combinations Sum, Parlindrome partition)
Solution provided by user@issac3
Notes taken by Xuqiang Fang on 23, Feb 2018
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Integer;

class Subset{
	public List<List<Integer>> subset (int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}
	private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int start){
		list.add(new ArrayList<>(templist));
		for(int i=start; i<nums.length; i++){
			templist.add(nums[i]);
			backtrack(list, templist, nums, i+1);
			templist.remove(templist.size()-1);
		}
	}
}

class SubsetDuplicate{
	public List<List<Integer>> subset (int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}
	private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int start){
		list.add(new ArrayList<>(templist));
		for(int i=start; i<nums.length; i++){
			if(i>start && nums[i] == nums[i-1]) continue;
			templist.add(nums[i]);
			backtrack(list,templist, nums,i+1);
			templist.remove(templist.size()-1);
		}
	}
}

class Permute{
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}
	private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums){
		if(templist.size() == nums.length){
			list.add(new ArrayList<>(templist));
		}else{
			for(int i=0; i<nums.length; i++){
				if(templist.contains(nums[i])){
					continue;
				}
				templist.add(nums[i]);
				backtrack(list,templist,nums);
			/*
			About following remove line:
			to generate all possible permutations, we need to remove list recently added element while we
			are going up with the recursive call stack. In the first iteration of the for loop we add all
			permutations starting form nums[0], then before we can start building all permutations 
			starting with nums[1], we need to clear the templist(which currently contains the permutations
			of the first iteration of the for loop).
			*/
				templist.remove(templist.size()-1);
			}
		}
	}
}

class PermuteDuplicate{
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}
	private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, boolean[] used){
		if(templist.size() == nums.length){
			list.add(new ArrayList<>(templist));
		}else{
			for(int i=0; i<nums.length; i++){
				if(used[i] || i>0 &&nums[i] == nums[i-1] && !used[i-1]){
					continue;
				}
				used[i] = true;
				templist.add(nums[i]);
				backtrack(list,templist,nums, used);
				used[i] = false;
				templist.remove(templist.size()-1);
			}
		}
	}
}

class CombSum{//can reuse the same element
	public List<List<Integer>> combinationSum(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int remain, int start){
		if(remain < 0){
			return;
		}else if(remain == 0){
			list.add(new ArrayList<>(templist));
		}else{
			for(int i=start; i<nums.length; i++){
				templist.add(nums[i]);
				backtrack(list,templist, nums, remain-nums[i], i);
				templist.remove(templist.size()-1);
			}
		}
	}
}

class CombSumOnce{//cannot reuse the same element
	public List<List<Integer>> combinationSum(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	} 
	private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int remain, int start){
		if(remain<0){
			return;
		}else if(remain == 0){
			list.add(new ArrayList<>(templist));
		}else{
			for(int i=start; i<nums.length; i++){
				if(i>start && nums[i]==nums[i-1]){
					continue;
				}
				templist.add(nums[i]);
				backtrack(list, templist, nums, remain-nums[i],i+1);
				templist.remove(templist.size()-1);
			}
		}
	}
}

class ParlinPart{//accepted solution.
	public String parlindrome(String s){
		//todo
		if(s.length() <= 1){
			return s;
		}
		int[] nums = new int[s.length()];
		for(int i=1; i<s.length(); i++){
			if(nums[i-1] == 0){
				if(s.charAt(i) == s.charAt(i-1)){
					nums[i] = 1;
				}else if(i-2>=0 && s.charAt(i) == s.charAt(i-2)){
					nums[i] = 2;
				}
			}else if(nums[i-1]>0){
				int low = 0 > i-nums[i-1]-2 ? 0 : i-nums[i-1]-2;
				while(low < i){
					if(isPalindrome(s.substring(low,i+1))){
						nums[i] = i-low;
						break;
					}
					low++;
				}
			}
		}
		
		int index = 0;
		int foot = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i]>index){
				index = nums[i];
				foot = i;
			}
			System.out.print(nums[i]);
		}
		String max = s.substring(foot-index,foot+1);
		return max;
	}
	public boolean isPalindrome(String s){
		int low = 0;
		int high = s.length()-1;
  		while(low < high){
     		if(s.charAt(low++) != s.charAt(high--)){
				return false;
			}
		}
   		return true;
	}
	
}

class ThreeSum{
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0,0);
		return list;
	}
	private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int remain, int start){
		//todo;
		if(remain == 0 && templist.size() == 3 && !list.contains(templist)){
			list.add(new ArrayList<>(templist));
		}
		for(int i=start; i<nums.length; i++){
			if(templist.size()>2){
				break;
			}
			templist.add(nums[i]);
			backtrack(list,templist,nums,remain-nums[i],i+1);
			templist.remove(templist.size()-1);
		}
	}
}

class FourSum{
	public List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target,0);
		return list;
	}
	private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int remain, int start){
		//todo;
		if(remain == 0 && templist.size() == 4 && !list.contains(templist)){
			list.add(new ArrayList<>(templist));
		}
		for(int i=start; i<nums.length; i++){
			if(templist.size()>3){
				break;
			}
			templist.add(nums[i]);
			backtrack(list,templist,nums,remain-nums[i],i+1);
			templist.remove(templist.size()-1);
		}
	}
}

public class BacktrackSummary{
	public static void main(String[] args){
		/*
		int[] nums = new int[]{1,2,3};
		Subset sub = new Subset();
		System.out.println(sub.subset(nums));
		int[] nums2 = new int[]{1,2,3,3};
		SubsetDuplicate subduplicate = new SubsetDuplicate();
		System.out.println(subduplicate.subset(nums2));
		Permute per = new Permute();
		System.out.println(per.permute(nums));
		PermuteDuplicate perd = new PermuteDuplicate();
		System.out.println(perd.permute(nums2));
		int[] test = {1,1,2,2,2};

		int[] sum = {2,2,3,4,6,7};
		CombSum s = new CombSum();
		System.out.println(s.combinationSum(sum, 7));
		CombSumOnce son = new CombSumOnce();
		System.out.println(son.combinationSum(sum,7));
		int[] sum2 = {};
		ThreeSum three = new ThreeSum();
		System.out.println(three.threeSum(sum2));
		int[] sum4 = {};
		FourSum four = new FourSum();
		System.out.println(four.fourSum(sum4,0));
		*/
		String a = "babad";//bab
		String b = "cbbd";//bb
		ParlinPart p = new ParlinPart();
		System.out.println(a);
		System.out.println(p.parlindrome(a));
		System.out.println(b);
		System.out.println(p.parlindrome(b));
	}
}
