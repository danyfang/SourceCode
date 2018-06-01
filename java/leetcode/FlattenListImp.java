//Leetcode problem 341 Flatten Nested List Iterator
//Solution written by Xuqiang Fang on 31 May, 2018
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
import java.util.Iterator;
interface NestedInteger{
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
class NestedIterator implements Iterator<Integer>, NestedInteger {
    @Override
    public boolean isInteger(){
        return false;
    }
    @Override
    public Integer getInteger(){
        return 0;
    }
    @Override
    public List<NestedInteger> getList(){
        return null;
    }
    public NestedIterator(List<NestedInteger> n) {
        ans = new ArrayList<>();
        c = 0;
        dfs(n);
    }

    private void dfs(List<NestedInteger> n){
        for(int i=0; i<n.size(); ++i){
            if(n.get(i).isInteger()){
                ans.add(n.get(i).getInteger());
            }
            else{
                dfs(n.get(i).getList());
            }
        } 
    }

    @Override
    public Integer next() {
        return ans.get(c++); 
    }

    @Override
    public boolean hasNext() {
        return c < ans.size(); 
    }

    private List<Integer> ans;
    private int c;
}
public class FlattenListImp{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
