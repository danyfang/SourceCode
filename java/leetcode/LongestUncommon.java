//Leetcode problem 521 Longest Uncommon Subsequence I
//Leetcode problem 522 Longest Uncommon Subsequence II
//Solution written by Xuqiang Fang on 28 May, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution{
    public int findLUSlength(String a, String b){
        if(a.length() != b.length())
            return Math.max(a.length(), b.length());
        else if(a.equals(b))
            return -1;
        return a.length();
    }	

    //well, sometimes the stupidest idea works
    public int findLUSlength(String[] strs) {
        Map<String, Integer>[] s = new HashMap[11];    
        for(String t : strs){
            if(s[t.length()] == null){
                s[t.length()] = new HashMap<>();
            }
            s[t.length()].put(t, s[t.length()].getOrDefault(t,0)+1);
        }
        for(int i=10; i>=0; --i){
            if(s[i] != null){
                for(String k : s[i].keySet()){
                    if(s[i].get(k) == 1){// it is unique among all strings with the same length
                        if(i == 10){
                            return i;
                        }
                        boolean isSub = false;
                        for(int j=i+1; j<=10; ++j){
                            if(s[j] != null){
                                for(String l : s[j].keySet()){
                                    if(subsequence(k, l)){
                                        isSub = true;
                                        break;
                                    }
                                }
                                if(isSub){
                                    break;
                                }
                            }
                        }
                        if(!isSub){
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean subsequence(String K, String L){
        if(K.length() == 0){
            return true;
        }
        int k = 0, l = 0;
        for(int i=0; i<Math.max(K.length(), L.length()); ++i){
            if(K.charAt(k) == L.charAt(l)){
                k++;
                if(k == K.length()){
                    return true;
                }
            }
            l++;
        }
        return false;
    }
}

public class LongestUncommon{
	public static void main(String[] args){
		Solution s = new Solution();
        //System.out.println(s.subsequence("", "abcddefgs"));
        //System.out.println(s.subsequence("abcd", "abcddefgs"));
        //System.out.println(s.subsequence("ddefgss", "abcddefgs"));
        String[] strs = {"aba", "cdc", "eae"};
        String[] str = {"aaa","aaa","aa"};
        System.out.println(s.findLUSlength(strs));
        System.out.println(s.findLUSlength(str));
	}
}
