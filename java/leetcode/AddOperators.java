//Leetcode problem 282 Expression Add Operators
//Solution written by Xuqiang Fang on 17 April, 2018 
import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<String> addOperators(String num, int target){
        List<String> list = new ArrayList<>();
        if(num == null || num.length() == 0)
            return list;
        char[] ch = new char[num.length() * 2 - 1];
        for(int i=0; i<num.length(); i++){
            ch[2*i] = num.charAt(i);
            if(i < num.length()-1)
                ch[2*i+1] = '+';
        }
        System.out.println(String.valueOf(ch));
        int index = 0;
        return list;
    }	
    private void dfs(List<String> list,char[] num, int index){
        if(evaluate(num) == target){
            list.add(String.valueOf(num));
        }
        for(int i=index; i<num.length; i=i+2){
            dfs(list, num, i + 2, '+');
            dfs(list, num, i + 2, '-');
            dfs(list, num, i + 2, '*');
        }
    }
    public int evaluate(char[] num){
        
        return 0;
    }
}

public class AddOperators{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.addOperators(args[0], 9));
	}
}
