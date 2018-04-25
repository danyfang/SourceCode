//Leetcode problem 447 Number of Boomerangs
//Solution written by Xuqiang Fang on 25 April, 2018 
import java.util.HashMap;
import java.util.Map;
class Solution{
    public int numberOfBoomerangs(int[][] points){
        if(points == null || points.length == 0)
            return 0;
        int n = points.length;  
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                int d = distance(points[i], points[j]); 
                map.put(d,map.getOrDefault(d,0)+1);
            }

            for(int val : map.values()){
                result += val * (val-1);
            }
            map.clear();
        }

        return result;
    }	
    private int distance(int[] a, int[] b){
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}

public class Boomerangs{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.println(s.numberOfBoomerangs(points));
	}
}
