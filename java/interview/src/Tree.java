import java.util.*;

public class Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int v){
            this.val = v;
        }
        public TreeNode() {}
        public TreeNode(int v, TreeNode l, TreeNode r) {
            this.val = v;
            this.left = l;
            this.right = r;
        }
    }

    //TreeConstructor [1,2,3,4,5]
    public static TreeNode constructTree(List<Integer> l){
        if (l == null || l.size() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode head = new TreeNode(l.get(index++));
        queue.offer(head);
        while(!queue.isEmpty()) {
            TreeNode h = queue.poll();
            if (h == null || index >= l.size()) {
                continue;
            }
            if(l.get(index) != null) {
                TreeNode left = new TreeNode(l.get(index));
                h.left = left;
                queue.offer(left);
            } else {
                queue.offer(null);
            }
            index++;
            if (index >= l.size()) {
                continue;
            }
            if(l.get(index) != null) {
                TreeNode right = new TreeNode(l.get(index));
                h.right = right;
                queue.offer(right);
            } else {
                queue.offer(null);
            }
            index++;
        }
        return head;
    }

    // Traversal : preorder
    public List<Integer> preorder(List<Integer> l, TreeNode h){
        if (h == null) {
            return l;
        }
        l.add(h.val);
        System.out.println("Node: "+ h.val);
        preorder(l, h.left);
        preorder(l, h.right);
        return l;
    }

    // Traversal: inorder
    public List<Integer> inorder(List<Integer> l, TreeNode h){
        if (h == null) {
            return null;
        }
        inorder(l, h.left);
        l.add(h.val);
        System.out.println("Node: " + h.val);
        inorder(l, h.right);
        return l;
    }

    // Traversal: postorder
    public List<Integer> postorder(List<Integer> l, TreeNode h){
        if (h == null) {
            return null;
        }
        postorder(l, h.left);
        postorder(l, h.right);
        l.add(h.val);
        System.out.println("Node: " + h.val);
        return l;
    }

    public int bstTopo(TreeNode head){
        if (head == null) {
            return 0;
        }
        int max = maxTopo(head, head);
        max = Math.max(max, bstTopo(head.left));
        max = Math.max(max, bstTopo(head.right));
        return max;
    }
    private int maxTopo(TreeNode h, TreeNode n) {
        if ( h!= null && n != null && isBstNode(h, n, n.val)) {
            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
        }
        return 0;
    }
    private boolean isBstNode(TreeNode h, TreeNode n, int v){
        if (h == null) {
            return false;
        }
        if (h == n) {
            return true;
        }
        return isBstNode(h.val > v ? h.left : h.right, n, v);
    }


    /*
    * Binary tree max path sum
    * For each node there can be four ways that the max path goes through the node:
    * 1. Node only
    * 2. Max path through Left Child + Node
    * 3. Max path through Right Child + Node
    * 4. Max path through Left Child + Node + Max path through Right Child
    * */

    public int maxPathSum(TreeNode root){
        int ans[] = new int[1];
        ans[0] = Integer.MIN_VALUE;
        calculateSum(root, ans);
        return ans[0];
    }

    private int calculateSum(TreeNode root, int[] ans){
        if (root == null){
            return 0;
        }
        int l = calculateSum(root.left, ans);
        int r = calculateSum(root.right, ans);
        int current = Math.max(root.val, Math.max(l+root.val, r+root.val));// case 1,2,3
        ans[0] = Math.max(ans[0], Math.max(current, l + r + root.val));// case 4

        return current;
    }

    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxDepth = 0;
        map.put(maxDepth, root.val);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            maxDepth++;
            int n = q.size();
            for(int x=0; x<n; ++x){
                TreeNode r = q.poll();
                if(r.left != null) {
                    q.offer(r.left);
                    map.put(maxDepth, map.getOrDefault(maxDepth, 0)+r.left.val);
                }
                if(r.right != null) {
                    q.offer(r.right);
                    map.put(maxDepth, map.getOrDefault(maxDepth, 0)+r.right.val);
                }
            }
        }
        return map.get(--maxDepth);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, 0, sum);
    }

    private boolean hasPathSumHelper(TreeNode root, int current, int sum) {
        if(root.val + current == sum && root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && hasPathSumHelper(root.left, root.val+current, sum)) {
            return true;
        }
        if (root.right != null && hasPathSumHelper(root.right, root.val+current, sum)) {
            return true;
        }
        return false;
    }
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ans = new int[1];
        goodNodesHelper(root, root.val, ans);
        return ans[0];
    }
    private void goodNodesHelper(TreeNode root, int max, int[] ans) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            max = root.val;
            ans[0]++;
        }
        goodNodesHelper(root.left, max, ans);
        goodNodesHelper(root.right, max, ans);
    }

    public int countPairs(TreeNode root, int distance) {
        int[] ans = new int[1];
        countPairsHelper(root, ans, distance);
        return ans[0];
    }

    private List<Integer> countPairsHelper(TreeNode root, int[] v, int distance) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            ans.add(1);
            return ans;
        }
        List<Integer> left = countPairsHelper(root.left, v, distance);
        List<Integer> right = countPairsHelper(root.right, v, distance);
        for (int x : left) {
            for (int y : right) {
                if (x + y <= distance) {
                    v[0]++;
                }
            }
        }
        for (int i=0; i<left.size(); ++i) {
            ans.add(left.get(i)+1);
        }
        for (int i=0; i<right.size(); ++i) {
            ans.add(right.get(i)+1);
        }
        return ans;
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getTargetCopyHelper(cloned, target);
    }
    private TreeNode getTargetCopyHelper(TreeNode cloned, TreeNode target) {
        if (cloned == null || (cloned.left == null && cloned.right == null && cloned.val != target.val)) {
            return null;
        }
        if (cloned.val == target.val) {
            return cloned;
        }

        TreeNode left = getTargetCopyHelper(cloned.left, target);
        return left == null ? getTargetCopyHelper(cloned.right, target) : left;
    }

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int ans = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    ans += root.left.left.val;
                }
                if (root.left.right != null) {
                    ans += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    ans += root.right.left.val;
                }
                if (root.right.right != null) {
                    ans += root.right.right.val;
                }
            }
        }
        ans += sumEvenGrandparent(root.left);
        ans += sumEvenGrandparent(root.right);
        return ans;
    }

    class FindElements {
        private HashSet<Integer> set;
        public FindElements(TreeNode root) {
            set = new HashSet<>();
            if (root == null) {
                return;
            }
            helper(root, 0);
        }

        public boolean find(int target) {
            return set.contains(target);
        }

        private void helper(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            root.val = val;
            set.add(val);
            helper(root.left, 2 * val + 1);
            helper(root.right, 2 * val + 2);
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorderTraversal(root, l);
        return reconstructTree(l);
    }

    private void inorderTraversal(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, l);
        l.add(root.val);
        inorderTraversal(root.right, l);
    }

    private TreeNode reconstructTree(List<Integer> l) {
        if (l.size() == 0) {
            return null;
        }
        if (l.size() == 1) {
            return new TreeNode(l.get(0));
        }
        int n = l.size() / 2;
        List<Integer> left = l.subList(0, n);
        List<Integer> right = l.subList(n+1, l.size());
        TreeNode root = new TreeNode(l.get(n));
        root.left = reconstructTree(left);
        root.right = reconstructTree(right);
        return root;
    }
}

