//Leetcode problem 394 Decode String
//Solution written by Xuqiang Fang on 20 April, 2018
import java.util.regex.Pattern;
import java.util.regex.Matcher;
class Solution{
    public String decodeString(String s){
         //the input string format is always valid
         //the idea is starting from the end, look for the first '['
        //recursive call
        if(s == null || s.length() == 0)
            return s;


        Pattern pattern = Pattern.compile("\\d+\\[\\w+\\]");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            System.out.println(matcher.group());
            return decodeString(s.replace(matcher.group(), unit(matcher.group())));
        }
        else
            return s;
    }	

    public String unit(String s){
        int num = Integer.valueOf(s.replaceAll("\\D","")); 
        String str = s.replaceAll("\\W","").replaceAll("\\d","");
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(str);
            num--;
        }
        return sb.toString();
    }

}

public class DecodeString{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.decodeString(args[0]));
	}
}
