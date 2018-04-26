//Leetcode problem 455 Assign Cookies
//Solution written by Xuqiang Fang on 26 April, 2018 

import java.util.Arrays;

class Solution{
    public int findContentChildren(int[] g, int [] s){
        if(g == null || g.length ==0 || s == null || s.length ==0)
            return 0;
        Arrays.sort(g);    
        Arrays.sort(s);    
        int ans = 0;
        int index = 0;
        for(int i=0; i<g.length; ++i){
            while(index < s.length && s[index] < g[i]){
                index++;
            }
            if(index < s.length){
                ans++;
                index++;
            }
            if(index >= s.length){
                break;
            }
        }
        return ans;
        
    }	
}

public class AssignCookies{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] g = {1,2};
        int[] st = {1,2,3};
        System.out.println(s.findContentChildren(g,st));
	}
}
