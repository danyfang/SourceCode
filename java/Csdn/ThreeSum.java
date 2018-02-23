import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>(); 
       	for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				for(int x=j+1; x<nums.length; x++){
					if(nums[x] == -(nums[i] + nums[j])){
						ArrayList<Integer> temp = new ArrayList<Integer>(3); 
						int second = nums[j];
						int min = nums[x];
						int max = nums[i]> nums[j] ? nums[i]:nums[j];
						max = max > nums[x] ? max:nums[x];
						if (max == nums[i]){
							second = nums[j] > nums[x] ? nums[j]:nums[x];	
							min = nums[j] > nums[x] ? nums[x] : nums[j];
						}
						else if (max == nums[j]){
							second = nums[i] > nums[x] ? nums[i]:nums[x];	
							min = nums[i] > nums[x] ? nums[x]:nums[i];
						}
						else if (max == nums[x]){
							second = nums[i] > nums[j] ? nums[i]:nums[j];	
							min = nums[i] > nums[j] ? nums[j]:nums[i];
						}
						temp.add(min);
						temp.add(second);
						temp.add(max);
						if(!result.contains(temp)){
							result.add(temp);
						}
					}
				}
			}
		} 
		return result;
    }
}
public class ThreeSum{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] input = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = s.threeSum(input);
		printLList(result);
		return;

	}
	public static void printList(List<Integer> a){
		for(int i=0; i< a.size(); i++){
			System.out.print(a.get(i) + " \t" );
		}
	}
	public static void printLList(ArrayList<ArrayList<Integer>> a){
		for(int i=0; i<a.size(); i++){
			printList(a.get(i));
			System.out.println("\n");
		}
	}
}
