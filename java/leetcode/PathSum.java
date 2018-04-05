//Leetcode problem 112 Path Sum
//Leetcode problem 113 Path Sum II
//Solution written by Xuqiang Fang on 13 March 2018
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
such that adding up all the values along the path equals the given sum.
*/

import java.util.ArrayList;
import java.util.List;
//Solution accepted
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}


class Solution{
	public boolean hasPathSum(TreeNode root, int sum){
		if(root == null)
			return false;
		if(root.left == null && root.right == null)
			return root.val == sum;

		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	}
	private void print(TreeNode root){
		if(root != null){
			print(root.left);
			System.out.println(root.val);
			print(root.right);
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> list = new ArrayList<>();
		if(root == null)
			return list;
		if(root.left == null && root.right == null && root.val == sum){
			List<Integer> temp = new ArrayList<>();
			temp.add(root.val);
			list.add(temp);
			return list;
		}	
		else {
			List<List<Integer>> left = pathSum(root.left, sum-root.val);
			for(List<Integer> temp : left){
				temp.add(0,root.val);
				list.add(temp);
			}
			List<List<Integer>> right = pathSum(root.right, sum-root.val);
			for(List<Integer> temp : right){
				temp.add(0,root.val);
				list.add(temp);
			}
		}
		return list;
	}
	public List<Integer> Rprint(TreeNode root, int k){
		List<Integer> list = new ArrayList<>();
		if(root == null)
			return list;

		if(root.left == null && root.right == null && root.val == k){
			list.add(root.val);
			return list;
		}
		else{
			List<Integer> left = Rprint(root.left, k-root.val);
			if(left.size() != 0){
				list.add(root.val);
				list.addAll(left);
			}
			List<Integer> right = Rprint(root.right, k-root.val);
			if(right.size() != 0){
				list.add(root.val);
				list.addAll(right);
			}
		}
			
		return list;
	}
}

public class PathSum{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(8);
		TreeNode c = new TreeNode(11);
		TreeNode d = new TreeNode(13);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(7);
		TreeNode g = new TreeNode(2);
		TreeNode h = new TreeNode(1);
		TreeNode i = new TreeNode(5);

		root.left = a;
		root.right = b;
		a.left = c;
		c.left = f;
		c.right = g;
		b.left = d;
		b.right = e;
		e.left = i;
		e.right = h;

		//System.out.println(s.hasPathSum(root, Integer.valueOf(args[0])));
		System.out.println(s.pathSum(root, Integer.valueOf(args[0])));
		//System.out.println(s.pathSum(root,27));

	}
}
