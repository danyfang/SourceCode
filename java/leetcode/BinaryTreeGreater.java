//Leetcode problem 538 Convert BST to Greater Tree
//Solution written by Xuqiang Fang on 

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class Solution{
    private int remain;
    public TreeNode convertBST(TreeNode root){
        if(root == null)
            return root;
        remain = sum(root); 
        inorder(root);
        return root;
    }	
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        int original = root.val;
        root.val = remain;
        remain -= original;
        inorder(root.right);
    }
    public int sum(TreeNode root){
        if(root == null)
            return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}

public class BinaryTreeGreater{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(7);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(15);
		TreeNode c = new TreeNode(9);
		TreeNode d = new TreeNode(20);
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
        root = s.convertBST(root);
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
