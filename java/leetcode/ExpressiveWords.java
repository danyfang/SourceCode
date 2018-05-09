//Leetcode problem 809 Expressive Words
//Solution written by Xuqiang Fang on 9 May, 2018
class Solution{
    public int expressiveWords(String S, String[] words) {
        int sum = 0;
        for(String w : words){
            if(isValid(S, w)){
                //System.out.println(w);
                sum++;
            }
        }
        return sum;
    }
    

    private boolean isValid(String s, String p){
        String[] str = s.split("(?<=(.))(?!\\1)");
        String[] ptr = p.split("(?<=(.))(?!\\1)");
        if(str.length != ptr.length)
            return false;
        for(int i=0; i<str.length; ++i){
            if(str[i].charAt(0) == ptr[i].charAt(0) && ((str[i].length() >= 3 && str[i].length() >= ptr[i].length()) || str[i].length() == ptr[i].length())){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

public class ExpressiveWords{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(s.expressiveWords(S, words));
	}
}
