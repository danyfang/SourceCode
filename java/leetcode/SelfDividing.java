//Leetcode problem 728 Self Dividing Numbers
//Solution written by Xuqiang Fang on 10 May, 2018

import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<Integer> selfDividingNumbers(int left, int right){
        List<Integer> res = new ArrayList<>();
        for(int i=left; i<=right; ++i){
            if(valid(i)){
                res.add(i);
            }
        }
        return res;
    }
    private boolean valid(int num){
        char[] ch = String.valueOf(num).toCharArray();
        for(char c : ch){
            int i = c - '0';
            if(i == 0 || num % i != 0){
                return false;
            }
        }
        return true;
    }
}

public class SelfDividing{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.selfDividingNumbers(1,22));
	}
}
