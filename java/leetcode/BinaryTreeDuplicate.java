//Leetcode problem 652 Find Duplicate Subtrees
//Solution written by Xuqiang Fang on 13 July, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}
class Solution{
    public List<TreeNode> findDuplicateSubtrees_(TreeNode root){
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        dfs(root, map, ans);
        return ans;
    }
    private String dfs(TreeNode root, Map<String, Integer>map, List<TreeNode> ans){
        if(root == null){
            return "#";
        }
        String key = root.val + "," + dfs(root.left, map, ans) + "," + dfs(root.right, map, ans);
        map.put(key, map.getOrDefault(key, 0)+1);
        if(map.get(key) == 2){
            ans.add(root);
        }
        return key;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        //second method
        Map<Long, Integer> ids = new HashMap<>();
        Map<Long, Integer> counts = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        getId(root, ids, counts, ans);
        return ans;
    }
    private long getId(TreeNode root, Map<Long, Integer> ids, Map<Long, Integer> counts, List<TreeNode> ans){
        if (root == null){
            return 0;
        }
        //the basic idea is the same, give each subtree an id and if two subtrees are the same
        //they should have the same id, so the id has to do with node values
        long key = ((long)root.val << 31)|(getId(root.left,ids,counts,ans)<<15)|(getId(root.right,ids,counts, ans));
        int id;
        if (!ids.containsKey(key)){
            int size = ids.size();
            ids.put(key, size+1); 
            id = size + 1;
        }
        else{
            id = ids.get(key);
        }
        counts.put(key, counts.getOrDefault(key, 0) + 1);
        if(counts.get(key) == 2){
            ans.add(root);
        }
        return id;
    }
}

public class BinaryTreeDuplicate{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        root.left = a;
        root.right = b;
        a.left = c;
        b.left = d;
        b.right = e;
        d.left = f;
        List<TreeNode> ans = s.findDuplicateSubtrees(root);
        for(TreeNode t : ans){
            print(t);
        }
	}
    public static void print(TreeNode r){
        if(r != null){
            print(r.left);
            print(r.right);
            System.out.println(r.val);
        }
    }
}
