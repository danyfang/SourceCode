//Leetcode problem 831 Masking Personal Information
//Solution written by Xuqiang Fang on 17 May, 2018
class Solution{
    public String maskPII(String S){
        if(S.indexOf('@') == -1){
            //phone number
            S = S.replaceAll("\\D", "");
            if(S.length() == 10){
                return "***-***-" + S.substring(6,10);
            }
            else if(S.length() == 12){
                return "+**-***-***-" + S.substring(8,12);
            }
            return "+***-***-***-" + S.substring(9,13);
        }
        //email
        String[] email = S.toLowerCase().split("@|\\.");
        String name1 = email[0];
        return name1.charAt(0)+"*****"+name1.charAt(name1.length()-1) + "@" + email[1] + "." + email[2];
    }
}

public class MaskInformation{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.maskPII("LeetCode@LeetCode.com"));
        System.out.println(s.maskPII("AB@qq.com"));
        System.out.println(s.maskPII("1(234)567-890"));
        System.out.println(s.maskPII("86-(10)12345678"));
        while(true){
            String input = System.console().readLine();
            if(input.equals("q"))
                break;
            System.out.println(s.maskPII(input));
        }
	}
}
