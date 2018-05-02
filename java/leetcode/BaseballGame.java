//Leetcode problem 682 Baseball Game
//Solution written by Xuqiang Fang on 2 May, 2018 
import java.util.Stack;
class Solution{
    public int calPoints(String[] ops){
        if(ops == null || ops.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        //stack will always store the points of each valid round
        for(String s : ops){
            if(s.equals("C")){
                if(!stack.isEmpty()){
                    sum -= stack.peek();
                    stack.pop();
                }
            }
            else if(s.equals("D")){
                int tmp = stack.peek();
                stack.push(2*tmp);
                sum += 2*tmp;
            }
            else if(s.equals("+")){
                if(stack.size() > 1){
                    int tmp1 = stack.pop();
                    int tmp2 = stack.pop();
                    sum = sum + tmp1 + tmp2;
                    stack.push(tmp2);
                    stack.push(tmp1);
                    stack.push(tmp1+tmp2);
                }
                else if(stack.size() == 1){
                    int tmp = stack.peek();
                    sum += 2 * tmp;
                    stack.push(2*tmp);
                }
            }
            else{
                int tmp = Integer.valueOf(s);
                stack.push(tmp);
                sum += tmp;
            }
        }

        return sum;
    }	
}

public class BaseballGame{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] ops = {"5","2","C","D","+"};
        String[] ops2 = {"5","-2","4","C","D","9","+","+"};
        System.out.println(s.calPoints(ops));
        System.out.println(s.calPoints(ops2));
	}
}
