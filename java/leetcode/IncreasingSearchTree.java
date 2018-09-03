//Leetcode problem 897 Increasing Order Search Tree
//Solution written by Xuqiang Fang on 2 Sep, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
class Solution{
    public TreeNode increasingBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode ans = null;
        TreeNode left = null;
        TreeNode right = null;
        if(root.left != null){
            left = increasingBST(root.left);
            ans = left;
            while(left.right != null){
                left = left.right;
            }
            if(left != null){
                left.right = root;
            }
            root.left = null;
        }
        else{
            ans = root;
        }
        if(root.right != null){
            right = increasingBST(root.right);
            root.right = right;
        }
        return ans;
    }   
}

public class IncreasingSearchTree{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode a = new TreeNode(5);
	}
}
