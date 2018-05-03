//Leetcode problem 655 Print Binary Tree
//Solution written by Xuqiang Fang on 2 May, 2018 

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
//solution provided by user@compton_scatter
class Solution{
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList<>();
        int height = root == null ? 1 : getHeight(root);

        int rows = height;
        int columns = (int)Math.pow(2, height)-1;
        List<String> row = new ArrayList<>();
        for(int i=0; i<columns; ++i){
            row.add("");
        }
        for(int i=0; i<rows; ++i){
            list.add(new ArrayList<>(row));
        }
        populate(root, list, 0, rows, 0, columns-1);
        return list;
    }	
    private void populate(TreeNode root, List<List<String>> list, int row, int totalRow, int i, int j){
        if(row == totalRow || root == null)
            return;
        list.get(row).set((i+j)/2, Integer.toString(root.val));
        populate(root.left, list, row+1, totalRow, i, (i+j)/2-1);
        populate(root.right, list, row+1, totalRow, (i+j)/2+1, j);
    }
    private int getHeight(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}

public class BinaryTreePrint{
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
        List<List<String>> result = s.printTree(root);
        for(List<String> list : result){
            System.out.println(list);
        }
	}
}
