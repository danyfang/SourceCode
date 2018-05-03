//Leetcode problem 623 Add One Row to Tree
//Solution written by Xuqiang Fang on 2 May, 2018 
import java.util.Queue;
import java.util.LinkedList;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}


class Solution{
    public TreeNode addOneRow(TreeNode root, int v, int d){
        if(d == 1){
            TreeNode ret = new TreeNode(v);
            ret.left = root;
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);
        int curr = 1;
        int next = 0;
        while(!queue.isEmpty()){
            curr--;
            TreeNode temp = queue.poll();
            if(d > 2){
                if(temp.left != null){
                    queue.offer(temp.left);
                    next++;
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                    next++;
                }
            }
            if(d == 2){
                while(true){
                    TreeNode l = new TreeNode(v);
                    TreeNode r = new TreeNode(v);
                    l.left = temp.left;
                    r.right = temp.right;
                    temp.left = l;
                    temp.right = r;
                    if(queue.isEmpty())
                        break;
                    temp = queue.poll();
                }
            }
            if(curr == 0){
                d--;
                curr = next;
                next = 0;
            }

        }

        return root;
    }	
}

public class BinaryTreeOneRow{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(3);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        c.left = e;
        e.left = f;
        print(s.addOneRow(root, 8, 2));
	}
    public static void print(TreeNode root){
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.println(temp.val);
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }
}
