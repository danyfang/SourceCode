//Leetcode problem 235 Lowest Common Ancestor of a Binary Search Tree
//Leetcode problem 236 Lowest Common Ancestor of a Binary Tree
/*
!!!!! The difference between Binary Search tree and binary tree is BST is sorted
*/
//Solution written by Xuqiang Fang on 14 April, 2018 
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution{ 
    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if(max < root.val)
            return lowestCommonAncestor_(root.left, p, q);
        else if(min > root.val) 
            return lowestCommonAncestor_(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        
        int left = locate(root.left, p, q);
        int right = locate(root.right, p, q);
        if(left == 2)
            return lowestCommonAncestor(root.left, p, q);
        else if(right == 2)
            return lowestCommonAncestor(root.right, p, q);
        else 
            return root;
    }
    public int locate(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return 0;

        if(root == p || root == q){
            return 1 + locate(root.left, p, q) + locate(root.right, p, q);
        }

        return locate(root.left, p, q) + locate(root.right, p, q); 
    }
}

public class CommonAncestor{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(6);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(8);
		TreeNode c = new TreeNode(0);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(7);
		TreeNode f = new TreeNode(9);
		TreeNode g = new TreeNode(3);
		TreeNode h = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        d.left = g;
        d.right = h;
        System.out.println(s.lowestCommonAncestor(root, a, b).val);
	}
}
