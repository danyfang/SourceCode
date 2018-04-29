//Leetcode problem 646 Maximum Length of Pair Chain
//Solution written by Xuqiang Fang on 29 April, 2018 
import java.util.Arrays;
class Solution{
    public int findLongestChain(int[][] pairs){
        Arrays.sort(pairs, (a,b)->(a[1]-b[1]));
        int count = 1;
        int prev = pairs[0][1];
        for(int i=1; i<pairs.length; ++i){
            if(pairs[i][0] > prev){
                count++;
                prev = pairs[i][1];
            }
        }

        return count;
    }	
}
public class MaximumPairChain{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] pairs = {{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};
        System.out.println(s.findLongestChain(pairs));
	}
}
