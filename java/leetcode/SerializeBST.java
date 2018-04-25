//Leetcode problem 449 Serialize and Deserialize BST
//Solution written by Xuqiang Fang on 25 April, 2018 

import java.util.Queue;
import java.util.LinkedList;
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
        if(root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root); 
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                sb.append("#");
                sb.append(",");
            }
            else if(temp != null){
                sb.append(temp.val);
                sb.append(",");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }


        return sb.toString();
    }

    public TreeNode deserialize(String data){
        String[] s = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        for(String st : s){
            queue.offer(st); 
        }
        TreeNode root = null;
        if(s[0].equals("") || s[0].equals("#"))
            return root;
        root = new TreeNode(Integer.valueOf(s[0]));
        q.offer(root);
        queue.poll();
        while(!queue.isEmpty()){
            String left = queue.poll();
            String right = queue.poll();
            System.out.println(left);
            System.out.println(right);
            TreeNode t = q.poll();
            if(!left.equals("#")){
                t.left = new TreeNode(Integer.valueOf(left));
                q.offer(t.left);
            }
            if(!right.equals("#")){
                t.right = new TreeNode(Integer.valueOf(right));
                q.offer(t.right);
            }
        }
        return root; 
    }
}

public class SerializeBST{
	public static void main(String[] args){
		Codec s = new Codec();
        TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(8);
		TreeNode c = new TreeNode(11);
		TreeNode d = new TreeNode(13);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(7);
		TreeNode g = new TreeNode(2);
		TreeNode h = new TreeNode(1);
		TreeNode i = new TreeNode(5);

		root.left = a;
		root.right = b;
		a.left = c;
		c.left = f;
		c.right = g;
		b.left = d;
		b.right = e;
		e.left = i;
		e.right = h;
        String st = s.serialize(root);
        System.out.println(st);
        TreeNode newRoot = s.deserialize(st);
        System.out.println(s.serialize(newRoot).equals(st));
	}
}
