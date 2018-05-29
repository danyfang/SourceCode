//Leetcode problem  842 Split Array into Fibonacci Sequence
//Solution written by Xuqiang Fang on 28 May, 2018
import java.util.ArrayList;
import java.util.List;
class Solution{
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        if(S.length() < 3){
            return ans;
        }
        int n = S.length();
        for(int i=1; i<=n/2 && i<=10; ++i){
            for(int j=1; j<=(n-i)/2 && j<=10; ++j){
                if(dfs(ans, S, i, j)){
                    return ans;
                }
                ans.clear();
            }
        }
        return ans;
    }
    private boolean dfs(List<Integer> ans, String s, int i, int j){
        String a = s.substring(0,i);
        String b = s.substring(i,i+j);
        if(i > 1 && a.charAt(0) == '0'){
            return false;
        }
        if(j > 1 && b.charAt(0) == '0'){
            return false;
        }
        long x = Long.parseLong(a);
        long y = Long.parseLong(b);
        if(x > (long)Integer.MAX_VALUE || y > (long)Integer.MAX_VALUE || (x+y) > (long)Integer.MAX_VALUE){
            return false;
        }
        ans.add((int)x);
        String c = Integer.toString((int)x+(int)y);
        if(c.equals(s.substring(i+j))){
            ans.add((int)y);
            ans.add(Integer.parseInt(c));
            return true;
        }
        else if(s.substring(i+j).length() < c.length() || !s.substring(i+j,i+j+c.length()).equals(c)){
            return false;
        }
        return dfs(ans, s.substring(i), j, c.length());
    }
}

public class FibonacciSequence{
	public static void main(String[] args){
		Solution s = new Solution();
        String s1 = "11235813";
        String s2 = "123456579";
        System.out.println(s.splitIntoFibonacci(s1));
        System.out.println(s.splitIntoFibonacci(s2));
	}
}
