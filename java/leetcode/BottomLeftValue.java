//Leetcode problem 513 Find Bottom Left Tree Value
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
class Solution{
    public int findBottomLeftValue(TreeNode root){
        //root is not NULL
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ret = root.val;
        int prev = 1;//number of nodes in previous row
        int next = 0;//number of nodes in next row
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            prev--;
            System.out.println(temp.val);
            if(temp.left != null){
                queue.offer(temp.left);
                next++;
            }
            if(temp.right != null){
                queue.offer(temp.right);
                next++;
            }
            if(prev == 0){
                prev = next;
                next = 0;
                if(prev != 0)
                    ret = queue.peek().val;
            }
        }
        return ret;
    }	
}

public class BottomLeftValue{
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		root.left = a;
		root.right = b;
		b.left = c;
		b.right = d;
        System.out.println(s.findBottomLeftValue(root));        
	}
}
