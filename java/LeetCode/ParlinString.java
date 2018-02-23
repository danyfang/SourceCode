// leetcode question 5--Longest Palindromic Substring
// solution written by Xuqiang Fang on 21, Feb, 2018, Berlin, Germany

class Solution {
    public String longestPalindrome(String s) {
       	if(s == null || s.length() <= 0){//"a" is not regonized as a parlindrome string
			return null;
		}
		if(s.length() == 1){
			return s;
		}
		char[] chr = s.toCharArray();
		int[] flag = new int[chr.length];
		/*
		int array flag stores the information about each character in the string, 
		the number denotes the corresponding character offset from the
		current one (backward)		
		*/
		for(int i=1; i<chr.length; i++){//chr.length>=2
			flag[i] = parlin(chr,flag,i);
		}
		for(int i=0; i<flag.length; i++){
			System.out.print(flag[i]);
		}
		System.out.print("\n");
		int max = 0;
		int max_index = 0;
		for(int i=0; i<flag.length; i++){
			if(flag[i] > max){
				max = flag[i];
				max_index = i;
			}
		}
		return String.valueOf(chr, max_index-max, max+1);
    }
	public int parlin(char[] ch, int[] flag, int index){
		int interator = flag[index-1];//index>=1
		int number = 0;
		if(interator == 0){
			if(ch[index-1] == ch[index]){
				number = 1;
			}
			if(index-2>=0){
				if(ch[index-2] == ch[index]){
					number = 2;
				}
			}
		}else if(interator > 0){
			if(ch[index] == ch[index-1]){
					number = interator + 1;
			}
			else if(interator%2==0){
				if(ch[index] == ch[index-1]){
					number = interator + 1;
				}
				if(index-2-interator>=0){
					if(ch[index] == ch[index-2-interator]){
						number = interator + 2;
					}else{
						number = 0;
					}
				}else if(index-2-interator<0){
					number = 0;	
				}
			}else{
				if(index-2-interator>=0){
					if(ch[index] == ch[index-2-interator]){
						number = interator + 2;
					}else{
						number = 0;
					}
				}else if(index-2-interator<0){
					number = 0;	
				}
			}
		}
		return number;
	}
}
public class ParlinString{
	public static void main(String[] args){
		Solution s = new Solution();
		String a = "abcddcbefebgh";
		String b = "ccccddd";
		int[] flag = new int[a.length()];
		char[] chr = a.toCharArray();
		System.out.println(a);
		System.out.println(s.longestPalindrome(a));
		System.out.println(b);
		System.out.println(s.longestPalindrome(b));
	}
}
