//Leetcode problem 557 Reverse Words in a String III
//Leetcode problem 541 Reverse String II
//Solution written by Xuqiang Fang on 25 April, 2018 

class Solution{
    public String reverseStr(String s, int k){
        int n = s.length();
        int m = n / (2 * k);
        int r = n % (2 * k);
        char[] ch = s.toCharArray();
        
        int i = 0;
        while(i < m){
            reverse(ch,i*2*k, (i*2+1)*k-1);
            i++;
        }
        if(r < k){
            reverse(ch, m*2*k, m*2*k+r-1);
        }
        else{
            reverse(ch, m*2*k, (m*2+1)*k-1);
        }

        return String.valueOf(ch);
    }
    public String reverseWords(String s){
        char[] ch = s.toCharArray();
        int i = 0; 
        int j = 0;
        int n = ch.length;
        while(j < n-1){
            if(ch[j] == ' '){
                reverse(ch,i, j-1);
                i = j+1;
            }
            j++;
        }
        reverse(ch,i,j);
        return String.valueOf(ch);
    }	

    public void reverse(char[] ch, int l, int r){
        while(l<r){
            char c = ch[l];
            ch[l] = ch[r];
            ch[r] = c;
            l++;
            r--;
        }
    }
}

public class ReverseWords{
	public static void main(String[] args){
		Solution s = new Solution();
        String str = "Let's take LeetCode Contest";
        String str2 = "abcdefg";
        //System.out.println(s.reverseWords(str));
        System.out.println(s.reverseStr(str2,2));
	}
}
