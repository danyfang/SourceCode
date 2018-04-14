//Leetcode problem 226 Invert Binary Tree
//Solution written by Xuqiang Fang on 13 April, 2018 
import java.util.Queue;
import java.util.LinkedList;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution{
    public TreeNode invertTree(TreeNode root){
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }	
}

public class InvertTree{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(9);
		TreeNode e = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        print_pre(root);
        root = s.invertTree(root);
        print_pos(root);
	}
    public static void print_pre(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            print_pre(root.left);
            print_pre(root.right);
        }
    }
    public static void print_pos(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            print_pos(root.right);
            print_pos(root.left);
        }
    }
}
