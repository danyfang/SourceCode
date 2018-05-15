//Leetcode problem 748 Shortest Completing Word
//Solution written by Xuqiang Fang on 15 May, 2018
class Solution{
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] plate = new int[26];
        for(char c : licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                plate[Character.toLowerCase(c)-'a']++;
            }
        }
        String res = "aaaaaaaaaaaaaaaaaaaaaa";
        for(String word : words){
            if(complete(plate, word) && word.length() < res.length()){
                res = word;
            }
        }

        return res;
    }

    private boolean complete(int[] plate, String word){
        int[] w = new int[26];
        for(char c : word.toCharArray()){
            w[c-'a']++;
        }
        for(int i=0; i<plate.length; ++i){
            if(plate[i] > w[i])
                return false;
        }
        return true;
    }
}

public class CompletingWord{
	public static void main(String[] args){
		Solution s = new Solution();
        String licensePlate = "1s3 456";
        String[] words = {"looks", "pest", "stew", "show"};
        System.out.println(s.shortestCompletingWord(licensePlate, words));
	}
}
