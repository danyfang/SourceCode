//Leetcode problem 789 Escape The Ghosts
//Solution written by Xuqiang Fang on 21 May, 2018
class Solution{
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int m = target[0];
        int n = target[1];
        int min = Integer.MAX_VALUE;
        System.out.println("to reach the target, you have to move at least " + (m+n) + " steps");
        for(int[] g : ghosts){
            min = Math.min(min, Math.abs(m-g[0])+Math.abs(n-g[1]));
        }
        if(min <= Math.abs(m) + Math.abs(n)){
            return false;
        }
        return true;
    }
}

public class EscapeGhosts{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] ghosts = {{1,0},{0,3}};
        int[] target = {0,1};
        System.out.println(s.escapeGhosts(ghosts, target));
        System.out.println(s.escapeGhosts(new int[][]{{1,0}}, new int[]{2,0}));
        System.out.println(s.escapeGhosts(new int[][]{{2,0}}, new int[]{1,0}));
	}
}
