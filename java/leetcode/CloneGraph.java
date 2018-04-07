//Leetcode problem 133 Clone Graph
//Solution written by Xuqiang Fang on 6 April, 2018 
//Nodes are labeled uniquely
import java.util.List;
import java.util.ArrayList;

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

        return null;
    }	
}

public class CloneGraph{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
