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
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int arr[] = new int[n];
        int data[] = new int[k];
        combination(arr, data, 1, n, 0, k);//k <= n
        return result;
    }
    public void combination(int[] arr,int[] data, int start, int end, int index, int r){
        if(index == r){
        }
        for(int j=start; j<=end && end-j+1 >= r-index; j++){
        }
    }
}

public class Combinations{
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.combine(4,2));
    }
}
