//Leetcode problem 230 Kth Smallest Element in a BST
//Leetcode problem 671 Second Minimum Node In a Binary Tree 
//Solution written by Xuqiang Fang on 21 April, 2018

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution{
    private int kth;
    public int[] array;
    public int index;
    public int kthSmallest(TreeNode root, int k){
        kth = k;
        array = new int[k];
        index = 0;
        inorder(root);
        return array[k-1]; 
    }    	
    public void inorder(TreeNode root){
        if(root != null ){
            inorder(root.left);
            if(index < kth)
                array[index++] = root.val;
            inorder(root.right);
        }
    }



    //problem 671
import java.util.HashSet;
import java.util.Arrays;
class Solution {
    HashSet<Integer> set = null;
    public int findSecondMinimumValue(TreeNode root){
        //the binary tree is non-empty
        set = new HashSet<>();
        inorder(root);
        if(set.size() >= 2){
            int[] arr = new int[set.size()];
            int index = 0;
            for(int i : set){
                arr[index++] = i;
            }
            Arrays.sort(arr);
            return arr[1];
        }

        return -1;
    }
    private void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            if(!set.contains(root.val)){
                set.add(root.val);
            }
            inorder(root.right);
        }
    }

}
}

public class KthSmallestInTree{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(6);
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
