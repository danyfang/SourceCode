//Leetcode problem 103 Binary Tree Zigzag Level Orderl Traversal
//Solution written by Xuqiang Fang on 13 March 2018
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).
*/
//Solution accepted
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}
class Solution{
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> level = new ArrayList<Integer>();

		if(root == null)
			return result;

		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		current.push(root);
		int alter = 1;
		while(!current.isEmpty()){
			TreeNode node = current.pop();
			level.add(node.val);	
			if(alter % 2 == 0){
				if(node.right != null)
					next.push(node.right);
				if(node.left != null)
					next.push(node.left);
			}else{
				if(node.left != null)
					next.push(node.left);
				if(node.right != null)
					next.push(node.right);
			}
			if(current.isEmpty()){
				alter++;
				current = next;
				next = new LinkedList<TreeNode>();
				result.add(level);
				level = new ArrayList<Integer>();
			}

		}
        return result;
    }
}

public class ZigzagLevel{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(8);
	
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
		//a.left = e;
		//a.right = f;
		
		System.out.println(s.zigzagLevelOrder(null));
	}
}
