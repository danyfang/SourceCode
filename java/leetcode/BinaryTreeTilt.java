//Leetcode problem 563 Binary Tree Tilt
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
    public int findTilt(TreeNode root){
        int sum = sum(root);
        return tilt;
    }    	
    private int tilt;
    public int sum(TreeNode root){
        if(root == null)
            return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        tilt += Math.abs(left - right);
        System.out.println(tilt);
        return root.val + left + right;
    }

}

public class BinaryTreeTilt{
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
        System.out.println(s.findTilt(root));
	}
}
