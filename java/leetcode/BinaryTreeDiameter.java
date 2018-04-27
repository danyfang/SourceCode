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
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 0;
        else if(root.left == null)
            return diameterOfBinaryTree(root.right) + 1;
        else if(root.right == null)
            return diameterOfBinaryTree(root.left) + 1;
        else
            return Math.max(diameterOfBinaryTree(root.left)+diameterOfBinaryTree(root.right)+2 , Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    } 	
    public int height(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

public class BinaryTreeDiameter{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
        System.out.println(s.height(root));
	}
}
