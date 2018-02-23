//Leetcode problem 18 4Sum
//Solution written by Xuqiang Fang on 22 Feb, 2018

/*
the solution set must not contain duplicate quadruplets.
*/
//current solution exceeds the time limit;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       	List<List<Integer>> result = new ArrayList<List<Integer>>(); 
		if(nums ==null || nums.length<4){
			return result;
		}
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				for(int k=j+1; k<nums.length; k++){
					for(int l=k+1; l<nums.length; l++){
						if(nums[i]+nums[j]+nums[k]+nums[l] == target){
							int[] temp = new int[]{nums[i],nums[j],nums[k],nums[l]};
							Arrays.sort(temp);
							List<Integer> list = new ArrayList<>();
							for(int x=0; x<temp.length; x++){
								list.add(temp[x]);
							}
							if(!result.contains(list)){
								result.add(list);
							}
						}
					}
				}
			}
		}	
		return result;
    }
	public List<List<Integer>> threeSum(int[] nums){
       	List<List<Integer>> result = new ArrayList<List<Integer>>(); 
		if(nums.length < 3){
			return result;
		}
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				for(int k=j+1; k<nums.length; k++){
					if(nums[i]+nums[j]+nums[k] == 0){
						int[] temp = new int[]{nums[i],nums[j],nums[k]};
						Arrays.sort(temp);
						List<Integer> list = new ArrayList<>();
						for(int x=0; x<3; x++){
							list.add(temp[x]);
						}
						if(!result.contains(list)){
							result.add(list);
						}
					}
				}
			}
		}
		return result;
	}
}
public class FourSum{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] test = new int[] {1,0,-1,0,-2,2};
		int[] test2 = new int[] {-1,0,1,2,-1,-4};
		System.out.println(s.fourSum(test,0));
		System.out.println(s.threeSum(test2));

	}
	public static void print(List<List<Integer>> a){
		for (int i=0; i<a.size(); i++){
			for(int j=0;j<a.get(i).size(); j++){
				System.out.println(a.get(i).get(j));
			}
		}	
	}
}
