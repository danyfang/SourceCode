//Leetcode problem 68 Text Justification
//Solution written by Xuqiang Fang on 26 July, 2018
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
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> container = new ArrayList<>();
        container.add(words[0]);
        int current = words[0].length();
        List<String> ans = new ArrayList<>();
        for(int i=0; i<words.length-1; ++i){
            if(current + words[i+1].length() + 1<= maxWidth){
                current += words[i+1].length() + 1;
                container.add(words[i+1]);
            } 
            else{
                if(container.size() == 1){
                    StringBuilder sb = new StringBuilder(container.get(0));
                    while(sb.length() < maxWidth){
                        sb.append(" ");
                    }
                    ans.add(sb.toString());
                } 
                else{
                    int num = container.size() - 1; 
                    int total = maxWidth - (current - num);
                    int each = total / num;
                    int residual = total % num;
                    int j = 0;
                    StringBuilder sb = new StringBuilder();
                    while(residual-- > 0){
                        sb.append(container.get(j++));
                        for(int x=0; x<each; ++x){
                            sb.append(" ");
                        }
                        sb.append(" ");
                    }
                    while(j < container.size() - 1){
                        sb.append(container.get(j++));
                        for(int x=0; x<each; ++x){
                            sb.append(" ");
                        }
                    }
                    sb.append(container.get(j));
                    ans.add(sb.toString());
                }
                container.clear();
                container.add(words[i+1]);
                current = words[i+1].length();
            }
        }
        if(container.size() > 0){
            StringBuilder sb = new StringBuilder();
            for(String s : container){
                sb.append(s);
                sb.append(" ");
            }
            while(sb.length() > maxWidth){
                sb.deleteCharAt(sb.length()-1);
            }
            while(sb.length() < maxWidth){
                sb.append(" ");
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}

public class TextJustification{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"};
        List<String> ans = s.fullJustify(words, 20);
        for(String a : ans){
            System.out.println(a);
        }
        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        ans = s.fullJustify(words, 16);
        for(String a : ans){
            System.out.println(a);
        }
	}
}
