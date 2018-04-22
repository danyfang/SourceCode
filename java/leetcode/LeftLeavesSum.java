//Leetcode problem 404 Sum Of Left Leaves
//Solution written by Xuqiang Fang on 21 April, 2018 
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution{
    public int sumOfLeftLeaves(TreeNode root){
        int s = 0;
        if(root == null)
            return s;
        if(root.left != null && root.left.left == null && root.left.right == null){
            s = root.left.val; 
        }
        return s + sumOfLeftLeaves(root.right)+sumOfLeftLeaves(root.left);
    }	
}

public class LeftLeavesSum{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(7);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        a.left = e;
        a.right = f;
        System.out.println(s.sumOfLeftLeaves(root));
	}
}
