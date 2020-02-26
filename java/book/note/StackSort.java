import java.util.*;
public class StackSort{
    public List<Integer> Sort(Stack<Integer> s){
        Stack<Integer> ans = new Stack<Integer>();
        int head, temp;
        while(!s.empty()){
            head = s.peek();
            s.pop();
            while(!ans.empty() && ans.peek() > head){
                s.push(ans.peek());
                ans.pop();
            }
            ans.push(head);
        }
        return ans;
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,9,3,7,4,6,2,6,3,8};
        Stack<Integer> s = new Stack<Integer>();
        StackSort ss = new StackSort();
        for(int a : arr){
            s.push(a);
        }
        List<Integer> ans = ss.Sort(s);
        for(int a : ans){
            System.out.println(a);
        }
    }
}
