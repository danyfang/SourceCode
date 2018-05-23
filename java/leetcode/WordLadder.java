//Leetcode problem 127 Word Ladder
//Leetcode problem 126 Word Ladder II
//Solution written by Xuqiang Fang on 22 May, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
class Solution{
    //Q 127
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(); 
        dict.addAll(wordList);
        if(!dict.contains(endWord)){
            return 0;
        }
        int len = beginWord.length();
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        int step = 0;

        while(!begin.isEmpty() && !end.isEmpty()){
            ++step;
            //always search in the smaller set
            if(begin.size() > end.size()){
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            Set<String> temp = new HashSet<>();
            for(String word : begin){
                StringBuilder sb = new StringBuilder(word);
                for(int i=0; i<len; ++i){
                    char c = word.charAt(i);
                    for(int j=0; j<26; ++j){
                        sb.setCharAt(i, (char)('a'+j));
                        if(end.contains(sb.toString())){
                            return ++step;
                        }
                        else if(!dict.contains(sb.toString())){
                            continue;
                        }
                        temp.add(sb.toString());
                        dict.remove(sb.toString());
                    }
                    sb.setCharAt(i, c);
                }
            }
            begin = temp;
        }
        return 0;
    }
    
    

    // Q 126
    //general idea: use bfs to build path graph and then use dfs to find the path
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        List<List<String>>  res = new ArrayList<>();
        if(!dict.contains(endWord)){
            return res;
        }
        dict.remove(endWord);
        if(dict.contains(beginWord)){
            dict.remove(beginWord);
        }

        Map<String, Integer> steps = new HashMap<>();
        /**steps map records the number of steps it takes from beginWord to current word,
        it can also help prune those paths which are longer than already found one*/
        steps.put(beginWord, 1);

        //use a map to build an adjacency list graph
        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int step = 0;
        boolean found = false;

        while(!q.isEmpty() && !found){
            ++step;
            for(int size = q.size(); size > 0; size--){
                String p = q.poll();
                StringBuilder w = new StringBuilder(p);
                for(int i=0; i<w.length(); ++i){
                    char c = w.charAt(i);
                    for(int j=0; j<26; ++j){
                        if((char)('a'+j) == c){
                            continue;
                        }
                        w.setCharAt(i, (char)('a'+j));
                        if(w.toString().equals(endWord)){
                            if(!parents.containsKey(w.toString())){
                                parents.put(w.toString(), new ArrayList<>());
                            }
                            parents.get(w.toString()).add(p);
                            found = true;
                        }
                        else{
                            /**This line is important because one word may have several parents*/
                            if(steps.containsKey(w.toString()) && step < steps.get(w.toString())){
                                parents.get(w.toString()).add(p);
                            }
                        }

                        if(!dict.contains(w.toString())){
                            continue;
                        }
                        dict.remove(w.toString());
                        q.offer(w.toString());
                        steps.put(w.toString(), steps.get(p)+1);
                        if(!parents.containsKey(w.toString())){
                            parents.put(w.toString(), new ArrayList<>());
                        }
                        parents.get(w.toString()).add(p);
                    }
                    w.setCharAt(i, c);
                }
            }
        }

        if(found){
            //debug, print all elements in parents graph
            /**
            for(String key : parents.keySet()){
                System.out.print(key + ": ");
                System.out.println(parents.get(key));
            }
            */
            List<String> t = new ArrayList<>();
            t.add(endWord);
            path(res, parents, beginWord, t, endWord); 
        }
        return res;
    }
    
    private void path(List<List<String>> res, Map<String,List<String>> parents,String b,List<String>t, String w){
        if(w.equals(b)){
            //t.add(w);
            List<String> tmp = new ArrayList<>(t);
            Collections.reverse(tmp);
            res.add(tmp);
            return;
        }
        for(String s : parents.get(w)){
            t.add(s);
            path(res, parents, b, t, s);
            t.remove(s);
        }
    }




    //single source all destinations, shortest path
    //TLE
    /**The reason for TLE is because this algorithm spends too much time building the graph*/
    public List<List<String>> findLadder(String beginWord, String endWord, List<String> wordList) {
        List<List<String>>  res = new ArrayList<>();
        if(!wordList.contains(endWord)){
            return res;
        }
        if(!wordList.contains(beginWord)){
            List<String> wordList_copy = new ArrayList<>();
            wordList_copy.add(beginWord);
            wordList_copy.addAll(wordList);
            wordList = wordList_copy;
        }
        List<Integer>[] graph = new ArrayList[wordList.size()];
        for(int i=0; i<wordList.size(); ++i){
            for(int j=i+1; j<wordList.size(); ++j){
                if(neighbor(wordList.get(i), wordList.get(j))){
                    if(graph[i] == null){
                        graph[i] = new ArrayList<>(); 
                    }
                    graph[i].add(j);
                    if(graph[j] == null){
                        graph[j] = new ArrayList<>();
                    }
                    graph[j].add(i);
                }
            }
        }
        //endWord has no neighbors
        int endIndex = wordList.indexOf(endWord);
        if(graph[endIndex] == null){
            return res;
        }
        int beginIndex = wordList.indexOf(beginWord);
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        Set<Integer> visited = new HashSet<>();
        visited.add(beginIndex);
        dfs(res, graph, wordList, temp, endWord, visited, beginIndex);
        return res;

    }
    private int maxLength = Integer.MAX_VALUE;
    private void dfs(List<List<String>> res,List<Integer>[] graph, List<String> wordList,
                    List<String> temp,String end,Set<Integer> visited,int beginIndex){
        if(temp.get(temp.size()-1).equals(end)){
            if(temp.size() < maxLength){
                res.clear();
                res.add(new ArrayList<>(temp));
                maxLength = temp.size();
            }
            else if(temp.size() == maxLength){
                res.add(new ArrayList<>(temp));
            }
            return;
        } 

        List<Integer> next = graph[beginIndex];
        for(int n: next){
            if(visited.contains(n)){
                continue;
            }
            visited.add(n);
            temp.add(wordList.get(n));
            dfs(res, graph, wordList, temp, end, visited, n);
            visited.remove(n);
            temp.remove(wordList.get(n));
        }
    }

    private boolean neighbor(String a, String b){
        int count = 0;
        for(int i=0; i<a.length(); ++i){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}

public class WordLadder{
	public static void main(String[] args){
		Solution s = new Solution();
        //String b = "hit";
        //String e = "cog";
        //List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String b = "red";
        String e = "tax";
        List<String> wordList = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        //System.out.println(s.ladderLength(b, e, wordList));
        System.out.println(s.findLadders(b, e, wordList));
	}
}
