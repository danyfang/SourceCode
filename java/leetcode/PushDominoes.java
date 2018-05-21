//Leetcode problem 838 Push Dominoes
//Solution written by Xuqiang Fang on 20 May, 2018 
import java.util.Stack;
class Solution{
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        char[] ch = dominoes.toCharArray();
        Stack<Integer> stack = new Stack<>();
        boolean hasRight = false;
        for(int i=0; i<N; ++i){
            if(ch[i] == '.'){
                stack.push(i);
            } 
            else if(ch[i] == 'L'){
                if(hasRight){
                    int size = stack.size();
                    for(int j=0; j<size/2; ++j){
                        ch[stack.pop()] = 'L';
                    }
                    if(size % 2 != 0){
                        stack.pop();
                    }
                    for(int j=0; j<size/2; ++j){
                        ch[stack.pop()] = 'R';
                    }
                }
                else{
                    while(!stack.isEmpty()){
                        ch[stack.pop()] = 'L';
                    }
                }
                hasRight = false;
            }
            else{
                if(hasRight){
                    while(!stack.isEmpty()){
                        ch[stack.pop()] = 'R';
                    }
                }
                else{
                    stack.clear();
                }
                hasRight = true;
            }
        }
        if(hasRight){
            while(!stack.isEmpty()){
                ch[stack.pop()] = 'R';
            }
        }
        return String.valueOf(ch); 
    }
}

public class PushDominoes{
	public static void main(String[] args){
		Solution s = new Solution();
        String dominoes = ".L.R...LR..L..L....L..R..RL.....R......";
        String S = ".L.R...LR..L..";
        System.out.println(s.pushDominoes(dominoes));
        System.out.println(s.pushDominoes(S));
	}
}
