//Leetcode problem 345 Reverse Vowels of a String
//Solution written by Xuqiang Fang on 15 April, 2018 

class Solution{
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1)
            return s;
        char[] arr = s.toCharArray();
        int i = 0;
        int e = arr.length-1;
        while(i < e){
            if(!isVowel(arr[i])){
                i++;
                continue;
            }
            if(!isVowel(arr[e])){
                e--;
                continue;
            }
            char c = arr[i];
            arr[i] = arr[e];
            arr[e] = c;
            i++;
            e--;
        }
        return String.valueOf(arr);
    }	
    //to speed up judging vowels
    //Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
            return true;
        return false;
    }
}

public class ReverseVowels{
	public static void main(String[] args){
		Solution s = new Solution();
        String str = "HEllo";
        System.out.println(s.reverseVowels(str));
	}
}
