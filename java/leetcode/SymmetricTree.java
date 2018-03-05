//Leetcode problem 101 Symmetric Tree
//Solution written by Xuqiang Fang on 3 March, 2018
/*
Given a binary tree check whether it is a mirro of itself
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val = x;
	}
}

class Solution{
	public boolean isSymmetric(TreeNode root){
		return root == null || isSymmetricHelp(root.left, root.right);
	}	
	private boolean isSymmetricHelp(TreeNode left, TreeNode right){
		if(left == null || right == null)
			return left ==  right;

		if(left.val != right.val)
			return false;

		return isSymmetricHelp(left.left, right.right) && 
		isSymmetricHelp(left.right, right.left);
	}

	public void print(TreeNode root){
		if(root == null)
			return;
		System.out.println(root.val);
		printPair(root.left, root.right);
	}

	private void printPair(TreeNode left, TreeNode right){
		if(left == null && right == null)
			return;
		if(left != null && right != null){
			System.out.println(left.val);
			System.out.println(right.val);
			printPair(left.left, right.right);
			printPair(left.right, right.left);
		}
		if(left == null && right != null){
			System.out.println(right.val);
			printPair(right.left, right.right);
		}
		if(right == null && left != null){
			System.out.println(left.val);
			printPair(left.left, left.right);
		}	
	}


	//bread first search
	public void breadFirst(TreeNode root){
		int H = this.height(root);
		System.out.println("The height of the tree is : " + H);
		for(int i=1; i<=H; i++){
			this.level(root, i);
		}
	}

	private int h = 0;//the height of tree
	//it's supposed to be attribute of a tree
	private int height(TreeNode root){
		if(root == null)
			return h;
		int a = height(root.left);
		int b = height(root.right);
		return a > b ? 1 + a : 1 + b;
	}

	//print the value on a certain level
	public void level(TreeNode root, int level){
		if(root == null){
			return;
		}
		if(level == 1)
			System.out.println(root.val + " ");
		else if(level > 1){
			level(root.left, level-1);
			level(root.right, level-1);
		}
	}
}

public class SymmetricTree{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(4);
		a.left = b;
		a.right = c;
		//b.left = d;
		b.right = d;
		//c.left = g;
		c.right = e;
		//System.out.println(s.isSymmetric(a));
		//s.print(a);
		s.breadFirst(a);
	}
}
