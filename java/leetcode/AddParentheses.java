//Leetcode problem 241 Different Ways to Add Parentheses
//Solution written by Xuqiang Fang on 17 April, 2018 
import java.util.ArrayList;
import java.util.List;
class Solution{
    //based on answer provided by user@2guotou
    public List<Integer> diffWaysToCompute(String input){
        List<Integer> list = new ArrayList<>();
        if(input == null || input.length() == 0)
            return list;
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int l : left){
                    for(int r : right){
                        int temp = 0;
                        switch(c){
                            case '+':
                                temp = l + r;
                                break;
                            case '-':
                                temp = l - r;
                                break;
                            case '*':
                                temp = l * r;
                                break;
                        }
                        list.add(temp);
                    }
                }
            }
        }
        if(list.size() == 0)
            list.add(Integer.valueOf(input));
        return list;
    }
}

public class AddParentheses{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.diffWaysToCompute(args[0]));
	}
}
