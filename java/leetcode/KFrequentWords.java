//Leetcode problem  692 Top K Frequent Words
//Solution written by Xuqiang Fang on 12 May, 2018

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Solution{
    public List<String> topKFrequent(String[] words, int k){
        Map<String, Integer> map = new HashMap<>(); 
        int maxFrequent = 0;
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
            maxFrequent = Math.max(maxFrequent, map.get(word));
        }

        List<String>[] freq = new ArrayList[maxFrequent];
        for(String key : map.keySet()){
            int count = map.get(key);
            if(freq[count-1] == null){
                freq[count-1] = new ArrayList<>();
            }
            //System.out.println("count = " + count + " key = " + key);
            freq[count-1].add(key);
        }
        List<String> list = new ArrayList<>();
        for(int i=maxFrequent-1; i>=0; --i){
            if(list.size() < k && freq[i] != null){
                freq[i].sort((a,b)->(a.compareTo(b)));
                list.addAll(freq[i]);
            } 
        }
        
        if(list.size() > k){
            return list.subList(0,k);
        }
        return list;
    }

}

public class KFrequentWords{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] words = {"the", "day", "thes",  "the", "the", "the", "sunny", "thes", "thes","thes"};
        String[] words2 = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words3 = {"a","aaa","aa","aaaa","aaaaa","aaaaaa"};
        System.out.println(s.topKFrequent(words, 4));
        System.out.println(s.topKFrequent(words2, 2));
        System.out.println(s.topKFrequent(words3, 2));
	}
}
