//Leetcode problem 118 Pascal's Triangle
//Solution written by Xuqiang Fang on 12 March 2018
//Solution accepted
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution{
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> previous = new ArrayList<Integer>();
		if(numRows == 0 )
			return null;

		previous.add(1);
		result.add(previous);
		if(numRows == 1){
			return result;
		}
		int i = 1;
		while(i < numRows){
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			int j = 0;
			while(j <= i-2){
				list.add(previous.get(j)+previous.get(j+1));
				j++;
			}
			list.add(1);
			previous = list;
			result.add(list);
			i++;
		}
		return result;
	}	
}

public class PascalTriangle{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.generate(Integer.valueOf(args[0])));
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		//for(int i=0; i<3; i++)
		//	System.out.println(list.get(i));
	}
}
