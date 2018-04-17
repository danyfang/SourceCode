//Leetcode problem 225 Implement Stack using Queues
//Leetcode problem 232 Implement Queue using Stacks 
//Solution written by Xuqiang Fang on 16 April, 2018 
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
class MyStack{
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>(); 
        backup = new LinkedList<Integer>(); 
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x); 
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result = -1;
        if(queue.size() == 0)
            return result;
        while(queue.size() > 1){
            backup.offer(queue.poll());
        }
        result = queue.poll();
        while(backup.size() > 0){
            queue.offer(backup.poll());
        }
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        if(queue.size() == 0)
            return -1;
        int result = -1;
        while(queue.size() > 1){
            backup.offer(queue.poll());
        }
        result = queue.poll();
        while(backup.size() > 0){
            queue.offer(backup.poll());
        }
        queue.offer(result);
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }	

    private Queue<Integer> queue;
    private Queue<Integer> backup;
}
class MyQueue{
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        back = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x); 
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack.size() == 0)
            return -1;
        while(stack.size() > 1){
            back.push(stack.pop());
        }
        int result = stack.pop();
        while(back.size() > 0){
            stack.push(back.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack.size() == 0)
            return -1;
        System.out.println("before peek " + stack.size());
        while(stack.size() > 1){
            back.push(stack.pop());
        }
        int result = stack.peek();
        while(back.size() > 0)
            stack.push(back.pop());
        System.out.println("after peek " + stack.size());
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.size() == 0; 
    }

    private Stack<Integer> stack;
    private Stack<Integer> back;
}

public class StackQueue{
	public static void main(String[] args){
        /*
        MyStack obj = new MyStack();
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        obj.push(7);
        obj.push(8);
        obj.push(9);
        System.out.println(obj.top());
        System.out.println(obj.empty());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.top());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println(obj.top());
        */


        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);
        q.push(7);
        q.push(8);
        System.out.println(q.empty());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
	}
}
