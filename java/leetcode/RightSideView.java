//Leetcode problem 199 Binary Tree Right Side View
//Solution written by Xuqiang Fang on 6 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}

class Solution{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode n = root;
        int next = 0;
        int curr = 1;
        while(!queue.isEmpty()){
            n = queue.poll();
            curr--;
            if(n.left != null){
                queue.offer(n.left);
                next++;
            }
            if(n.right != null){
                queue.offer(n.right);
                next++;
            }
            if(curr == 0){
                list.add(n.val);
                curr = next;
                next = 0;
            }

        }
        return list;
    }	
    //This Solution is really Genius!!!
    public void level(TreeNode root){
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode n = root;
        int next = 0;//denote number of nodes in next level
        int curr = 1;//denote number of nodes in current level, here we have root
        while(!queue.isEmpty()){
            n = queue.poll();
            curr--;//remove one node from current level
            if(n.left != null){
                queue.offer(n.left);
                next++;//count up next level nodes
            }
            if(n.right != null){
                queue.offer(n.right);
                next++;//count up next level nodes
            }
            if(curr == 0){//if it's current level's last node
                System.out.println(n.val);
                curr = next;//go to next level
                next = 0;
            }

        }
    }
}

public class RightSideView{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.right = c;
        b.right = d;
        //s.level(root);
        System.out.println(s.rightSideView(root));
	}
}
