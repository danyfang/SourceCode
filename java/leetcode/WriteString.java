//Leetcode problem 806 Number of Lines to Write String
//Solution written by Xuqiang Fang on 7 May, 2018
class Solution{
    public int[] numberOfLines(int[] widths, String S) {
        int[] ret = new int[2];    
        char[] ch = S.toCharArray();
        int line = 0;
        int width = 100;
        int count = 1;
        int i = 0;
        while(true){
            while(i < ch.length && line < width){
                line += widths[ch[i]-'a']; 
                i++;
            }
            if(line == width){
                count++;
                line = 0;
            }
            else if(line > width){
                count++;
                line = widths[ch[--i]-'a'];
                i++;
            }
            if(i == ch.length){
                ret[1] = line;
                break;
            }
        }
        ret[0] = count;

        return ret;
    }
}

public class WriteString{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "abcdefghijklmnopqrstuvwxyz";

        //int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        //String S = "bbbcccdddaaa";
        int[] ret = s.numberOfLines(widths, S);
        System.out.println(ret[0] + " "+ ret[1]);
	}
}
