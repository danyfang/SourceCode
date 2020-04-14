import java.util.Stack;

public class GetMinStack{
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public boolean isEmpty(){
	return this.stack.isEmpty();
    }
    public  GetMinStack(){
	this.stack = new Stack<>();
	this.min = new Stack<>();
    }
    public void push(int v){
	this.stack.push(v);
	if(this.min.isEmpty()){
	    this.min.push(v);
	}
	else if(v <= this.getMin()){
	    this.min.push(v);
	}
    }
    public void pop(){
	if (this.stack.isEmpty())
	    throw new RuntimeException("Your stack is already empty");
	int ans = this.stack.pop();
	if(ans == this.getMin()){
	    this.min.pop();
	}
    }
    public int getMin(){
	if(this.min.isEmpty()){
	    throw new RuntimeException("You stack is already empty");
	}
	return this.min.peek();
    }

    public static void main(String[] args){
	System.out.println("hello world!");
	GetMinStack stack = new GetMinStack();
	stack.push(4);
	stack.push(7);
	stack.push(6);
	stack.push(9);
	stack.push(2);
	while(!stack.isEmpty()){
	    System.out.println(stack.getMin());
	    stack.pop();
	}
    }
}
