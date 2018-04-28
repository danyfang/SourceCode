//Leetcode problem 543 Diameter of Binary Tree
//Solution written by Xuqiang Fang on 27 April, 2018 

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class Solution{
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter = 0;
        if(root == null)
            return diameter;
        else if(root.left == null && root.right == null)
            return diameter;
        else if(root.left == null){
            diameter = height(root.right);
        }
        else if(root.right == null){
            diameter = height(root.left);
        }
        else{
            diameter = height(root.left) + height(root.right);
        }
        return Math.max(diameter, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    } 	
    public int height(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

public class BinaryTreeDiameter{
	public static void main(String[] args){
		Solution s = new Solution();
        /*
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
        */
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        c.left = e;
        c.right = f;
        System.out.println(s.height(root));
	}
}
