//Leetcode problem 676 Implement Magic Dictionary
//Solution written by Xuqiang Fang on 15 May, 2018
import java.util.HashMap;
import java.util.Map;

class MagicDictionary {
    Map<String, Character> map;    

    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>(); 
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        StringBuilder sb = new StringBuilder(); 
        for(String d : dict){
            sb.append(d);
            for(int i=0; i<d.length(); ++i){
                sb.setCharAt(i, '*');
                map.put(sb.toString(), map.containsKey(sb.toString()) ? '*' : d.charAt(i));
                sb.setCharAt(i, d.charAt(i));
            }
            sb.delete(0, d.length());
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        StringBuilder sb = new StringBuilder(word);
        for(int i=0; i<word.length(); ++i){
            sb.setCharAt(i, '*');
            if(map.containsKey(sb.toString()) && map.get(sb.toString()) != word.charAt(i))
                return true;
            sb.setCharAt(i, word.charAt(i));
        }
        return false;
    }
}


public class MagicDictionaryImp{
	public static void main(String[] args){
        MagicDictionary s = new MagicDictionary();
        String[] dict = {"hello", "world", "leetcode"};
        s.buildDict(dict);
        while(true){
            String word = System.console().readLine();
            if(word.equals("stop"))
                break;
            System.out.println("Search for " + word + " : " + s.search(word));
        }
        //System.out.println(s.search("hella"));
	}
}
