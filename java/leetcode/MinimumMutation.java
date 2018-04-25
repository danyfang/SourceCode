//Leetcode problem 433 Minimum Genetic Mutation
//Solution written by Xuqiang Fang on 24 April, 2018 
import java.util.HashSet;
import java.util.Set;
class Solution{
    public int minMutation(String start, String end, String[] bank){
        Set<String> set = new HashSet<>();
        for(String s : bank){
            set.add(s);
        }
        if(!set.contains(end)){
            return -1;
        }

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(start);
        q2.add(end);
        char[] ch = {'A','C','G','T'};
        int level = 0;

        while(!q1.isEmpty() && !q2.isEmpty()){
            ++level;

            Set<String> q = new HashSet<>();
            for(String s : q1){
                for(int i=0; i<8; ++i){
                    char original = s.charAt(i);
                    for(int j=0; j<4; ++j){
                        if(original != ch[j]){
                            String w = s.substring(0,i) + ch[j] + s.substring(i+1,8);
                            if(q2.contains(w))
                                return level;
                            if(!set.contains(w))
                                continue;
                            q.add(w);
                        } 
                    } 
                } 
            }
            q1 = q;
        }
        return -1; 
    }	
}

public class MinimumMutation{
	public static void main(String[] args){
		Solution s = new Solution();
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(s.minMutation(start, end, bank));
	}
}
