//Leetcode problem 402 Remove K Digits
//Solution written by Xuqiang Fang on 22 April, 2018 

class Solution{
    //This solution causes runtime error stackoverflow
    public String removeK(String num, int k){
        if(num == null || num.length() == 0 || num.length() == k)
            return "0";
        if(k == 0)
            return num;
        //k >=1, num.length()>=2 
        int index = 0;
        if(num.charAt(1) == '0'){
            index = 1;
            while(++index < num.length() && num.charAt(index) == '0'){}
        }
        if(index >= 1){
            return removeKdigits(num.substring(index, num.length()), k-1);
        }
        if(index == 0){
            char[] ch = num.toCharArray();
            for(int i=0; i<ch.length-1; ++i){
                if(ch[i] > ch[i+1]){
                    return removeKdigits(num.substring(0,i)+num.substring(i+1,ch.length), k-1);
                }
            }
        }
        return removeKdigits(num.substring(0,num.length()-1),k-1);
    }	

    public String removeKDigits(String num, int k){
        if(num == null || num.length() == 0 || num.length() == k)
            return "0";
        if(k == 0)
            return num;
        char[] ch = num.toCharArray();
        
    }
}

public class RemoveKDigits{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.removeKdigits(String.valueOf(args[0]), Integer.valueOf(args[1])));
	}
}
