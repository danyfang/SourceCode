//Leetcode problem 18 4Sum
//Leetcode problem 454 4Sum II
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
