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

class Solution{
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList<>();
        if(root == null){
            List<String> temp = new ArrayList<>();
            temp.add("0");
            list.add(temp);
            return list;
        }
        else if(root.left == null && root.right == null){
            List<String> temp = new ArrayList<>();
            temp.add(String.valueOf(root.val));
            list.add(temp);
            return list;
        }
        else{
            //left and right are both not null
            List<List<String>> left = printTree(root.left);
            List<List<String>> right = printTree(root.right);
            int size = left.get(0).size();
            List<String> temp = new ArrayList<>();
            for(int i=0; i<size; ++i){
                temp.add("0");
            }
            temp.add(String.valueOf(root.val));
            for(int i=0; i<size; ++i){
                temp.add("0");
            }
            list.add(temp);
            if(right.size() > left.size()){
                List<List<String>> exchange = left;
                left = right;
                right = exchange;
            }
            for(int i=0; i<left.size(); ++i){
                List<String> l = left.get(i);
                List<String> r;
                if(i < right.size())
                    r = right.get(i);
                else{
                    r = new ArrayList<>();
                    for(int x=0; x<l.size(); ++x){
                        r.add("0");
                    }
                }
                if(r.size() < l.size()){
                    for(int x=0; x<(l.size()-1)/2; ++x){
                        r.add(0,"0");
                    }
                    for(int x=0; x<(l.size()-1)/2; ++x){
                        r.add("0");
                    }
                }
                List<String> com = new ArrayList<>();
                com.addAll(l);
                com.add("0");
                com.addAll(r);
                list.add(com);
            }
        }
        return list;
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
