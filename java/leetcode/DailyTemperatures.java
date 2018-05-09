//Leetcode problem 739 Daily Temperatures 
//Solution written by Xuqiang Fang on 9 May, 2018
import java.util.Stack;
class Solution{
    public int[] dailyTemperatures(int[] temperatures){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,temperatures[0]});
        for(int i=1; i<temperatures.length; ++i){
            while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]){
                int[] temp = stack.pop();
                temperatures[temp[0]] = i - temp[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }

        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            temperatures[temp[0]] = 0;
        }

        return temperatures;
    }
}

public class DailyTemperatures{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = s.dailyTemperatures(temp);
        for(int i : res)
            System.out.println(i + "\t");
        System.out.println("\n");
	}
}
