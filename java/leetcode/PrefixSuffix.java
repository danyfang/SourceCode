//Leetcode problem 745 Prefix and Suffix Search
//Solution written by Xuqiang Fang on 31 Aug, 2018
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
class WordFilter {
    Map<String, List<Integer>> pre;
    Map<String, List<Integer>> suf;
    public WordFilter(String[] words) {
        pre = new HashMap<>();
        suf = new HashMap<>();
        int n = words.length;
        for(int i=0; i<n; ++i){
            for(int j=0; j<=words[i].length(); ++j){
                String p = words[i].substring(0, j);
                if(!pre.containsKey(p)){
                    pre.put(p, new ArrayList<>());
                }
                pre.get(p).add(i);
                String s = words[i].substring(words[i].length()-j);
                if(!suf.containsKey(s)){
                    suf.put(s, new ArrayList<>());
                }
                suf.get(s).add(i);
            }
        }
        for(String k : pre.keySet()){
            System.out.println(k + pre.get(k)); 
        }
    }
    
    public int f(String p, String s) {
        if(!pre.containsKey(p) || !suf.containsKey(s)){
            return -1;
        } 
        List<Integer> x = pre.get(p);
        List<Integer> y = suf.get(s);
        int i = x.size()-1;
        int j = y.size()-1;
        while(i >= 0 && j >=0){
            if(x.get(i).equals(y.get(j))){
                return x.get(i);
            }
            else if(x.get(i) > y.get(j)){
                --i;
            }
            else{
                --j;
            }
        }
        return -1;
    }
}

public class PrefixSuffix{
	public static void main(String[] args){
        String[] words = {"apple", "tree"};
		WordFilter s = new WordFilter(words);
        System.out.println(s.f("a", "e"));
        System.out.println(s.f("b", "e"));
        System.out.println(s.f("tr", "e"));
        words = new String[]{"a", "a", "a", "a"};
        s = new WordFilter(words);
        System.out.println(s.f("a", "a"));
	}
}
