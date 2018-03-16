//Leetcode problem 144 Binary Tree Preorder Traversal
//Solution written by Xuqiang Fang on 13 March 2018 
/*
Solution used interation, not recursion
*/
//Solution accepted
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
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode current = root;
				
		while(current != null || !stack.isEmpty()){
			if(current != null)
				list.add(current.val);
			while(current != null){
				if(current.left != null)
					list.add(current.left.val);
				stack.push(current);
				current = current.left;
			}
			if(!stack.isEmpty())
				current = stack.pop();
			current = current.right;

		}
		return list;
    }
}
public class PreorderTraveral{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(9);
		TreeNode e = new TreeNode(5);
		root.left = c;
		//c.left = d;
		c.right = e;

		//root.right = a;
		a.left = b;
		System.out.println(s.preorderTraversal(root));

	}
}
