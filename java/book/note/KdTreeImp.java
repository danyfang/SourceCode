/*
* KdTree, two dimensional tree
*/

class KdTree<T extends Comparable>{
    public KdTree(){
        root = null;
    }
    public void insert(T[] x){
        if(root == null){
            root = new KdNode(x);
        }
        else{
            insert(x, root, 0); 
        }
    }
    public void printRange(T[] low, T[] high){
        printRange(low, high, root, 0);
    }

    private void insert(T[] x, KdNode t, int level){
        if(x[level].compareTo(t.data[level]) < 0){
            if(t.left == null){
                t.left = new KdNode(x);
            }
            else{
                insert(x, t.left, 1-level);
            }
        }
        else{
            if(t.right == null){
                t.right = new KdNode(x);
            }
            else{
                insert(x, t.right, 1-level);
            }
        }
    }
    private void printRange(T[] low, T[] high, KdNode t, int level){
        if(t != null){
            if(low[0].compareTo(t.data[0]) <= 0 && high[0].compareTo(t.data[0]) >= 0
                && low[1].compareTo(t.data[1]) <= 0 && high[1].compareTo(t.data[1]) >= 0){
                System.out.println("[" + t.data[0] + "," + t.data[1] + "]");        
            }
            if(low[level].compareTo(t.data[level]) <= 0){
                printRange(low, high, t.left, 1-level);
            }
            if(high[level].compareTo(t.data[level]) >= 0){
                printRange(low, high, t.right, 1-level);
            }
        }
    }
    private class KdNode{
        T[] data;
        KdNode left;
        KdNode right;

        KdNode(T[] item){
            data = item;
            left = null;
            right = null;
        }
    }
    KdNode root;
}

public class KdTreeImp{
    public static void main(String[] args){
        KdTree<Integer> tree = new KdTree<>();
        for(int i=300; i<370; ++i){
            Integer[] it = new Integer[]{i, 2500-i};
            tree.insert(it);
        }
        Integer[] low = {70, 2186};
        Integer[] high = {1200, 2200};
        tree.printRange(low, high);
    }
}
