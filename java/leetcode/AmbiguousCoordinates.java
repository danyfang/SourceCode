//Leetcode problem 816 Ambiguous Coordinates
//Solution written by Xuqiang Fang on 21 May, 2018

import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<String> ambiguousCoordinates(String S) {
        int n = S.length();
        List<String> list = new ArrayList<>();
        for(int i=2; i<n-1; ++i){
            List<String> left = combination(S.substring(1,i));
            List<String> right = combination(S.substring(i,n-1));
            for(String l : left){
                for(String r : right){
                    list.add("(" + l + ", " + r + ")");
                }
            }
        }
        return list;
    }

    //this is the key part of this solution, because the idea is very simple, we choose a spot for 
    //comma and make product of possible results from each side
    /**
    if S == "": return []
    if S == "0": return [S]
    if S == "0XXX0": return []
    if S == "0XXX": return ["0.XXX"]
    if S == "XXX0": return [S]
    return [S, "X.XXX", "XX.XX", "XXX.X"...]
    */
    public List<String> combination(String S){
        int n = S.length();
        List<String> res = new ArrayList<>();
        if(n == 0 || (n>=2 && S.charAt(0) == '0' && S.charAt(n-1) == '0')){
            return res;
        }
        if(n > 1 && S.charAt(0) == '0'){
            res.add("0." + S.substring(1));
            return res;
        }
        res.add(S);
        if(n == 1 || S.charAt(n-1) == '0'){
            return res;
        }
        for(int i=1; i<n; ++i){
            res.add(S.substring(0,i) + "." + S.substring(i));
        }
        return res;
    }
}

public class AmbiguousCoordinates{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.ambiguousCoordinates("(8812)"));
	}
}
