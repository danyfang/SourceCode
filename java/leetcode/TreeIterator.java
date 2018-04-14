//Leetcode problem 173 Binary Search Tree Iterator
//Solution written by Xuqiang Fang on 12 April, 2018 
import java.util.Stack;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
public class TreeIterator{
    Stack<TreeNode> stack;	
    public TreeIterator(TreeNode root){
        stack = new Stack<TreeNode>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public boolean hashNext(){
        return stack.isEmpty();
    }

    public int next(){
        TreeNode node = stack.pop();
        int result = node.val;
        if(node.right != null){
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}


