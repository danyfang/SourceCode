//Leetcode problem 669 Trim a Binary Search Tree
//Solution written by Xuqiang Fang on 3 May, 2018

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}

class Solution{
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return root;
        else if(root.val < L){
            return trimBST(root.right, L, R); 
        }
        else if(root.val > R){
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }	
}

public class BinaryTreeTrim{
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
        print(root);
        System.out.println("After **********************");
        root = s.trimBST(root, 3,7);
        print(root);
	}
    public static void print(TreeNode root){
        if(root != null){
            print(root.left);
            System.out.println(root.val);
            print(root.right);
        }
    }
}
