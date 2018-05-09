//Leetcode problem 767 Reorganize String 
//Solution written by Xuqiang Fang on 9 May, 2018

import java.util.Arrays;
import java.util.Comparator;

class Solution{
    public String reorganizeString(String S){
        int[][] alpha = new int[26][2];
        for(int i=0; i<26; ++i){
            alpha[i][0] = i;
        }
        int max = 0;
        for(char c : S.toCharArray()){
            alpha[c-'a'][1]++;
            max = Math.max(max, alpha[c-'a'][1]);
        }
        if(max > (S.length() + 1)/2)
            return "";
        
        Arrays.sort(alpha, new Comp());
        char[] ch = new char[S.length()];
        int index = 0;
        for(int i=0; i<26; i++){
            while(alpha[i][1] > 0){
                index %= S.length();
                ch[index] = (char)(alpha[i][0]+'a');
                index = index + 2;
                alpha[i][1]--;
                if(index >= S.length())
                    index = 1;
            }
        }

        return String.valueOf(ch);
    }
}

class Comp implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return b[1] - a[1];
    }
}

public class ReorganizeString{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "aabb";
        String S1 = "blflxll";
        System.out.println(s.reorganizeString(S));
        System.out.println(s.reorganizeString(S1));
	}
}
