//Leetcode problem No 14 Longest Common Prefxi 
//Solution written by Xuqiang Fang 21 Feb, 2018 

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }else{
            String result = strs[0];
            for(int i=0; i<strs.length; i++){
                result = Common(result,strs[i]);
            }
            return result;
        }

    }
    public String Common(String a, String b){
        int size = (a.length() >= b.length()) ? b.length():a.length();
        char[] common = new char[size];
        int length = 0;
        for(int i=0;i<size;i++){
            if(a.charAt(i) == b.charAt(i)){
                common[i] = a.charAt(i);
                length++;
            }
        }
        //this.printchar(common);
        return String.valueOf(common,0,length);
    }
    public void printchar(char[] s){
        for(int i=0; i<s.length; i++){
            System.out.println(s[i]);
        }
    }
}
public class CommonString {
    public static void main(String[] args){
        Solution s = new Solution();
        //System.out.println(s.Common("helloworld","hello"));
        String[] input = {"hellowordl","helloworldjava","helloworldc++","helloworldpython"};
        String[] newInput = {"aca","cba"};
        System.out.println(s.longestCommonPrefix(input));
        System.out.println(s.longestCommonPrefix(newInput));

        return ;
    }
}
