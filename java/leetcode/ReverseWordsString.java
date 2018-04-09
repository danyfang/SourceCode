//Leetcode problem 151 Reverse Words in a String
//Solution written by Xuqiang Fang on 

class Solution{
    public String reverseWords(String s){
        if(s == null || s.length() <= 0)
            return s;
        char[] ch = s.toCharArray();
        int end = ch.length - 1;
        int begin = end;
        String result = "";
        while(end > 0 && begin > 0){
            begin--;
            if(ch[end] == ' '){
                if(ch[begin] == ' '){
                    continue;
                }
            }else{
                if(ch[begin] != ' '){
                    continue;
                }
            }
            result += String.valueOf(ch, begin+1, end-begin);
            //System.out.println(result);
            //System.out.println("end " + end);
            //System.out.println("begin " + begin);
            end = begin;
        }
        //System.out.println("end " + end);
        result += String.valueOf(ch, 0, end+1);
        ch = result.toCharArray();
        result = "";
        begin = 0;
        end = 0;
        while(begin < ch.length ){
            if(ch[begin] != ' '){
                end = begin + 1;
                while(end < ch.length && ch[end] != ' '){
                    end++;
                }
                result += String.valueOf(ch,begin,end-begin);
                result += " ";
                begin = end;
            }
            begin++;
        }
        if(result.length() >= 1)
            return result.substring(0, result.length()-1);
        return result;
    }	
}

public class ReverseWordsString{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "     ";
        char[] ch = S.toCharArray();
        //System.out.println(String.valueOf(ch, 0, 1));
        System.out.println(s.reverseWords(S));
        System.out.println(s.reverseWords(S).length());
	}
}
