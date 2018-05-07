//Leetcode problem 814 Binary Tree Pruning
//Solution written by Xuqiang Fang on 7 May, 2018

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class Solution{
    public TreeNode pruneTree(TreeNode root){
        if(numberOfOnes(root) == 0)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }
    public int numberOfOnes(TreeNode root){
        if(root == null)
            return 0;
        else if(root.val == 0)
            return numberOfOnes(root.left) + numberOfOnes(root.right);
        else 
            return 1;
    }
}

public class BinaryTreePruning{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(0);
        TreeNode c = new TreeNode(0);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(1);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        c.left = e;
        c.right = f;
        print(s.pruneTree(root));
	}
    public static void print(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            print(root.left);
            print(root.right);
        }
    }
}
