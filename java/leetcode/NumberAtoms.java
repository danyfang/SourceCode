//Leetcode problem 726 Number of Atoms
//Solution written by Xuqiang Fang on 2 July, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Element{
    String string;
    int count;
    Element(String s, int c){
        string = s;
        count = c;
    }
}
class Solution{
    public String countOfAtoms(String f) {
        Map<String, Integer> ans = new TreeMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<f.length(); ++i){
            if(f.charAt(i) == '('){
                stack.push(i);
            }
            else if(f.charAt(i) == ')'){
                if(stack.size() == 1){
                    int j = i+1;
                    while(j < f.length() && f.charAt(j) >= '0' && f.charAt(j) <= '9'){
                        ++j;
                    }
                    int count = 1;
                    if(j > i+1){
                        count = Integer.parseInt(f.substring(i+1, j));
                    }
                    Map<String, Integer> temp = get(countOfAtoms(f.substring(stack.peek()+1, i)));
                    stack.push(j);
                    for(String k : temp.keySet()){
                        if(!ans.containsKey(k)){
                            ans.put(k, count * temp.get(k));
                        } 
                        else{
                            ans.put(k, count * temp.get(k) + ans.get(k));
                        }
                    }
                } 
                else if(stack.size() > 1){
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            ans = get(f);
        }
        else{
            int r = stack.pop();
            if(r < f.length()){
                String right = f.substring(r);
                Map<String, Integer> temp = get(countOfAtoms(right));
                for(String k : temp.keySet()){
                    if(!ans.containsKey(k)){
                        ans.put(k, temp.get(k));
                    } 
                    else{
                        ans.put(k, temp.get(k) + ans.get(k));
                    }
                }
            }
            int l = stack.pop();
            if(l > 0){
                String left = f.substring(0, l);
                Map<String, Integer> temp = get(countOfAtoms(left));
                for(String k : temp.keySet()){
                    if(!ans.containsKey(k)){
                        ans.put(k, temp.get(k));
                    } 
                    else{
                        ans.put(k, temp.get(k) + ans.get(k));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String k : ans.keySet()){
            //System.out.println(k + " " + ans.get(k));
            sb.append(k);
            if(ans.get(k) > 1){
                sb.append(ans.get(k));
            }
        }
        return sb.toString(); 
    }
    private Map<String, Integer> get(String f){
        Map<String, Integer> map = new TreeMap<>();
        for(int i=0; i<f.length(); ++i){
            if(f.charAt(i) >= 'A' && f.charAt(i) <= 'Z'){
                Element e = helper(f, i);
                if(!map.containsKey(e.string)){
                    map.put(e.string, e.count);
                }
                else{
                    map.put(e.string, map.get(e.string)+e.count);
                }
            }
        } 
        return map;
    }
    private Element helper(String f, int i){
        int j = i+1;
        while(j < f.length() && f.charAt(j) >= 'a' && f.charAt(j) <= 'z'){
            j++; 
        }
        String string = f.substring(i, j);
        i = j;
        while(j < f.length() && f.charAt(j) >= '0' && f.charAt(j) <= '9'){
            j++;
        }
        int count = 1;
        if(j-i >= 1){
            count = Integer.parseInt(f.substring(i,j));
        }
        return new Element(string, count);
    }
}

public class NumberAtoms{
	public static void main(String[] args){
		Solution s = new Solution();
        String f = "K4(ON(SO3)2)2";
        System.out.println(f);
        System.out.println(s.countOfAtoms(f));
        f = "H2MgO2";
        System.out.println(s.countOfAtoms(f));
	}
}
