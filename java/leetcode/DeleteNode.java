//Leetcode problem 450 Delete Node in a BST
//Solution written by Xuqiang Fang on 11 April, 2018 
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution{
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null)
            return root;
        TreeNode newRoot = null;
        if(root.val == key){
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                newRoot = mini(root.right);
                newRoot.left = root.left;
                if(root.right != newRoot){
                    newRoot.right = root.right;
                    System.out.println("I'm here");
                }
                return newRoot;
            }
        }
        else{
            root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
        }
        return root;
    }	
    public TreeNode mini(TreeNode root){
        //root can not be null
        TreeNode pre = root;
        while(root.left != null){
            pre = root;
            root = root.left;
        }
        if(root.right != null)
            pre.left = root.right;
        else
            pre.left = null;
        return root;
    }
}

public class DeleteNode{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        //print(root);
        root = s.deleteNode(root, Integer.valueOf(args[0]));
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
