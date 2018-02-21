class Tuple{
	public boolean flag;
	public int index;
	public Tuple(boolean flag, int index){
		this.flag = flag;
		this.index = index;
	}
}
class Solution {
	public int lengthOfLongestSubstring(String s){
		int[] result = this.lengthArray(s);
		int max = 1;
		for(int i=0; i<result.length; i++){
			max = result[i] > max ? result[i]:max;	
		}
		return max;
	}
    public int[] lengthArray(String s) {
		if(s == null || s.length() == 0){
			return null;
		}
		int[] flag = new int[s.length()];
		for(int i=0; i<flag.length; i++){
			flag[i] = 1;
		}
		char[] chr = s.toCharArray();
		for(int i=1; i<chr.length; i++){
			Tuple temp = contains(chr,flag,i);
			if(!temp.flag){
				flag[i] = flag[i-1] - temp.index;
				continue;
			}else{
				flag[i] = i - temp.index ;		
			}
		}
       	return flag; 
    }
	public Tuple contains(char[] a, int[] b, int c){
		for(int i=1; i<=b[c-1]; i++){
			if(a[c-i] == a[c]){
				return new Tuple(true, c-i);
			}else{
				continue;
			}
		}
		return new Tuple(false, -1);
	}
}

public class SubString{
	public static void main(String[] args){
		String a = "abcabcbb";
		String b = "bbbb";
		String c = "pwwkew";
		String d = "a";
		Solution s = new Solution();
		System.out.println(s.lengthOfLongestSubstring(a));
		System.out.println(s.lengthOfLongestSubstring(b));
		System.out.println(s.lengthOfLongestSubstring(c));
		//printArr(s.lengthOfLongestSubstring(a));
		//printArr(s.lengthOfLongestSubstring(b));
		//printArr(s.lengthOfLongestSubstring(c));
		//printArr(s.lengthOfLongestSubstring(d));
	}
	public static void printArr(int[] a){
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] +"\t");
		}
		System.out.println("\n");
	}
}
