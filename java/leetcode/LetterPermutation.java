//Leetcode problem 784 Letter Case Permutation
//Solution written by Xuqiang Fang on 2 may, 2018 
import java.util.ArrayList;
import java.util.List;
class Solution{
    public List<String> letterCasePermutation(String S){
        if(S == null || S.length() == 0){
            list.add("");
            return list;
        }
        List<String> list = new ArrayList<>();
        if(S.length() == 1){
            if(S.matches("\\d")){
                list.add(S);
            }
            else{
                list.add(S);
                if(S.charAt(0)>='A' && S.charAt(0)<='Z'){
                    list.add(String.valueOf(Character.toLowerCase(S.charAt(0))));
                }
                else{
                    list.add(String.valueOf(Character.toUpperCase(S.charAt(0))));
                }
            }

        }
        else{
            for(String st : letterCasePermutation(S.substring(1))){
                if(S.charAt(0) >= '0' && S.charAt(0) <= '9'){
                    list.add(S.charAt(0)+st);
                }
                else{
                    char c = Character.toLowerCase(S.charAt(0));
                    list.add(c+st);
                    list.add((char)(c-'a'+'A')+st);
                }
            }     
        }
        return list;
    }	
}

public class LetterPermutation{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "a1b2";
        String S1 = "12345";
        System.out.println(s.letterCasePermutation(S));
        System.out.println(s.letterCasePermutation(S1));
	}
}
