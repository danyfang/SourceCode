//Leetcode problem 432 Reconstruct Original Digits from English
//Solution written by Xuqiang Fang on 27 April, 2018 

class Solution{
    public String originalDigits(String s){
        if(s == null || s.length() == 0)
            return s;
        /*
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 
        for(String st : number){
            for(char c : st.toCharArray()){
                alpha[c-'a']++;
            }
        }
        for(int i=0; i<26; ++i)
            System.out.print(String.valueOf((char)(i+'a')) + alpha[i] + " ");
        */
        int[] alpha = new int[26];
        for(char c : s.toCharArray()){
            alpha[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int[] digit = new int[10];
        digit[0] = alpha['z'-'a'];
        digit[1] = alpha['o'-'a']-alpha['z'-'a']-alpha['u'-'a']-alpha['w'-'a'];
        digit[2] = alpha['w'-'a'];
        digit[3] = alpha['g'-'a']-alpha['h'-'a'];
        digit[4] = alpha['u'-'a'];
        digit[5] = alpha['f'-'a']-alpha['u'-'a'];
        digit[6] = alpha['x'-'a'];
        digit[7] = alpha['s'-'a']-alpha['x'-'a'];
        digit[8] = alpha['g'-'a'];
        digit[9] = alpha['i'-'a']-(alpha['f'-'a']-alpha['u'-'a'])-alpha['x'-'a']-alpha['g'-'a'];
        for(int i=0; i<10; ++i){
            if(digit[i] != 0){
                int n = Math.abs(digit[i]);
                while(n-->0)
                    sb.append(i);
            }
        }
        /*
        //zero
        if(alpha['z'-'a']> 0){
            int n = alpha['z'-'a'];
            while(n-->0){
                sb.append("0");
            }
        }
        //one
        if(alpha['z'-'a']> 0){
            int n = alpha['z'-'a'];
            while(n-->0){
                sb.append("1");
            }
        }
        //two
        if(alpha['w'-'a']>0){
            int n = alpha['w'-'a'];
            while(n-->0){
                sb.append("2");
            }
        }
        //three
        if(alpha['g'-'a']-alpha['h'-'a']>0){
            int n = alpha['g'-'a']-alpha['h'-'a'];
            while(n-->0){
                sb.append("3");
            }
        }
        //four
        if(alpha['u'-'a']>0){
            int n = alpha['u'-'a'];
            while(n-->0){
                sb.append("4");
            }
        }

        //five
        if(alpha['f'-'a']-alpha['u'-'a']>0){
            int n = alpha['f'-'a'] - alpha['u'-'a'];
            while(n-->0){
                sb.append("5");
            }
        }
        //six
        if(alpha['x'-'a']>0){
            int n = alpha['x'-'a'];
            while(n-->0){
                sb.append("6");
            }
        }
        //seven
        if(alpha['s'-'a']-alpha['x'-'a']>0){
            int n = alpha['s'-'a'] - alpha['x'-'a'];
            while(n-->0){
                sb.append("7");
            }
        }
        //eight
        if(alpha['g'-'a']>0){
            int n = alpha['g'-'a'];
            while(n-->0){
                sb.append("8");
            }
        }
        //nine
        if(alpha['f'-'a']-alpha['u'-'a']>0){
            int n = alpha['f'-'a'] - alpha['u'-'a'];
            while(n-->0){
                sb.append("9");
            }
        }
        */
        return sb.toString();
    }	
}

public class EnglishToDigits{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.originalDigits(args[0]));
	}
}
