//Leetcode problem 258 Add Digits
//Solution written by Xuqiang Fang on 14 April, 2018

class Solution{
    public int addDigits(int num){
        char[] array = String.valueOf(num).toCharArray();
        int sum = 0;
        for(char c : array){
            sum += c - '0'; 
        }
        if(sum < 10)
            return sum;
        return addDigits(sum);
    }	
    public int add(int num){
        return (num-1) % 9 +1 ;
    }
}

public class AddDigits{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.addDigits(Integer.valueOf(args[0])));
        System.out.println(s.add(Integer.valueOf(args[0])));
	}
}
