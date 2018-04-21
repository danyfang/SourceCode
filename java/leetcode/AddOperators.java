//Leetcode problem 282 Expression Add Operators
//Solution written by Xuqiang Fang on 17 April, 2018 
import java.util.ArrayList;
import java.util.List;


/*
class Solution{
    public List<String> addOperators(String num, int target){
        List<String> list = new ArrayList<>();
        if(num == null || num.length() <= 1)
            return list;
        char[] ch = new char[num.length() * 2 - 1];
        for(int i=0; i<num.length(); i++){
            ch[2*i] = num.charAt(i);
            if(i < num.length()-1)
                ch[2*i+1] = '+';
        }
        System.out.println(String.valueOf(ch));
        dfs(list, ch, target, 1, '+',1);
        dfs(list, ch, target, 1, '-',1);
        dfs(list, ch, target, 1, '*',1);
        System.out.println(list.size());
        return list;
    }	
    private void dfs(List<String> list,char[] num, int target, int index, char operator, int changed){
        num[index] = operator;
        if(evaluate(num) == target && changed == (num.length-1)/2){
            list.add(String.valueOf(num));
        }
        for(int i=index; i<num.length-2; i=i+2){
            dfs(list, num, target, i + 2, '+', changed+1);
            dfs(list, num, target, i + 2, '-', changed+1);
            dfs(list, num, target, i + 2, '*', changed+1);
        }
    }
    public int evaluate(char[] num){
        String s = String.valueOf(num);
        return 0;
    }
}
*/
class Solution{
    public List<String> addOperators(String num, int target){
        List<String> list = new ArrayList<>();
        if(num == null || num.length() <= 1)
            return list;
        dfs(num, target, 0, "", 0, 0, list);
        return list;
    }

    private void dfs(String num, int target, int pos, String exp, long prev, long curr, List<String> list){
        if(pos == num.length()){
            if(curr == target)
                list.add(exp);
            return;
        }

        for(int l=1; l<=num.length()-pos; l++){
            String temp = num.substring(pos,pos+l);
            if(temp.charAt(0) == '0' && temp.length() > 1 )
                break;
            long n = Long.parseLong(temp);
            if(n > Integer.MAX_VALUE)
                break;
            if(pos == 0){
                dfs(num, target, l, temp, n, n, list); 
                continue;
            }
            dfs(num, target, pos+l, exp+'+'+temp, n, curr+n, list);
            dfs(num, target, pos+l, exp+'-'+temp, -n, curr-n, list);
            dfs(num, target, pos+l, exp+'*'+temp, prev*n, curr-prev+prev*n, list);
        }
    }
}

public class AddOperators{
	public static void main(String[] args){
		Solution s = new Solution();
        long n = Long.parseLong("1234556778888");
        System.out.println(n > Integer.MAX_VALUE);
        System.out.println(s.addOperators(args[0], 6));
	}
}
