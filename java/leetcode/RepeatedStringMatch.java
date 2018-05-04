//Leetcode problem 686 Repeated String Match
//Solution written by Xuqiang Fang on 3 May, 2018
import java.io.PrintStream;
class Solution{
    public int repeatedStringMatch(String A, String B){
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)) return count;
        if(sb.append(A).toString().contains(B)) return ++count;
        return -1;
    }	
}

public class RepeatedStringMatch{
	public static void main(String[] args){
		Solution s = new Solution();
        String A = "abcd";
        String B = "abcdab";
        System.out.println(s.repeatedStringMatch(A,B));
        System.out.println(System.currentTimeMillis());
        try{
            PrintStream ps = new PrintStream("template.sh");
            ps.flush();
        }
        catch (Exception e){
            //e.printStackTrace();
            System.out.println("Exception occured");
        }
	}
}
