//Leetcode problem 895 Maximum Frequency Stack
//Solution written by Xuqiang Fang on 26 Aug, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class FreqStack {
    List<Integer>[] array;
    Map<Integer, Integer> map;
    int f;
    public FreqStack() {
        array = new ArrayList[10001];
        map = new HashMap<>();
        f = 0;
    }
    
    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0)+1);
        int v = map.get(x);
        f = Math.max(f, v);
        if(array[v] == null){
            array[v] = new ArrayList<>();
        }
        array[v].add(x);
        //System.out.println(f);
    }
    
    public int pop() {
        List<Integer> l = array[f];
        int ans = -1;
        if(l.size() > 0){
            ans = l.remove(l.size()-1);
        }
        while(f > 0 && l.size() == 0){
            f--;
            l = array[f];
        }
        return ans;
    }
}
public class FrequencyStack{
	public static void main(String[] args){
        FreqStack s = new FreqStack();
        s.push(4);
        s.push(0);
        s.push(9);
        s.push(3);
        s.push(4);
        s.push(2);
        System.out.println(s.pop());
        s.push(6);
        System.out.println(s.pop());
        s.push(1);
        System.out.println(s.pop());
        s.push(1);
        System.out.println(s.pop());
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
	}
}
