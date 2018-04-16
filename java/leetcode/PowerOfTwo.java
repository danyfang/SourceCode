//Leetcode problem 231 Power of Two
//Leetcode problem 342 Power of Four 
//Solution written by Xuqiang Fang on 13 April, 2018 

class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        if(n <= 0)
            return false;
        else{
            char[] ch = Integer.toBinaryString(n).toCharArray();
            for(char c : ch){
                if(c == '1')
                    count++;
            }
        }
        return count == 1 ? true : false;
    }
    public boolean isPowerOfFour(int n){
        if(n <= 0)
            return false;

        //use bit operations,
        /*
        Here is how to calcualte this m
        m = Math.pow(2,1)+Math.pow(2,3) + ... + Math.pow(2,29)
        */
        int m = 715827882;
        int count = 0;
        //use n & (n-1) can delete the lowest one, and if it becomes 0
        //it proves that there is only one 1 in number n
        if((n & m) == 0 && (n&(n-1)) == 0)
            return true;
        //return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        return false;
    }
    /*
    Note that for an integer N that is a power of 3 the following is true:
    For any M <= N that is a power of 3, M divides N.
    For any M <= N that is not a power 3, M does not divide N.
    */
    public boolean isPowerOfThree(int n){
        return n > 0 && 1162261467 % n == 0;    
    }
}
public class PowerOfTwo{
	public static void main(String[] args){
		Solution s = new Solution();
        //int x = 0x55555555;
        //System.out.println(x);
        System.out.println(s.isPowerOfFour(Integer.valueOf(args[0])));
	}
}
