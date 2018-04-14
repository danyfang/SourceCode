//Leetcode problem 222 Count Complete Tree Nodes
//Solution written by Xuqiang Fang on 13 April, 2018 

import java.util.Queue;
import java.util.LinkedList;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution{
    //exceeded time limit
    public int countNodes_(TreeNode root){
        if(root == null)
            return 0;
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while(!queue.isEmpty()){
            curr = queue.remove();
            if(curr.left != null){
                count++;
                queue.offer(curr.left);
            }
            else{
                return count;
            }
            if(curr.right != null){
                count++;
                queue.offer(curr.right);
            }
            else{
                return count;
            }
        }
        return count;
    }	
    public int count(TreeNode root){
        int c = 0;
        if(root != null){
            return count(root.left) + count(root.right) + 1;   
        }
        return c;
    }

    public int countNodes(TreeNode root){
        if(root == null)
            return 0;
        int l = leftHeight(root.left);
        int r = rightHeight(root.right);
        if(l == r)
            return (1 << l) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
        
    }
    private int leftHeight(TreeNode root){
        int h = 0;
        while(root != null){
            h++;
            root = root.left;
        }
        return h;
    }
    private int rightHeight(TreeNode root){
        int h = 0;
        while(root != null){
            h++;
            root = root.right;
        }
        return h;
    }
}

public class CompleteTreeNodes{
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
        System.out.println(s.count(root));
	}
}
