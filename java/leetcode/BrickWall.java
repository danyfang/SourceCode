//Leetcode problem 554 Brick Wall
//Solution written by Xuqiang Fang on 27 April, 2018

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution{
    public int leastBricks(List<List<Integer>> wall){
        if(wall == null || wall.size() == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(List<Integer> list : wall){
            int sum = 0;
            for(int i=0; i<list.size()-1; ++i){
                sum += list.get(i);
                System.out.print("sum = " + sum + "\t");
                map.put(sum, map.getOrDefault(sum,0)+1);
                max = Math.max(max, map.get(sum));
            }
            System.out.println("\n");
        }
        System.out.println(max);
        return wall.size()-max;
    }	
}

public class BrickWall{
	public static void main(String[] args){
		Solution s = new Solution();
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        System.out.println(s.leastBricks(wall));
	}
}
