//Leetcode problem 230 Kth Smallest Element in a BST
//Solution written by Xuqiang Fang on 
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
class Solution{
    private int kth;
    public int kthSmallest(TreeNode root, int k){
        kth = k;
        return inorder(root);
    }    	
    private int inorder(TreeNode root){
        if(kth == 1)
            return root.val;
    }
}

public class KthSmallestInTree{
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
        System.out.println(s.kthSmallest(root, 1));
        System.out.println(s.kthSmallest(root, 3));
        System.out.println(s.kthSmallest(root, 5));
	}
}
