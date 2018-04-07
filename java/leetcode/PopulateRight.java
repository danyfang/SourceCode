//Leetcode problem 116 Populating Next Right Pointers in Each Node
//Solution written by Xuqiang Fang on 6 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x){val = x;}
}
class Solution{
    public void connect(TreeLinkNode root){
        int h = height(root);

    }	
    public List<TreeLinkNode> get(TreeLinkNode root, int h){
        List<TreeLinkNode> list = new ArrayList<>();
        return list; 
    }
    public void level(TreeLinkNode root){
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeLinkNode n = root;
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

    public int height(TreeLinkNode root){
        int h = 0;
        while(root != null){
            h++;
            root = root.left;
        }
        return h;
    }
}

public class PopulateRight{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode a = new TreeLinkNode(2);
        TreeLinkNode b = new TreeLinkNode(3);
        TreeLinkNode c = new TreeLinkNode(4);
        TreeLinkNode d = new TreeLinkNode(5);
        TreeLinkNode e = new TreeLinkNode(6);
        TreeLinkNode f = new TreeLinkNode(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        //System.out.println(s.height(root));
        s.level(root);
	}
}
