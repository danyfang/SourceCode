//Leetcode problem 77 Combinations
//Solution written by Xuqiang Fang on 19 March 2018


/*
Given two integers n and k, return all possible combinations of k numbers
out of 1 ... n.
*/

import java.util.List;
import java.util.ArrayList;

class Solution{
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] arr = new int[n];
		int[] data = new int[k];
		for(int i=0; i<n; i++){
			arr[i] = i+1;
		}
		combination(result, arr, data, 0, n-1, 0, k);//k <= n
		return result;
    }	
	public void combination(List<List<Integer>> result, int[] arr, int[] data, int start, int end, int index, int r){
		if(index == r){
			List<Integer> list = new ArrayList<>();        
			for(int i=0; i<r; i++){
				list.add(data[i]);
			}
			result.add(list);
			return;
		}
		for(int j=start; j<=end && end-j+1 >= r-index; j++){
			data[index] = arr[j];
			combination(result, arr, data, j+1, end, index+1, r);
		}
	}
}

public class Combinations{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.combine(2,2));
	}
}
