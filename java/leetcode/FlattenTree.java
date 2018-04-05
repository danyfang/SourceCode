//Leetcode problem 114 Flatten Binary Tree to Linked List
//Solution written by Xuqiang Fang on 3 April 2018 
import java.util.LinkedList;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}

class Solution{
    public void flatten(TreeNode root){
        if(root == null)
            return;
        LinkedList<TreeNode> list = new LinkedList<>();
        list = get(root); 
        TreeNode cur = list.get(0);
        for(int i=1; i<list.size(); i++){
            cur.left = null;
            cur.right = list.get(i); 
            cur = cur.right;
        }
    }

    private LinkedList<TreeNode> get(TreeNode cur){
        LinkedList<TreeNode> list = new LinkedList<>();
        if(cur != null){
            list.add(cur);
            list.addAll(get(cur.left));
            list.addAll(get(cur.right));
        }
        return list;
    }
}

public class FlattenTree{
    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode  a = new TreeNode(2);
        TreeNode  b = new TreeNode(5);
        TreeNode  c = new TreeNode(3);
        TreeNode  d = new TreeNode(4);
        TreeNode  e = new TreeNode(6);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;
        s.flatten(root);
        print(root);
    }
    public static void print(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            //print(root.left);
            print(root.right);
        }
        else
            return;
    }
}
