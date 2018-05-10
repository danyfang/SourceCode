//Leetcode problem 687 Longest Univalue Path
//Solution written by Xuqiang Fang on 10 May, 2018

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
class Solution{
    public int longestUnivaluePath(TreeNode root){
        if(root == null){
            return 0;
        }
        int length = pathRoot(root.left, root.val) + pathRoot(root.right, root.val);
        return Math.max(length, Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
    }

    private int pathRoot(TreeNode child, int val){
        if(child == null || child.val != val){
            return 0;
        }
        else{
            return 1 + Math.max(pathRoot(child.left, val), pathRoot(child.right, val));
        }
    }
}

public class BinaryTreeUnivaluePath{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(9);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(9);
        TreeNode f = new TreeNode(9);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(s.longestUnivaluePath(root));
	}
}
