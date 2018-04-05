//Leetcode problem 145 Binary Tree PostorderTraversal
//Solution written by Xuqiang Fang on 25 March 2018 

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}


class Solution{
	public List<Integer> recursive(TreeNode root){
		List<Integer> list = new ArrayList<>();
		if(root == null)
			return list;

		list.addAll(recursive(root.left));
		list.addAll(recursive(root.right));
		list.add(root.val);
		return list;
	}	
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode current = root;
		TreeNode pre = null;

		while(current != null || !stack.isEmpty()){
			while(current != null){
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			if(current.right != null && pre != current.right){
				stack.push(current);
				current = current.right;
				continue;
			}
			list.add(current.val);
			pre = current;
			current = null;
		}
		return list;
	}
}

public class PostorderTraversal{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(9);
		TreeNode e = new TreeNode(5);
		root.left = c;
		c.left = d;
		c.right = e;

		root.right = a;
		a.left = b;
		System.out.println(s.recursive(root));
		System.out.println(s.postorderTraversal(root));
	}
}
