//Leetcode problem 482 License Key Formatting
//Solution written by Xuqiang Fang on 26 April, 2018 

class Solution{
    public String licenseKeyFormatting(String S, int K) {
        char[] ch = S.toCharArray();
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i=ch.length-1; i>=0; --i){
            if(sb.length() < K && ch[i] != '-'){
                if(ch[i]>='a' && ch[i]<='z')
                    sb.insert(0,Character.toUpperCase(ch[i]));
                else
                    sb.insert(0,ch[i]);
            } 
            else if(sb.length() == K){
                System.out.println("here");
                result.insert(0,sb.toString());
                result.insert(0,'-');
                sb = new StringBuilder();
                if(ch[i] != '-'){
                    if(ch[i]>='a' && ch[i]<='z')
                        sb.insert(0,Character.toUpperCase(ch[i]));
                    else
                        sb.insert(0,ch[i]);
                }
            }
        }
        result.insert(0, sb.toString());
        String ret = result.toString();
        if(ret.length()>0 && ret.charAt(0) == '-')
            return ret.substring(1);
        return ret;
    }	
}

public class LicenseKey{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "--a-a-a-a--";
        System.out.println(s.licenseKeyFormatting(S, 2));
	}
}
