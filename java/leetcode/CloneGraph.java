//Leetcode problem 133 Clone Graph
//Solution written by Xuqiang Fang on 6 April, 2018 
//Nodes are labeled uniquely
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

class UndirectedGraphNode{
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x){
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
class Solution{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        Set<UndirectedGraphNode> set = new HashSet<>();
        String s = serialization(node, set);
        System.out.println(s);
        UndirectedGraphNode result = deserialization(s);
        return result;
    }	
    public UndirectedGraphNode deserialization(String s){
        int lab = Integer.MAX_VALUE;
        String[] str = s.split("#"); 
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        for(String st : str){
            int label = Integer.valueOf(st.substring(0,1));
            UndirectedGraphNode temp = new UndirectedGraphNode(label);
            map.put(label, temp);
        }

        for(String st : str){
            String[] labels = st.split(",");
            lab = Math.min(lab, Integer.valueOf(labels[0]));
            for(int i=1; i<labels.length; ++i){
                map.get(Integer.valueOf(labels[0])).neighbors.add(map.get(Integer.valueOf(labels[i])));
            }
        }

        return map.get(lab);
    }
    public String serialization(UndirectedGraphNode node, Set<UndirectedGraphNode> set){
        //node won't be null
        StringBuilder sb = new StringBuilder(String.valueOf(node.label));
        List<UndirectedGraphNode> list = node.neighbors;
        if(set.contains(node))
            return null;
        else{
            set.add(node);
            for(UndirectedGraphNode n : list){
                if(!set.contains(n) || n == node){
                    sb.append(",");
                    sb.append(String.valueOf(n.label));
                }
            }
        }
        for(UndirectedGraphNode n : list){
            String s = serialization(n, set);
            if(s != null){
                sb.append("#");
                sb.append(s);
            }
        }
        return sb.toString(); 
    }

    public UndirectedGraphNode cG(UndirectedGraphNode node){
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> map){
        if(node == null)
            return null;
        if(map.containsKey(node.label))
            return map.get(node.label);
        else{
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            map.put(node.label, clone);
            for(int i=0; i<node.neighbors.size(); ++i){
                clone.neighbors.add(dfs(node.neighbors.get(i), map));
            }
            return clone;
        }
    }
}

public class CloneGraph{
	public static void main(String[] args){
		Solution s = new Solution();
        UndirectedGraphNode a = new UndirectedGraphNode(0);
        UndirectedGraphNode b = new UndirectedGraphNode(1);
        UndirectedGraphNode c = new UndirectedGraphNode(2);
        UndirectedGraphNode d = new UndirectedGraphNode(4);
        a.neighbors.add(b);
        a.neighbors.add(c);
        b.neighbors.add(a);
        b.neighbors.add(c);
        c.neighbors.add(a);
        c.neighbors.add(b);
        c.neighbors.add(c);
        c.neighbors.add(d);
        UndirectedGraphNode result = s.cloneGraph(a);
        Set<UndirectedGraphNode> set = new HashSet<>();
        System.out.println(s.serialization(result, set));
	}
}
