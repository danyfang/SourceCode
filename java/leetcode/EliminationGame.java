//Leetcode problem 390 Elimination Game
//Solution written by Xuqiang Fang on 23 April, 2018 
//solution provided by user@NathanNi
class Solution{
    public int lastRemaining(int n){
        boolean left = true;
        int remaining = n;
        int head = 1;
        int step = 1;
        while(remaining > 1){
            if(left || remaining % 2 == 1){
                head = head + step;
            }
            step = step * 2;
            remaining /= 2;
            left = !left;
        }
        return head;
    }	
}

public class EliminationGame{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.lastRemaining(Integer.valueOf(args[0])));
	}
}
