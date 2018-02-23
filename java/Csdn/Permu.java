import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       	Arrays.sort(nums); 
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>(nums.length);
		for(int i=0; i<nums.length; i++){
			temp.add(nums[i]);
		}
		result.add(temp);
		return result;
    }
}

public class Permu{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] out = {1,1,2,2};
		System.out.println(s.permuteUnique(out));
	}
}
