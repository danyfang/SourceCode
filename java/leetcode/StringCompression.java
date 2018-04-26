//Leetcode problem 443 String Compression
//Solution written by Xuqiang Fang on 25 April, 2018 

class Solution{
    public int com(char[] chars){
        int[] freq = new int[128]; 
        for(char c : chars){
            freq[c]++;
        }
        int index = 0;
        for(int i=0; i<128; ++i){
            if(freq[i]>0){
                chars[index++] = (char)i;
                System.out.println(freq[i]);
                if(freq[i]>1){
                    for(char c : String.valueOf(freq[i]).toCharArray()){
                        chars[index++] = c;
                    }
                }
            }
        }
        return index;
    }	

    public int compress(char[] chars){
        if(chars == null || chars.length == 0)
            return 0;
        int n = chars.length;

        int prev = 0;//reference for the beginning of repeating characters
        int index = 0;// the next position in original chars that is available to be inserted
        for(int i=1; i<n; ++i){
            if(chars[i] == chars[prev]){//the same character
                continue;
            }
            else if(i - prev > 1){//different characters, repeated more than once
                chars[index++] = chars[prev];
                for(char c : String.valueOf(i-prev).toCharArray()){
                    chars[index++] = c; 
                } 
                prev = i;
            }
            else{//different character, just once
                chars[index++] = chars[prev++];
            }
        }
        chars[index++] = chars[prev];
        if(n - prev > 1){
            for(char c : String.valueOf(n-prev).toCharArray()){
                chars[index++] = c;
            }
        }

        return index;
    }
}

public class StringCompression{
	public static void main(String[] args){
		Solution s = new Solution();
        char[] chars = {'a','a','b','b','b','c','c','c'};
        char[] ch = {'a','b','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] ch2 = {'a','b','b','b','c','a','b'};
        char[] ch3 = {'a','b','c','d','e','f','g'};
        System.out.println(s.compress(ch2));
        for(char c : ch2){
            System.out.println(c);
        }
        System.out.println(s.compress(ch3));
        for(char c : ch3){
            System.out.println(c);
        }
	}
}
