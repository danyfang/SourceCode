//Leetcode problem 352 Data Stream as Disjoint Intervals
//Solution written by Xuqiang Fang on 5 June, 2018
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

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
class SummaryRanges {
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>(); 
    }
    
    public void addNum(int val) {
         
    }
    
    public List<Interval> getIntervals() {
        
    }
    private TreeMap<Integer, Interval> map;
}

public class {
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
