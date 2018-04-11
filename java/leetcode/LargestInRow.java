//Leetcode problem 515 Find Largest Value in Each Tree Row
//Solution written by Xuqiang Fang on 11 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.LinkedList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}

class Solution{
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        LinkedList<TreeNode> link = new LinkedList<>();
        link.add(root);
        int cur = 1;//# of nodes at current level
        int next = 0;//# of nodes at next level
        int max = root.val;
        while(!link.isEmpty()){
            root = link.remove();
            max = Math.max(root.val, max);
            cur--;
            if(root.left != null){
                link.add(root.left);
                next++;
            }
            if(root.right != null){
                link.add(root.right);
                next++;
            }
            if(cur == 0){
                list.add(max);
                cur = next;
                next = 0;
                if(!link.isEmpty())
                    max = link.get(0).val;
            }
        }
        return list;
    }
}

public class LargestInRow{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        System.out.println(s.largestValues(root));
	}
}
