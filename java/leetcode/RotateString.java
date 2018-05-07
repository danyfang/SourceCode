//Leetcode problem 796 Rotate String
//Solution written by Xuqiang Fang on 6 May, 2018
class Solution{
    public boolean rotateString(String A, String B){
        if(A == null || B == null || A.length() != B.length())
            return false;
        int n = A.length();
        for(int i=0; i<n; ++i){
            int j;
            for(j=0; j<n; ++j){
                if(A.charAt(j) != B.charAt((i+j)%n)){
                    break;
                }
            }
            if(j == n)
                return true;
        }
        return false;
    }
}

public class RotateString{
	public static void main(String[] args){
		Solution s = new Solution();
        String A = "abcde";
        String B = "cdeab";
        String C = "abced";
        System.out.println(s.rotateString(A, B));
        System.out.println(s.rotateString(A, C));
	}
}
