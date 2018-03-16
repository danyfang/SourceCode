//Leetcode problem 461 Hamming Distance
//Solution written by Xuqiang Fang on 2 March 2018
/*
The Hamming distance between two integers is the number of positions at
which the corresponding bits are different.
Given x and y calculate the hamming distance 
0<=x,y<=2^31
*/

import java.lang.Integer;

class Solution{
	public int hammingDistance(int x, int y){
		return Integer.bitCount(x^y);
		}	

}

public class HammingDistance{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.hammingDistance(1,9));
	}
}
