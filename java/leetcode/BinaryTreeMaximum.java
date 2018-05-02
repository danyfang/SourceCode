//Leetcode problem 654 Maximum Binary Tree
//Solution written by Xuqiang Fang on 2 May, 2018 

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}


class Solution{
    public TreeNode constructMaximumBinaryTree(int[] nums){
        return construct(nums, 0, nums.length-1); 
    }	
    public TreeNode construct(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        else if(left == right){
            TreeNode only = new TreeNode(nums[left]);
            return only;
        }
        int index = maxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);
        root.left = construct(nums, left, index-1);
        root.right = construct(nums, index+1, right);
        return root;
    }
    public int maxIndex(int[] nums, int left, int right){
        int max = nums[left];
        int index = left;
        for(int i=left+1; i<=right; ++i){
            if(nums[i] > max){//no dupilcates, no need for == case
                max = nums[i];
                index = i;
            } 
        }
        return index;
    }
}

public class BinaryTreeMaximum{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3,2,1,6,0,5};
        inorder(s.constructMaximumBinaryTree(nums));
	}
    public static void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }
}
