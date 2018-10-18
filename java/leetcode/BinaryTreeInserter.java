//Leetcode problem 919 Complete Binary Tree Inserter
//Solution written by Xuqiang Fang on 18 Oct, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class CBTInserter {

    public CBTInserter(TreeNode root) {
        nodes = new ArrayList<>(); 
        this.bfs(root);
    }
    
    public int insert(int v) {
        int next = nodes.size();
        TreeNode parent = nodes.get((next-1)/2);    
        TreeNode child = new TreeNode(v);
        nodes.add(child);
        if(parent.left == null){
            parent.left = child;
        }
        else{
            parent.right = child;
        }
        return parent.val;
    }
    
    public TreeNode get_root() {
        return nodes.get(0);
    }
    public void print(){
        for(TreeNode n : nodes){
            System.out.println(n.val);
        }
    }
    private void bfs(TreeNode root){
        if(root != null){
            LinkedList<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while(!deque.isEmpty()){
                TreeNode tmp = deque.pollFirst(); 
                nodes.add(tmp);
                if(tmp.left != null){
                    deque.add(tmp.left);
                }
                if(tmp.right != null){
                    deque.add(tmp.right);
                }
            }
        }
    }
    private List<TreeNode> nodes;
}
public class BinaryTreeInserter{
	public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode lleft = new TreeNode(4);
        TreeNode lright = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = lleft;
        left.right = lright;

        CBTInserter s = new CBTInserter(root);
        System.out.println(s.insert(6));
        System.out.println(s.insert(7));
        System.out.println(s.insert(8));
        s.print();
	}
}
