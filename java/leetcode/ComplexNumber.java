//Leetcode problem 537 Complex Number Multiplication
//Solution written by Xuqiang Fang on 28 April, 2018 

class Solution{
    public String complexNumberMultiply(String a, String b){
        String[] arr = a.replace("i","").split("\\+"); 
        String[] brr = b.replace("i","").split("\\+"); 
        int a_real = Integer.valueOf(arr[0]);
        int b_real = Integer.valueOf(brr[0]);
        int a_comp = Integer.valueOf(arr[1]);
        int b_comp = Integer.valueOf(brr[1]);
        int real = a_real * b_real - a_comp * b_comp;
        int comp = a_real * b_comp + b_real * a_comp;
        String result = real + "+" + comp + "i";
        return result;
    }	
}

public class ComplexNumber{
	public static void main(String[] args){
		Solution s = new Solution();
        String a = "1+1i";
        String b = "1+1i";
        String c = "1+-1i";
        String d = "1+-1i";
        System.out.println(s.complexNumberMultiply(a,b));
        System.out.println(s.complexNumberMultiply(c,d));
	}
}
