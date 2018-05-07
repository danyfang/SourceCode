//Leetcode problem 821 Shortest Distance to a Character
//Solution written by Xuqiang Fang on 7 May, 2018
class Solution{
    public int[] shortestToChar(String S, char C) {
        int prev = -100000;
        int curr = 0;
        char[] ch = S.toCharArray();
        int[] result = new int[S.length()];
        for(int i=0; i<result.length; ++i){
            while(i < ch.length && ch[i] != C){
                i++;
            }
            for(int j=curr; j<i; ++j){
                if(i == ch.length && ch[i-1] != C)
                    result[j] = Math.abs(j-prev);
                else
                    result[j] = Math.min(Math.abs(j-i), Math.abs(j-prev));
            }
            curr = i;
            prev = i;
        }

        return result;
    }
}

public class ShortestDistance{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "loveleetcode";
        int[] ret = s.shortestToChar(S, 'e');
        for(int i : ret)
            System.out.print(i + "  ");
        System.out.println("\n");
	}
}
