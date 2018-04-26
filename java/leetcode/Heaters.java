//Leetcode problem 475 Heaters
//Solution written by Xuqiang Fang on 26 April, 2018
import java.util.Arrays;
class Solution{
    public int findRadius(int[] houses, int[] heaters){
        if(houses == null || houses.length == 0 || heaters == null || heaters.length == 0)
            return 0;

        //O(n^2) solution
        // for each house, among distace to all heaters, select the min one
        // for all houses, select the biggest one
        /*
        int radius = 0;
        for(int i=0; i<houses.length; ++i){
            int distance = Integer.MAX_VALUE;
            for(int j=0; j<heaters.length; ++j){
                distance = Math.min(distance, Math.abs(houses[i]-heaters[j])); 
            }
            radius = Math.max(radius, distance);
        }
        return radius;
        */

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int i = 0;//this points to the current heater's index which is close to 
        //current house

        for(int house : houses){
            while(i < heaters.length - 1 && heaters[i] + heaters[i+1] < house * 2){
                i++;
            }

            radius = Math.max(radius, Math.abs(heaters[i]-house));
        }
        return radius;
    }	

    public int find(int[] houses, int[] heaters){
        Arrays.sort(heaters);
        int radius = 0;
        for(int house : houses){
            int index = Arrays.binarySearch(heaters, house);
            if(index < 0){
                index = -(index + 1);
            }
            int dis1 = index - 1 >= 0 ? house - heaters[index-1] : Integer.MAX_VALUE;
            int dis2 = index < heaters.length ? heaters[index] - house: Integer.MAX_VALUE;
            radius = Math.max(radius, Math.min(dis1, dis2));
        }
        return radius;
    }
}

public class Heaters{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] houses = {1,100,101};
        int[] heaters = {100};
        System.out.println(s.find(houses, heaters));
	}
}
