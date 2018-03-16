//Leetcode problem 94 Binary Tree Inorder Traversal
//Solution written by Xuqiang Fang on 13 March 2018 
//Iterative solution provided by user@lvlolitte
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode current = root;
		while(current != null || !stack.isEmpty()){
			while(current != null){
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			list.add(current.val);
			current = current.right;
		}
		return list;
    }
}


public class InorderTraversal{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		root.right = a;
		a.left = b;
		System.out.println(s.inorderTraversal(root));
	}
}
