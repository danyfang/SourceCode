//Leetcode problem 467 Unique Substrings in Wraparound String
//Solution written by Xuqiang Fang on 7 may, 2018

//solution provided by user@shawngao
class Solution{
    public int findSubstringInWraproundString(String p){
        //max number of unique substrings in p ends with 'a', 'b', ..., 'z'
        int[] count = new int[26];
        int maxLengthCur = 0;
        for(int i=0; i<p.length(); ++i){
            if(i>0 && (p.charAt(i)-p.charAt(i-1) == 1 || (p.charAt(i-1)-p.charAt(i) == 25))){
                maxLengthCur++;
            }
            else{
                maxLengthCur = 1;
            }

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }

        int sum = 0;
        for(int i=0; i<26; ++i){
            sum += count[i];
        }

        return sum;
    }

}

public class WraparoundString{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "zabcdfghijk";
        String S2 = "abaab";
        System.out.println(s.findSubstringInWraproundString(S));
        System.out.println(s.findSubstringInWraproundString(S2));
	}
}
