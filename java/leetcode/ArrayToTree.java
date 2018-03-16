//Leetcode problem 108 Converted Sorted Array to Binary Search Tree
//Solution written by Xuqiang Fang on 16 March 2018

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class Solution{
	public TreeNode sortedArrayToBST(int[] nums){
		int n = nums.length;
		int middle = (n-1)/2;
		TreeNode root = new TreeNode(nums[middle])	
	}	
}

public class ArrayToTree{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {-10,-3,0,5,9};
	}
	public static void print(TreeNode root){
	}
}
