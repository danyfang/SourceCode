//Leetcode problem 257 Binary Tree Paths
//Solution written by Xuqiang Fang on 6 April, 2018 
import java.util.ArrayList;
import java.util.List;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution{
    public List<String> binaryTreePaths(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root == null)
            return list;
        if(root.left == null && root.right == null){
            list.add(root.val + "");
            return list;
        }
        for(String s : binaryTreePaths(root.left)){
            list.add(root.val + "->" + s);
        }
        for(String s : binaryTreePaths(root.right)){
            list.add(root.val + "->" + s);
        }
        return list;
    }	
}

public class TreePath{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.right = c;
        System.out.println(s.binaryTreePaths(root));
        System.out.println("Hello World");
	}
}
