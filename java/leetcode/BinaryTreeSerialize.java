//Leetcode problem 297 Serialize and Deserialize Binary Tree
//Solution written by Xuqiang Fang on 27 April, 2018 

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class Codec{
    public String serialize(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                sb.append("#");
                sb.append(",");
            }
            else{
                sb.append(temp.val);
                sb.append(",");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return sb.toString().substring(0, sb.length()-1);
    }	
    public TreeNode deserialize(String data){
        Queue<String> tree = new LinkedList<>();
        String[] nodes = data.split(",");
        for(String node : nodes){
            tree.offer(node);
        }
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        if(tree.peek().equals("#")){
            return root;
        }
        else{
            root = new TreeNode(Integer.valueOf(tree.poll()));
            queue.offer(root);
        }
        while(!tree.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp != null){//if temp is null, it means it's children are not serialized
            //hence it is not in the queue tree
                if(tree.peek().equals("#")){
                    temp.left = null;
                    tree.poll();
                } 
                else{
                    temp.left = new TreeNode(Integer.valueOf(tree.poll()));
                }
                queue.offer(temp.left);

                if(tree.peek().equals("#")){
                    temp.right = null;
                    tree.poll();
                }
                else{
                    temp.right = new TreeNode(Integer.valueOf(tree.poll()));
                }
                queue.offer(temp.right);
            }
        }
        return root; 
    }
}

public class BinaryTreeSerialize{
	public static void main(String[] args){
		Codec s = new Codec();
 		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
        System.out.println(s.serialize(s.deserialize(s.serialize(root)))); 
	}
}
