//Leetcode problem 110 Balanced Binary Tree
//Solution written by Xuqiang Fang on 29 March 2018 
import java.util.ArrayList;
import java.util.List;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}
class Solution{
	public boolean isBalanced(TreeNode root){
		if(root == null)
			return true;
		if(Math.abs(height(root.left) - height(root.right)) > 1){
			//System.out.println(root.val);
			//System.out.println(height(root.left));
			//System.out.println(height(root.right));
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}	
	public void print(TreeNode root){
		if(root == null)
			return;
		print(root.left);
		System.out.println(root.val);
		print(root.right);
	}
	public int height(TreeNode root){
		int h = 0;
		if(root == null){
			return h;
		}
		else{
			h = 1 + Math.max(height(root.left), height(root.right));
		}
		return h;
	}
}

public class BalanceTree{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(2);
		root.left = a;
		root.right = b;

		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(3);
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;

		TreeNode g = new TreeNode(4);
		TreeNode h = new TreeNode(4);
		TreeNode i = new TreeNode(4);
		TreeNode j = new TreeNode(4);
		TreeNode k = new TreeNode(4);
		TreeNode l = new TreeNode(4);
		c.left = g;
		c.right = h;
		d.left = i;
		d.right = j;
		e.left = k;
		e.right = l;

		TreeNode m = new TreeNode(5);
		TreeNode n = new TreeNode(5);
		g.left = m;
		g.right = n;

		System.out.println(s.isBalanced(root));
	}
}
