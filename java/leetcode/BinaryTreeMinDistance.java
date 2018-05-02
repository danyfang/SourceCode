//Leetcode problem 783 Minimum Distance Between BST Nodes
//Leetcode problem 530 Minimum Absolute Difference in BST
//Solution written by Xuqiang Fang on 2 May, 2018 
import java.util.List;
import java.util.ArrayList;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution{
    List<Integer> value;
    public int minDiffInBST(TreeNode root){
        value = new ArrayList<>();
        inorder(root);
        int min = Integer.MAX_VALUE;
        for(int i=1; i<value.size(); ++i){
            min = Math.min(min, value.get(i)-value.get(i-1));
        }
        return min;
    }	
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        else{
            inorder(root.left);
            value.add(root.val);
            inorder(root.right);
        }
    }
    int minimum = Integer.MAX_VALUE;
    int prev = 0;
    public int getMinimumDifference(TreeNode root){
        prev = mini(root);
        inorderTraversal(root);
        return minimum;
    }
    public void inorderTraversal(TreeNode root){
        if(root != null){
            inorderTraversal(root.left);
            if(root.val != prev){
                minimum = Math.min(minimum, root.val - prev);
                prev = root.val;
            }
            System.out.println(root.val);
            inorderTraversal(root.right);
        }
    }
    public int mini(TreeNode root){
        if(root.left == null)
            return root.val;
        return mini(root.left);
    }
}

public class BinaryTreeMinDistance{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        System.out.println(s.getMinimumDifference(root));
	}
}
