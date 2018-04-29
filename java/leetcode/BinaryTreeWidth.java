//Leetcode problem 662 Maximum Width of Binary Tree
//Solution written by Xuqiang Fang on 28 April, 2018 
import java.util.ArrayList;
import java.util.List;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
/*
answer and explanation provided by user@caihao0727mail
We know that a binary tree can be represented by an array (assume the root begins
from the position with index 1 in the array). If the index of a node is i, the
indices of its two children are 2*i and 2*i + 1. The idea is to use two arrays
(start[] and end[]) to record the the indices of the leftmost node and rightmost
node in each level, respectively. For each level of the tree, the width is 
end[level] - start[level] + 1. Then, we just need to find the maximum width.
*/
class Solution{
    public int widthOfBinaryTree(TreeNode root){
        if(root == null)
            return 0;
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }    	

    public int dfs(TreeNode root, int level, int order, List<Integer>start, List<Integer> end){
        if(root == null)
            return 0;
        if(start.size() == level){
            start.add(order);
            end.add(order);
        }
        else{
            end.set(level, order);
        }
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level+1, 2 * order, start, end);
        int right = dfs(root.right, level+1, 2*order+1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}

public class BinaryTreeWidth{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(7);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(15);
		TreeNode c = new TreeNode(9);
		TreeNode d = new TreeNode(20);
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
        System.out.println(s.widthOfBinaryTree(root));
	}
}


