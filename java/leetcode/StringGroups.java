//Leetcode problem 839 Similar String Groups
//Solution written by Xuqiang Fang on 20 May, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
class Solution{
    //TLE
    public int numSimilarGroup(String[] A){
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<A.length; ++i){
            map.put(A[i], i);
        }
        List<Integer>[] parents = new ArrayList[A.length];
        //in the begining, everyone is its parent itself
        for(int i=0; i<parents.length; ++i){
            parents[i] = new ArrayList<>();
            parents[i].add(i);
        }
        /*
        for(String key : map.keySet()){
            System.out.println(key + map.get(key));
        }
        */
        for(int i=0; i<A.length; ++i){
            Set<String> set = isSimilar(A[i], map);
            if(set.size() > 0){
                for(String s : set){
                    int value = map.get(s);  
                    parents[i].add(value);
                    parents[value].add(i);
                }
            }
        }
        for(int i=0; i<parents.length; ++i){
            System.out.println(parents[i]);
        }
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<parents.length; ++i){
            if(!visited.contains(i)){
                dfs(parents, i, visited);
                count++;
            } 
        }

        return count;
    }

    private Set<String> isSimilar(String s, Map<String, Integer> map){
        StringBuilder sb = new StringBuilder(s);
        Set<String> set = new HashSet<>();
        for(int i=0; i<s.length(); ++i){
            for(int j=i+1; j<s.length(); ++j){
                char c = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, c);
                //It's import to notice that a string is not considered as similar to itself
                if(!sb.toString().equals(s) && map.containsKey(sb.toString()))
                    set.add(sb.toString());
                sb.setCharAt(j, sb.charAt(i));
                sb.setCharAt(i, c);
            }
        }
        return set;
    }
    private void dfs(List<Integer>[] parents, int node, Set<Integer> visited){
        List<Integer> neighbor = parents[node];
        visited.add(node);
        for(int n : neighbor){
            if(!visited.contains(n)){
                dfs(parents, n, visited);
            }
        }
    }



    //we should compare two strings directly to see if they are similar, O(n^2)
    //accepted, yeah!
    public int numSimilarGroups(String[] A){
        if(A.length == 0){
            return 0;
        }
        int N = A.length;
        List<Integer>[] graph = new ArrayList[N];
        for(int i=0; i<A.length; ++i){
            if(graph[i] == null){
                graph[i] = new ArrayList<>();
            }
            for(int j=0; j<A.length; ++j){
                if(graph[j] == null){
                    graph[j] = new ArrayList<>();
                }
                if(i != j && similar(A[i], A[j])){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<N; ++i){
            if(!visited.contains(i)){
                group(graph, i, visited);
                count++;
            }
        }

        return count;
    }

    private boolean similar(String a, String b){
        // a and b are anagrams
        int count = 0;
        for(int i=0; i<a.length(); ++i){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        return count == 2;
    }

    private void group(List<Integer>[] graph, int node, Set<Integer> visited){
        visited.add(node);
        for(int i : graph[node]){
            if(!visited.contains(i)){
                group(graph, i, visited);
            }
        }
    }
}

public class StringGroups{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] A = {"tars","rats","arts","star"};
        String[] B = {"zqz","zzq"};
        String[] C = {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};
        System.out.println(s.numSimilarGroups(A));
        System.out.println(s.numSimilarGroups(B));
        System.out.println(s.numSimilarGroups(C));
	}
}
