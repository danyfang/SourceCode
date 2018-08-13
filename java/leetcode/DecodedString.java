//Leetcode problem 884 Decoded String at Index
//Solution written by Xuqiang Fang on 4 Aug, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    public String decodeAtIndex(String s, long k){
        return helper(s, (long)k); 
    }
    private String helper(String s, long k) {
        long c = 0;
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                c++;
                if(c == k){
                    return String.valueOf(ch);
                }
            }
            else{
                c *= (ch-'0');
            }
            if(c >= k){
                c /= (ch-'0');
                long l = k % c;
                //System.out.println(k + "," + c);
                if(l == 0){
                    return helper(s, c);
                }
                return helper(s, l);
            }
        }
        throw null;
    }
}

public class DecodedString{
	public static void main(String[] args){
		Solution s = new Solution();
        /**
        System.out.println(s.decodeAtIndex("leet2code3", 10));
        System.out.println(s.decodeAtIndex("ha22", 5));
        System.out.println(s.decodeAtIndex("a2345678999999999999999", 1));
        System.out.println(s.decodeAtIndex("vk6u5xhq9v", 554));
        System.out.println(s.decodeAtIndex("a23", 6));
        */
        System.out.println(s.decodeAtIndex("czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm289thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps", 768077956));
	}
}
