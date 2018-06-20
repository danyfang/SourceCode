//Leetcode problem  854 K-Similar Strings
//Solution written by Xuqiang Fang on 18 June, 2018
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
class Solution{
    public int kSimilarity_(String A, String B) {
        if(A.equals(B)){
            return 0;
        }
        int n = A.length();
        if(n == 2){
            return 1;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add(A);
        queue.offer(A);
        int step = 1;
        int t = queue.size();
        int count = 0;
        while(!queue.isEmpty()){
            --t;
            String a = queue.poll();
            //System.out.println("a = " + a);
            for(int i=0; i<n; ++i){
                int c = 0;
                if(a.charAt(i) != B.charAt(i)){
                    for(int j=i+1; j<n; ++j){
                        if(B.charAt(i) == a.charAt(j) && a.charAt(j) != B.charAt(j)){
                            StringBuilder sb = new StringBuilder(a);
                            sb.setCharAt(i, a.charAt(j));
                            sb.setCharAt(j, a.charAt(i));
                            if(sb.toString().equals(B)){
                                System.out.println("search " + count + " times");
                                return step;
                            }
                            /*
                            else if(B.charAt(j) == a.charAt(i)){
                            // here we find a better match, throw 
                            //previous match away
                                why can we prune here,
                                it is breadth first, so when we find a perfect match, we must make use of it
                                queue.clear();
                                t = 0;
                                queue.offer(sb.toString());
                            }
                            */
                            else{
                                if(!set.contains(sb.toString())){
                                    queue.offer(sb.toString());
                                }
                                count++;
                                c++;
                               //System.out.println("here");
                            }
                        }
                    }
                    break;
                }
            }
            if(t == 0){
                t = queue.size();
                step++;
            }
        }
        return step;
    }


    //another faster method
    public int kSimilarity(String A, String B){
        if(A.equals(B)){
            return 0;
        }
        int n = A.length();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        set.add(A);
        queue.offer(A);
        int step = 0;
        while(!queue.isEmpty()){
            step++;
            for(int t=queue.size(); t>0; --t){
                String a = queue.poll();
                int i = 0;
                while(a.charAt(i) == B.charAt(i)){
                    ++i;
                }
                for(int j=i+1; j<n; ++j){
                    if(a.charAt(j) == B.charAt(i) && a.charAt(j) != B.charAt(j)){
                        StringBuilder sb = new StringBuilder(a);
                        sb.setCharAt(i, a.charAt(j));
                        sb.setCharAt(j, a.charAt(i));
                        String tmp = sb.toString();
                        if(tmp.equals(B)){
                            return step;
                        }
                        else if(!set.contains(tmp)){
                            queue.offer(tmp);
                            set.add(tmp);
                        }
                    }
                }
            }
        }
        throw null;
    }
}

public class SimilarStrings{
	public static void main(String[] args){
		Solution s = new Solution();
        String A = "aabcaabc";
        String B = "abcaabca";
        System.out.println(s.kSimilarity(A, B));
        System.out.println(s.kSimilarity("abcdefgjhijklmnrp", "rnmlkjihpgjfedcba"));
        System.out.println(s.kSimilarity("abcdkefgjhlmnjrpqio", "rnmlkjpihqgjfoedcba"));
        System.out.println(s.kSimilarity("abc", "bca"));
        System.out.println(s.kSimilarity("aabbccddee","cbeddebaac"));
        System.out.println(s.kSimilarity("abccaacceecdeea", "bcaacceeccdeaae"));
	}
}
