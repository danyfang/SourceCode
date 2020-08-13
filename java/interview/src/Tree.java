import javax.swing.tree.TreeNode;
import java.util.*;

public class Tree {
    public class Node{
        int v;
        Node l;
        Node r;
        public Node(int v){
            this.v = v;
        }
    }

    //TreeConstructor [1,2,3,4,5]
    public Node constructTree(List<Integer> l){
        if (l == null || l.size() == 0) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        int index = 0;
        Node head = new Node(l.get(index++));
        queue.offer(head);
        while(!queue.isEmpty()) {
            Node h = queue.poll();
            if (h == null || index >= l.size()) {
                continue;
            }
            if(l.get(index) != null) {
                Node left = new Node(l.get(index));
                h.l = left;
                queue.offer(left);
            } else {
                queue.offer(null);
            }
            index++;
            if (index >= l.size()) {
                continue;
            }
            if(l.get(index) != null) {
                Node right = new Node(l.get(index));
                h.r = right;
                queue.offer(right);
            } else {
                queue.offer(null);
            }
            index++;
        }
        return head;
    }

    // Traversal : preorder
    public List<Integer> preorder(List<Integer> l, Node h){
        if (h == null) {
            return l;
        }
        l.add(h.v);
        System.out.println("Node: "+ h.v);
        preorder(l, h.l);
        preorder(l, h.r);
        return l;
    }

    // Traversal: inorder
    public List<Integer> inorder(List<Integer> l, Node h){
        if (h == null) {
            return null;
        }
        inorder(l, h.l);
        l.add(h.v);
        System.out.println("Node: " + h.v);
        inorder(l, h.r);
        return l;
    }

    // Traversal: postorder
    public List<Integer> postorder(List<Integer> l, Node h){
        if (h == null) {
            return null;
        }
        postorder(l, h.l);
        postorder(l, h.r);
        l.add(h.v);
        System.out.println("Node: " + h.v);
        return l;
    }

    public int bstTopo(Node head){
        if (head == null) {
            return 0;
        }
        int max = maxTopo(head, head);
        max = Math.max(max, bstTopo(head.l));
        max = Math.max(max, bstTopo(head.r));
        return max;
    }
    private int maxTopo(Node h, Node n) {
        if ( h!= null && n != null && isBstNode(h, n, n.v)) {
            return maxTopo(h, n.l) + maxTopo(h, n.r) + 1;
        }
        return 0;
    }
    private boolean isBstNode(Node h, Node n, int v){
        if (h == null) {
            return false;
        }
        if (h == n) {
            return true;
        }
        return isBstNode(h.v > v ? h.l : h.r, n, v);
    }


    /*
    * Binary tree max path sum
    * For each node there can be four ways that the max path goes through the node:
    * 1. Node only
    * 2. Max path through Left Child + Node
    * 3. Max path through Right Child + Node
    * 4. Max path through Left Child + Node + Max path through Right Child
    * */

    public int maxPathSum(Node root){
        int ans[] = new int[1];
        ans[0] = Integer.MIN_VALUE;
        calculateSum(root, ans);
        return ans[0];
    }

    private int calculateSum(Node root, int[] ans){
        if (root == null){
            return 0;
        }
        int l = calculateSum(root.l, ans);
        int r = calculateSum(root.r, ans);
        int current = Math.max(root.v, Math.max(l+root.v, r+root.v));// case 1,2,3
        ans[0] = Math.max(ans[0], Math.max(current, l + r + root.v));// case 4

        return current;
    }
}

