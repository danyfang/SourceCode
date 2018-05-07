//Leetcode problem 830 Positions of Large Groups
//Solution written by Xuqiang Fang on 7 may, 2018

import java.util.List;
import java.util.ArrayList;
class Solution{
    public List<List<Integer>> largeGroupPositions(String S){
        List<List<Integer>> list = new ArrayList<>();
        if(S.length() <= 2)
            return list;
        List<Integer> sub = new ArrayList<>();
        char[] ch = S.toCharArray();
        int prev = 0;
        for(int i=1; i<ch.length; ++i){
            if(ch[i] != ch[i-1]){
                if(i-prev>=3){
                    sub.add(prev);
                    sub.add(i-1);
                    list.add(new ArrayList<>(sub));
                    sub.clear();
                }
                prev = i;
            }
        }
        if(ch[ch.length-1] == ch[ch.length-2] && ch.length-prev >= 3){
            sub.add(prev);
            sub.add(ch.length-1);
            list.add(new ArrayList<>(sub));
        }

        return list;
    }
}

public class LargeGroups{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "abcdddeeeeaabbbcd";
        List<List<Integer>> list = s.largeGroupPositions(S);
        for(List<Integer> l : list){
            System.out.println(l);
        }
	}
}
