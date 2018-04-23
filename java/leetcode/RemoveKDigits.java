//Leetcode problem 402 Remove K Digits
//Solution written by Xuqiang Fang on 22 April, 2018 

import java.util.Stack;

class Solution{
    //This solution causes runtime error stackoverflow
    /*
    public String removeK(String num, int k){
        if(num == null || num.length() == 0 || num.length() == k)
            return "0";
        if(k == 0)
            return num;
        //k >=1, num.length()>=2 
        int index = 0;
        if(num.charAt(1) == '0'){
            index = 1;
            while(++index < num.length() && num.charAt(index) == '0'){}
        }
        if(index >= 1){
            return removeKdigits(num.substring(index, num.length()), k-1);
        }
        if(index == 0){
            char[] ch = num.toCharArray();
            for(int i=0; i<ch.length-1; ++i){
                if(ch[i] > ch[i+1]){
                    return removeKdigits(num.substring(0,i)+num.substring(i+1,ch.length), k-1);
                }
            }
        }
        return removeKdigits(num.substring(0,num.length()-1),k-1);
    }	
    */
    public String removeKdigits(String num, int k){
        int digits  = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        //when we know the limit of stack, use array

        for(int i=0; i<num.length(); ++i){
            char c = num.charAt(i);
            while(top > 0 && stack[top-1] > c && k > 0){
                top -= 1;
                k -= 1;
            }
            stack[top++] = c;
        }

        int idx = 0;
        while(idx < digits && stack[idx] == '0')
            idx++;
        return idx == digits ? "0" : new String(stack, idx, digits - idx);
    }
}

public class RemoveKDigits{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.removeKdigits(String.valueOf(args[0]), Integer.valueOf(args[1])));
	}
}
