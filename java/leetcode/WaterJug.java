//Leetcode problem 365 Water and Jug Problem
//Solution written by Xuqiang Fang on 28 March 2018 

class Solution{
	public boolean canMeasureWater(int x, int y, int z){
		if(x + y < z)
			return false;
		if(x == z || y == z || x + y == z)
			return true;

		return z%GCD(x, y) == 0;
	}	
	public int GCD(int a, int b){
		while( b != 0){
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}

public class WaterJug{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.canMeasureWater(3,5,4));
	}
}
