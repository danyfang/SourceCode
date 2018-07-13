//Leetcode problem 761 Speical Binary String
//Solution written by Xuqiang Fang on 12 July, 2018
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
import java.util.Collections;
import java.util.Comparator;
class Solution{
    public String makeLargestSpecial(String S) {
        List<String> ans = new ArrayList<>();
        int prev = 0, count = 0;
        for(int i=0; i<S.length(); ++i){
            if(S.charAt(i) == '1'){
                count++;
            } 
            else{
                count--;
            }
            if(count == 0){
                ans.add('1' + makeLargestSpecial(S.substring(prev+1, i))+'0');
                prev = i+1;
            }
        }
        ans.sort(new Comp());
        StringBuilder sb = new StringBuilder();
        for(String a : ans){
            sb.append(a);
        }
        return sb.toString();
    }
    class Comp implements Comparator<String>{
        public int compare(String a, String b){
            int l = Math.min(a.length(), b.length());
            for(int i=0; i<l; ++i){
                if(a.charAt(i) != b.charAt(i)){
                    return (int)(b.charAt(i)-a.charAt(i));
                }
            }
            return b.length() - a.length();
        }
    }
}

public class SpecialBinaryString{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "11011000";
        System.out.println(s.makeLargestSpecial(S));
	}
}
