//Leetcode problem 592 Fraction Addition and Subtraction
//Solution written by Xuqiang Fang on 28 April, 2018 

class Solution{
    public String fractionAddition(String expression){
        if(expression == null || expression.length() == 0)
            return "0/1";
        char[] nums;
        if(expression.charAt(0) == '-')
            nums = expression.toCharArray();
        else
            nums = ("+"+expression).toCharArray();
        int left = 0;
        int right = 1;
        String result = "0/1";
        while(right < nums.length){
            if(nums[right] != '-' && nums[right] != '+'){
                right++;
                continue;
            }
            else{
                result = calculate(result, String.valueOf(nums,left+1,right-left-1), nums[left]);
                left = right;
                right++;
            }
        }
        result = calculate(result, String.valueOf(nums, left+1, right-left-1), nums[left]);
        return result; 
    }	
    public String calculate(String a, String b, char operator){
        String[] a_num = a.split("\\/");
        String[] b_num = b.split("\\/");
        int a0 = Integer.valueOf(a_num[0]);
        int a1 = Integer.valueOf(a_num[1]);
        int b0 = Integer.valueOf(b_num[0]);
        int b1 = Integer.valueOf(b_num[1]);
        int nomi = 0;
        if(operator == '+')
            nomi = a0 * b1 + a1 * b0;
        else 
            nomi = a0 * b1 - a1 * b0;
        int deno = a1 * b1;
        int divisor = gcd(nomi, deno);
        nomi = nomi / divisor;
        deno = deno / divisor;

        return nomi + "/" + deno; 
    }
    public int gcd(int a, int b){
        int temp;
        int num1 = Math.abs(a);
        int num2 = Math.abs(b);
        while(num1 > 0){
            temp = num1;
            num1 = num2 % num1;
            num2 = temp;
        }
        return num2;
    }
}

public class FractionAdditionSubtraction{
	public static void main(String[] args){
		Solution s = new Solution();
        //System.out.println(s.gcd(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
        System.out.println(s.fractionAddition(args[0]));
	}
}
