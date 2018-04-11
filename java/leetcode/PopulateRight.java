//Leetcode problem 116 Populating Next Right Pointers in Each Node
//Leetcode problem 117 Populating Next Right Pointers in Each Node II
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
    public void connect_(TreeLinkNode root){
        if(root == null)
            return;
        TreeLinkNode level = root;
        TreeLinkNode left = level.left;
        while(left != null){
            level.left.next = level.right;
            if(level.next != null){
                level.right.next = level.next.left;
                level = level.next;
            }
            else{
                level = left;
                left = level.left;
            }
        }
    }	
    public void connect(TreeLinkNode root){
        TreeLinkNode head = root;//the left most node in the lower level
        TreeLinkNode prev = null;//the previous node in the lower level
        TreeLinkNode curr = null;//the current node in the upper level
        while(head != null){
            curr = head;
            prev = null;
            head = null;
            while(curr != null){
                if(curr.left != null){
                    if(prev != null)
                        prev.next = curr.left;
                    else
                        head = curr.left;
                    prev = curr.left;
                }
                if(curr.right != null){
                    if(prev != null)
                        prev.next = curr.right;
                    else
                        head = curr.right;
                    prev = curr.right;
                }
                curr = curr.next;
            }
        }
    }
    public TreeLinkNode findNext(TreeLinkNode cur, TreeLinkNode level){
        //cur and level can not be null
        while(level != null){
            if(level.left != null && level.left != cur)
                return level.left;
            else if(level.right != null && level.right != cur){
                return level.right;
            }else 
                level = level.next;
        }
        return null;
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
        TreeLinkNode g = new TreeLinkNode(8);
        TreeLinkNode h = new TreeLinkNode(9);
        TreeLinkNode i = new TreeLinkNode(10);
        TreeLinkNode j = new TreeLinkNode(11);
        TreeLinkNode k = new TreeLinkNode(12);
        TreeLinkNode l = new TreeLinkNode(13);
        TreeLinkNode m = new TreeLinkNode(14);
        TreeLinkNode n = new TreeLinkNode(15);
        root.left = a;
        root.right = b;
        a.left = c;
        //a.right = d;
        //b.left = e;
        b.right = f;
        /*
        c.left = g;
        c.right = h;
        d.left = i;
        d.right = j;
        e.left = k;
        e.right = l;
        f.left = m;
        f.right = n;
        */
        //System.out.println(s.height(root));
        //s.level(root);
        s.connect(root);
        print(root);
	}
    public static void print(TreeLinkNode root){
        while(root != null){
            TreeLinkNode level = root;
            while(level != null){
                System.out.println(level.val);
                level = level.next;
            }
            root = root.left;
        }
    }
}
