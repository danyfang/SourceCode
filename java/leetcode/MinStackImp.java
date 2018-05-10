//Leetcode problem 155 Min Stack
//Solution written by Xuqiang Fang on 10 May, 2018

import java.util.Stack;

class MinStack{
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>(); 
        min = new Stack<>(); 
    }
    
    public void push(int x) {
        stack.push(x); 
        if(min.isEmpty()){
            min.push(x);
        }
        else{
            min.push(Math.min(x, min.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return min.peek(); 
    } 

    private Stack<Integer> stack;
    private Stack<Integer> min;
}

public class MinStackImp{
	public static void main(String[] args){
		MinStack s = new MinStack();
        s.push(-4);
        s.push(-3);
        s.push(-7);
        System.out.println("s.getMin() = " + s.getMin());
        s.pop();
        System.out.println("s.getMin() = " + s.getMin());
        System.out.println("s.top() = " + s.top());
	}
}
