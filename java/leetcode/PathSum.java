//Leetcode problem 112 Path Sum
//Solution written by Xuqiang Fang on 13 March 2018
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
such that adding up all the values along the path equals the given sum.
*/

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

		root.left = a;
		root.right = b;
		a.left = c;
		c.left = f;
		c.right = g;
		b.left = d;
		b.right = e;
		e.right = h;

		System.out.println(s.hasPathSum(root, Integer.valueOf(args[0])));

	}
}
