//Leetcode problem 106 Construct Binary Tree from Inorder and Postorder Traversal
//Leetcode problem 105 Construct Binary Tree from Preorder and Inorder Traversal
//Solution written by Xuqiang Fang on 6 April 2018 

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution{
    public TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder == null || postorder == null || postorder.length <= 0)
            return null;
        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[n-1]);
        //System.out.println(root.val);
        int left = 0;
        int right = 0;
        for(int i : inorder){
            if(i == root.val)
                break;
            left++;
        }
        right = n - 1 - left;
        //System.out.println(left);
        //System.out.println(right);
        int left_inorder[] = new int[left];
        int right_inorder[] = new int[right];
        int left_postorder[] = new int[left];
        int right_postorder[] = new int[right];
        for(int i=0; i<left; i++){
            left_inorder[i] = inorder[i];
            left_postorder[i] = postorder[i];
        }
        for(int i=left+1; i<n; i++){
            right_inorder[i-1-left] = inorder[i]; 
            right_postorder[i-1-left] = postorder[i-1]; 
        }
        root.left = buildTree(left_inorder, left_postorder);
        root.right = buildTree(right_inorder, right_postorder);
        return root;
    }	
    public TreeNode buildTree_(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null || preorder.length <= 0)
            return null;
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        int left = 0;
        int right = 0;
        for(int i : inorder){
            if(i == root.val)
                break;
            left++;
        }
        right = n - 1 - left;
        int left_preorder[] = new int[left];
        int right_preorder[] = new int[right];
        int left_inorder[] = new int[left];
        int right_inorder[] = new int[right];
        for(int i=1; i<left+1; i++){
            left_preorder[i-1] = preorder[i];
            left_inorder[i-1] = inorder[i-1];
        }
        for(int i=left+1; i<n; i++){
            right_preorder[i-1-left] = preorder[i];
            right_inorder[i-1-left] = inorder[i];
        }
        for(int i : left_inorder){
            System.out.println(i);
        }
        root.left = buildTree_(left_preorder, left_inorder);
        root.right = buildTree_(right_preorder, right_inorder);
        return root;
    }
}

public class ConstructTree{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        int[] preorder = {3,9,20,15,7};
        //TreeNode root = s.buildTree(inorder, postorder);
        TreeNode root_ = s.buildTree_(preorder, inorder);
        //inorder(root);
        //postorder(root);
        inorder(root_);
        preorder(root_);
	}
    public static void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        } 
        else
            return;
    }
    public static void postorder(TreeNode root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.val);
        } 
        else
            return;
    }
    public static void preorder(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
        else 
            return;
    }
}
