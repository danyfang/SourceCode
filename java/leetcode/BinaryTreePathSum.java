//Leetcode problem 124 Binary Tree Maximum Path Sum
//Solution written by Xuqiang Fang on 3 July, 2018
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
    TreeNode(int x){val = x;}
}
class Solution{
    public int maxPathSum(TreeNode root){
        if(root == null){
            return 0;
        } 
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = Math.max(0, helper(root.left));
        int r = Math.max(0, helper(root.right));
        int sum = l + r + root.val;
        ans = Math.max(ans, sum);
        return Math.max(l, r) + root.val;
    }
    private int ans;
}

public class BinaryTreePathSum{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode r = new TreeNode(-6);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        r.left = a;
        r.right = b;
        a.right = c;
        System.out.println(s.maxPathSum(r));
	}
}
