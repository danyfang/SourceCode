//Leetcode problem 901 Online Stock Span
//Solution written by Xuqiang Fang on 9 Spe, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;
        while(stack.size() > 0 && stack.peek()[0] <= price){
            ans += stack.pop()[1];
        }
        stack.push(new int[]{price, ans});
        return ans;
    }
}
public class OnlineStockSpan{
	public static void main(String[] args){
		StockSpanner s = new StockSpanner();
        int[] A = {100, 80, 60, 70, 60, 75, 85};
        for(int a : A){
            System.out.println(s.next(a));
        }
	}
}
