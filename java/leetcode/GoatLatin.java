//Leetcode problem 824 Goat Latin
//Solution written by Xuqiang Fang on 7 May, 2018
class Solution{
    public String toGoatLatin(String S){
        String[] str = S.split("\\s"); 
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length; ++i){
            String s = str[i];
            if(Character.toLowerCase(s.charAt(0)) == 'a' ||
            Character.toLowerCase(s.charAt(0)) == 'e' || 
            Character.toLowerCase(s.charAt(0)) == 'i' || 
            Character.toLowerCase(s.charAt(0)) == 'o' || 
            Character.toLowerCase(s.charAt(0)) == 'u'){
                s = s +"ma";
            }
            else{
                s = s.substring(1)+s.charAt(0)+"ma";
            }
            sb.append(s);
            int j=0; 
            while(j++ <= i){
                sb.append("a"); 
            }
            str[i] = sb.toString();
            sb.delete(0,sb.length());
        }

        sb.append(str[0]);
        for(int i=1; i<str.length; ++i){
            sb.append(" ");
            sb.append(str[i]);
        }
        return sb.toString();
    }
}

public class GoatLatin{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "I speak Goat Latin";
        System.out.println(s.toGoatLatin(S));
	}
}
