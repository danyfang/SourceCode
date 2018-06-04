//Leetcode problem 843 Guess the Word
//Solution written by Xuqiang Fang on 4 June, 2018 
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
class Master{
    public Master(String s){
        this.secret = s;
    }
    public int guess(String word){
        return match(secret, word);
    }
    private int match(String a, String b){
        int m = 0;
        for(int i=0; i<a.length(); ++i){
            if(a.charAt(i) == b.charAt(i)){
                m++;
            }
        }
        return m;
    }
    private String secret;
}
class Solution{
    public void findSecretWord(String[] wordlist, Master master) {
        for(int i=0, x=0; i<10 && x<6; ++i){
            Map<String, Integer> map = new HashMap<>();
            for(String s : wordlist){
                for(String w: wordlist){
                    if(match(s, w) == 0){
                        map.put(s, map.getOrDefault(s, 0)+1);
                    }
                }
            }
            String g = wordlist[0];
            int min = 100;//the wordlist max length is 100
            for(String s : wordlist){
                if(map.getOrDefault(s, 0) <= min){
                    g = s;
                    min = map.getOrDefault(s, 0);
                } 
            }
            x = master.guess(g);
            System.out.println("Next Guess is : " + g + " " + x + " matches");
            List<String> temp = new ArrayList<>();
            for(String w : wordlist){
                if(match(w, g) == x){
                    temp.add(w);
                }
            }
            wordlist = temp.toArray(new String[0]);
            System.out.println("remaining possible result size " + temp.size());
            System.out.println(temp);
        } 
    }
    private int match(String a, String b){
        int m = 0;
        for(int i=0; i<a.length(); ++i){
            if(a.charAt(i) == b.charAt(i)){
                m++;
            }
        }
        return m;
    }
}

public class GuessWord{
	public static void main(String[] args){
		Solution s = new Solution();
        String secret = "hbaczn";
        String[] wordlist = {"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"};
        Master master = new Master(secret);
        s.findSecretWord(wordlist, master);
	}
}
