//Leetcode problem 558 Quad Tree Intersection
//Solution written by Xuqiang Fang on 25 July, 2018
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
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
class Solution{
    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1.isLeaf && quadTree1.val){
            return quadTree1;
        } 
        else if(quadTree2.isLeaf && quadTree2.val){
            return quadTree2;
        }
        else if(quadTree1.isLeaf && quadTree2.isLeaf){
            boolean tmp = quadTree1.val || quadTree2.val;
            quadTree1.val = tmp;
            return quadTree1;
        }
        else if(quadTree1.isLeaf){
            return quadTree2;
        }
        else if(quadTree2.isLeaf){
            return quadTree1;
        }
        Node _topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node _topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node _bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node _bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        Node ans = new Node(false, false, _topLeft, _topRight, _bottomLeft, _bottomRight);
        if(_topLeft.isLeaf && _topRight.isLeaf && _bottomLeft.isLeaf && _bottomRight.isLeaf
            && _topLeft.val == _topRight.val 
            && _topLeft.val == _bottomLeft.val && _topLeft.val == _bottomRight.val){
            ans.isLeaf = true;
            ans.val = _topLeft.val;
            ans.topLeft = null;
            ans.topRight = null;
            ans.bottomLeft = null;
            ans.bottomRight = null;
        }
        return ans;
    }
}

public class QuadTreeIntersection{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
