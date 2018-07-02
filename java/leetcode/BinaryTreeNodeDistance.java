//Leetcode problem  863 All Nodes Distance K in Binary Tree
//Solution written by Xuqiang Fang on 1 Junly, 2018
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.left != null){
                q.offer(n.left);
                if(!map.containsKey(n)){
                    map.put(n, new ArrayList<>());
                }
                map.get(n).add(n.left);
                if(!map.containsKey(n.left)){
                    map.put(n.left, new ArrayList<>());
                }
                map.get(n.left).add(n);
            }
            if(n.right != null){
                q.offer(n.right);
                if(!map.containsKey(n)){
                    map.put(n, new ArrayList<>());
                }
                map.get(n).add(n.right);
                if(!map.containsKey(n.right)){
                    map.put(n.right, new ArrayList<>());
                }
                map.get(n.right).add(n);
            }
        }
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(TreeNode node : map.get(target)){
            System.out.println(node.val);
        }
        dfs(set, target, map, K); 
        ans.addAll(set);
        return ans;
    }
    private void dfs(Set<Integer> ans, TreeNode t, Map<TreeNode, List<TreeNode>> m, int K){
        if(K == 0){
            ans.add(t.val);
            return;
        }
        if(!m.containsKey(t)){
            return;
        }
        for(TreeNode n : m.get(t)){
            m.get(n).remove(t);//this removing step needs to search through the list, we can use a set
            //but test on OJ shows this version is faster
            dfs(ans, n, m, K-1);
        }
    }

    public List<Integer> distanceK_(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.left != null){
                q.offer(n.left);
                if(!map.containsKey(n)){
                    map.put(n, new HashSet<>());
                }
                map.get(n).add(n.left);
                if(!map.containsKey(n.left)){
                    map.put(n.left, new HashSet<>());
                }
                map.get(n.left).add(n);
            }
            if(n.right != null){
                q.offer(n.right);
                if(!map.containsKey(n)){
                    map.put(n, new HashSet<>());
                }
                map.get(n).add(n.right);
                if(!map.containsKey(n.right)){
                    map.put(n.right, new HashSet<>());
                }
                map.get(n.right).add(n);
            }
        }
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        dfs_(set, target, map, K); 
        ans.addAll(set);
        return ans;
    }
    private void dfs_(Set<Integer> ans, TreeNode t, Map<TreeNode, Set<TreeNode>> m, int K){
        if(K == 0){
            ans.add(t.val);
            return;
        }
        if(!m.containsKey(t)){
            return;
        }
        for(TreeNode n : m.get(t)){
            m.get(n).remove(t);
            dfs_(ans, n, m, K-1);
        }
    }
}

public class BinaryTreeNodeDistance{
	public static void main(String[] args){
		Solution s = new Solution();
        TreeNode r = new TreeNode(3);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(0);
        TreeNode f = new TreeNode(8);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(4);
        r.left = a;
        r.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        d.left = g;
        d.right = h;
        System.out.println(s.distanceK(r, a, 2));
        System.out.println(s.distanceK_(r, a, 2));
	}
}
