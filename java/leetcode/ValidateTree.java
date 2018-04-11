//Leetcode problem 98 Validate Binary Search Tree
//Leetcode problem 99 Recover Binary Search Tree 
//Solution written by Xuqiang Fang on 10 April, 2018 
import java.util.ArrayList;
import java.util.List;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution {
    //Solution 1, return inorder traversal
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        List<Integer> list = traversal(root);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) >= list.get(i+1))
                return false;
        }
        return true;
    }
    public List<Integer> traversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root != null){
            list.addAll(traversal(root.left));
            list.add(root.val);
            list.addAll(traversal(root.right));
        }
        return list;
    }
    //Solution 2, use boundaries, with limited case where min value reaches limit
    //Wrong answer
    public boolean isValid(TreeNode root){
        if(root == null)
            return true;
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode root, int min, int max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    public void recoverTree(TreeNode root){
        TreeNode first = null;
        TreeNode second = null;
        TreeNode temp = null;
        TreeNode pre = null;
        while(root != null){
            if(root.left != null){
                temp = root.left;
                while(temp.right != null && temp.right != root)
                    temp = temp.right;
                
                //restore the tree
                if(temp.right != null){
                    temp.right = null;
                    if(pre != null && pre.val > root.val){
                        if(first == null)
                            first = pre;
                        second = root;
                    }
                    pre = root;
                    root = root.right;
                }
                //thread the tree
                else{
                    temp.right = root;
                    root = root.left;
                }
            }
            else{
                if(pre != null && pre.val > root.val){
                    if(first == null)
                        first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        if(first != null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
public class ValidateTree{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(2);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(1);
        root.left = a;
        root.right = b;
        System.out.println("Before recover");
        System.out.println(s.isValid(root));
        s.recoverTree(root);
        System.out.println("After recover");
        System.out.println(s.isValidBST(root));
	}
}
