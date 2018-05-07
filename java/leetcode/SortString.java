//Leetcode problem  791 Custom Sort String
//Solution written by Xuqiang Fang on 7 may, 2018
class Solution{
    public String customSortString(String S, String T){
        int[] alpha = new int[26]; 
        for(char c : S.toCharArray()){
            alpha[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : T.toCharArray()){
            if(alpha[c-'a'] == 0){
                sb.append(c);
            } 
            else{
                alpha[c-'a']++;
            }
        }
        for(char c : S.toCharArray()){
            int j = alpha[c-'a'];
            while(j-- > 1){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

public class SortString{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "cba";
        String T = "abcd";
        System.out.println(s.customSortString(S,T));
	}
}
