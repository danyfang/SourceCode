//Leetcode problem 501 Find Mode in Binary Search Tree
//Solution written by Xuqiang Fang on 9 May, 2018
import java.util.ArrayList;
import java.util.List;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}

class Solution{
    private int mode = 1;
    private int count = 1;
    private TreeNode prev = null;
    public int[] findMode(TreeNode root){
        List<Integer> list = new ArrayList<>();        
        traversal(list, root);
        System.out.println(list);
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; ++i){
            res[i] = list.get(i);
        }
        return res;
    }    
    private void traversal(List<Integer> list, TreeNode root){
        if(root != null){
            traversal(list, root.left);
            if(prev != null){
                if(prev.val == root.val){
                    count++;
                }
                else{
                    count = 1;
                }
            }
            prev = root;
            if(count == mode){
                list.add(root.val);
            }
            else if(count > mode){
                list.clear();
                mode = count;
                list.add(root.val);
            }
            System.out.println(root.val);
            traversal(list, root.right);
        }
    }
}

public class BinaryTreeMode{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(7);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(9);
        TreeNode f = new TreeNode(9);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        int[] res = s.findMode(root);
	}
}
