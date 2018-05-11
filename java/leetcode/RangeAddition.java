//Leetcode problem 598 Range Addition II
//Solution written by Xuqiang Fang on 
class Solution{
    public int maxCount(int m, int n, int[][] ops){
        int a = m;
        int b = n;
        for(int[] op : ops){
            a = Math.min(a, op[0]);
            b = Math.min(b, op[1]);
        }

        return a * b;
    }
}

public class RangeAddition{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] ops = {{2,2},{3,3}};
        System.out.println(s.maxCount(3,3,ops));
	}
}
