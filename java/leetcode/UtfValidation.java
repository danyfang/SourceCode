//Leetcode problem 393 UTF-8 Validation
//Solution written by Xuqiang Fang on 1 Aug, 2018
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
    public boolean validUtf8(int[] data) {
        int n = data.length;
        int i = 0;
        while (i < n){
            String s = String.format("%8s", Integer.toBinaryString(data[i])).replace(' ', '0');
            if(s.charAt(0) == '0'){
                i++;
            }
            else{
                int j = 0;
                while(j < 8 && s.charAt(j) == '1'){
                    j++;
                }
                if(i+j > n || j == 1 || j > 4){
                    return false;
                }
                for(int x=1; x<j; ++x){
                    String t = String.format("%8s", Integer.toBinaryString(data[i+x])).replace(' ', '0');
                    if(!t.substring(0,2).equals("10")){
                        return false;
                    }
                }
                i += j;
            }
        }
        return true;
    }
}

public class UtfValidation{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] data = {115,100,102,231,154,132,13,10};
        System.out.println(s.validUtf8(data));
        data = new int[]{235, 140, 4};
        System.out.println(s.validUtf8(data));
        data = new int[]{197, 130, 1};
        System.out.println(s.validUtf8(data));
	}
}
