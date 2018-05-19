//Leetcode problem 553 Optimal Division
//Solution written by Xuqiang Fang on 19 May, 2018
class Solution{
    public String optimalDivision(int[] nums){
        StringBuilder sb = new StringBuilder(String.valueOf(nums[0]));
        if(nums.length == 2){
            sb.append("/");
            sb.append(nums[1]);
            return sb.toString();
        }
        int index = 1;
        boolean once = true;
        while(index < nums.length){
            sb.append("/"); 
            if(once){
                sb.append("(");
                once = false;
            }
            sb.append(nums[index++]);
        }
        if(!once){
            sb.append(")");
        }
        return sb.toString();
    }
}

public class OptimalDivision{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1000,100,10,2};
        System.out.println(s.optimalDivision(nums));
	}
}
