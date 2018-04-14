//Leetcode problem No 187 Repeated DNA Sequence
//Solution written by Xuqiang Fang on 12 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution{
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s == null || s.length() <= 10)
            return list;
        HashMap<String, Integer> map = new HashMap<>();
        String temp;
        int count = 0;
        for(int i=0; i<=s.length()-10; i++){
            temp = s.substring(i,i+10); 
            if(!map.containsKey(temp)){
                map.put(temp, 1);
            }
            else{
                count = map.get(temp);
                map.put(temp, count+1);
                if(count == 1)
                    list.add(temp);
            }
        }
        return list;
    }	
    //another solution provided by user@crazyirontoiletpaper, good idea
    public List<String> findRepeatedDnaSequences_(String s){
        Set<Integer> words = new HashSet<>(); 
        Set<Integer> doubleWords = new HashSet<>();
        List<String> rv = new ArrayList<>();
        char[] map = new char[26];
        map['A'-'A'] = 0;
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;

        for(int i=0; i<s.length()-9; i++){
            int v = 0;
            for(int j=i; j<i+10; j++){
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(v) && doubleWords.add(v)){
                rv.add(s.substring(i,i+10));
            }
        }
        return rv;
    }
}

public class RepeatedSequence{
	public static void main(String[] args){
		Solution s = new Solution();
        String str = "AAAAAAAAAAAAAAAGGGTTT";
        System.out.println(s.findRepeatedDnaSequences_(str));
	}
}
