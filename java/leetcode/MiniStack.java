//Leetcode problem 155 Min Stack
//Solution written by Xuqiang Fang on 
import java.util.Stack;

class MinStack{
	public MinStack(){
		this.min = 0;
	}  	
	public MinStack(int x){
		
	}
	public void push(int x){
		stack.push(x);		
		this.min = x > min ? min : x;
	}
	public void pop(){
		stack.pop();	
	}
	public int top(){
		return stack.getFirst();	
	}
	public int getMin(){
		return this.min;	
	}
	private Stack<Integer> stack;
	private int min;
}

public class MiniStack{
	public static void main(String[] args){
		MinStack s = new MinStack();
		s.push(3);
		s.pop();
		System.out.println(s.top());
		System.out.println(s.getMin());
	}
}
