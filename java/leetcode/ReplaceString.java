//Leetcode problem 833 Find And Replace in String 
//Solution written by Xuqiang Fang on 14 May, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
class Solution{
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if(indexes.length == 0)
            return S;
        
        Map<Integer, String[]> map = new HashMap<>();
        for(int i=0; i<indexes.length; ++i){
            map.put(indexes[i], new String[]{sources[i], targets[i]});
        }
        Arrays.sort(indexes);

        StringBuilder sb = new StringBuilder();
        sb.append(S.substring(0,indexes[0]));
        int start = indexes[0];
        int end = start;
        for(int i=0; i<indexes.length; ++i){
            String source = map.get(indexes[i])[0];
            if(S.substring(indexes[i], indexes[i]+source.length()).equals(source)){
                start += map.get(indexes[i])[0].length();
                sb.append(map.get(indexes[i])[1]);
            }
            if(i + 1 < indexes.length){
                end = indexes[i+1];
            }
            else{
                end = S.length();
            }
            if(start < end){
                sb.append(S.substring(start, end));
                start = end;
            }
        }

        return sb.toString();
    }
}

public class ReplaceString{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "abcd";
        int[] indexes = {0,2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        System.out.println(s.findReplaceString(S, indexes, sources, targets));
	}
}
