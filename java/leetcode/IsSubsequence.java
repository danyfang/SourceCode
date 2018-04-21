//Leetcode problem 392 Is Subsequence
//Solution written by Xuqiang Fang on 20 April, 2018 
import java.util.PriorityQueue;

class Solution{
    /*
    public boolean isSubsequence(String t, String s){
        PriorityQueue<Integer>[] order = new PriorityQueue[26]; 
        for(int i=0; i<26; i++){
            order[i] = new PriorityQueue<>((a,b)->a-b);
        }
        char[] s_arr = s.toCharArray();
        for(int i=0; i<s_arr.length; i++){
            order[s_arr[i]-'a'].offer(i);
        }
        int index = 0;
        for(char c : t.toCharArray()){
            PriorityQueue<Integer> queue = order[c-'a'];
            int temp = -1;
            while(!queue.isEmpty()){
                temp = queue.poll();
                if(index > temp)
                    continue;
                else{
                    index = temp;
                    break;
                }
            } 
            if(temp == -1 || index != temp){
                return false;
            }
        }
        return true;
    }	
    */
    public boolean is(String s, String t){
    //use two pointers
        if(s.length() == 0)
            return true;
        int is = 0;
        int it = 0;
        while(it < t.length()){
            if(s.charAt(is) == t.charAt(it)){
                is++;
                if(is == s.length())
                    return true;
            }
            it++;
        }
        return false;
    }
}

public class IsSubsequence{
	public static void main(String[] args){
		Solution s = new Solution();
        String str = "ac";
        String t = "ahbgdc";
        System.out.println(s.is(str, t));
	}
}
