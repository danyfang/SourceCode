//Leetcode problem 111 Minimum Depth of Binary Tree
//Solution written by Xuqiang Fang on 12 March 2018

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class Solution{
	public int minDepth(TreeNode root){
		if(root == null)
			return 0;
		else{
			int left = minDepth(root.left);
			int right = minDepth(root.right);
			return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
		}
	}	
}

public class MinimumDepth{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		TreeNode e = new TreeNode(7);
		TreeNode f = new TreeNode(7);
		TreeNode g = new TreeNode(7);
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
		d.right = e;
		e.right = f;
		f.right = g;

		System.out.println(s.minDepth(d));

	}
}
