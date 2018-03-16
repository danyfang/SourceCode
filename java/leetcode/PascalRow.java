//Leetcode problem 119 Pascal's Triangle II
//Solution written by Xuqiang Fang on 12 March 2018
//Solution accepted
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution{
	public List<Integer> generate(int numRows){
		List<Integer> result = new ArrayList<Integer>();
		int[] nums = new int[numRows+1];
		int[] prev = new int[numRows+1];
		nums[0] = 1;
		prev[0] = 1;

		int i = 1;
		while(i <= numRows){
			int j = 0;
			while(j < i){
				nums[j+1] = prev[j] + prev[j+1];
				j++;
			}
			i++;
			copy(nums, prev, numRows);
		}
		for(int x = 0; x <= numRows; x++){
			result.add(nums[x]);
		}
		return result;
	}	
	private void copy(int[] nums, int[] prev, int numRows){
		int i = 0;
		while(i <= numRows && nums[i] != 0){
			prev[i] = nums[i];
			i++;
		}
	}
}

public class PascalRow{
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
