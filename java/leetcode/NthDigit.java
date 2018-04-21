//Leetcode problem 400 Nth Digit
//Solution written by Xuqiang Fang on 21 April, 2018

class Solution{
    public int findNthDigit(int n){
        int m = find(n);
        System.out.println("It is in " + m + " digit number");
        //from 10000...{m digits} to 99999...{m digits}
        long total = 0;
        for(int i=1; i<m; i++){
            total += i * 9 * (long)Math.pow(10,i-1);
        }
        //System.out.println("total = " + total);
        int k = (int)(n - total);
        // it is the kth bit in a m-digit number
        long a = (long)Math.pow(10,m-1) + (k-1) / m ;
        System.out.println("It is in the " + ((k-1)/m+1) + " th number of " +m + " digit number");
        System.out.println("And the number is " + a);
        k = k - m *((k-1)/m);
        System.out.println("And it is the " + k +  " th digit of this number");

        return Integer.valueOf(String.valueOf(a).substring(k-1,k)); 
    }	
    public int find(int n){
        int N = 9;
        long digits = 0;
        int i = 0;//i denote current number of digits 
        while(n > digits){
            digits += (i+1) * N * (long)Math.pow(10, i); 
            i++;
        }
        return i;
    }
}

public class NthDigit{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.findNthDigit(Integer.valueOf(args[0])));
        //System.out.println(s.find(Integer.valueOf(args[0])));
	}
}
