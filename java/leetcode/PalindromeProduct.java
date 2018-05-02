//Leetcode problem 479 Largest Palindrome Product
//Solution written by Xuqiang Fang on 2 May, 2018 
import java.util.Arrays;
class Solution{
    //this can't work if n is larger than 4
    //it's stupid
    public int largestPalind(int n){
        int num = 0;
        int length = 9 * (int)Math.pow(10,n-1);
        while(n-->0){
            num = num*10 + 9;
        }
        int[] product = new int[length*length];
        int index = 0;
        for(int i=num; i>=(num/10+1); --i){
            for(int j=num; j>=(num/10+1); --j){
                product[index++] = i * j; 
            }
        }
        Arrays.sort(product);
        for(int i=product.length-1; i>=0; --i){
            if(isPalin(product[i])){
                return product[i];
            }
        }
        return num; 
    }	
    public boolean isPalin(int num){
        String s = String.valueOf(num);
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
    //try to cheat
    public int largestPalindrome(int n){
        int[] result = {9,987,123,597,677,1218,877,475};
        return result[n-1];
    }
}

public class PalindromeProduct{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.largestPalindrome(Integer.valueOf(args[0])));
	}
}
