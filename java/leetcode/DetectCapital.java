//Leetcode problem 520 Detect Capital
//Solution written by Xuqiang Fang on 26 April, 2018 

class Solution{
    public boolean detectCapitalUse(String word){
        if(word.length() == 0)
            return true;
        char[] ch = word.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z'){//first lower, then all must be lower
            for(char c : ch){
                if(c < 'a' || c > 'z')
                    return false;
            }
        }
        else if(ch[0]>='A' && ch[0]<='Z'){//first capital
            if(ch.length > 1 && ch[1] >= 'a' && ch[1] <= 'z'){//second lower case
                for(int i=2; i<ch.length; ++i){
                    if(ch[i]<'a' || ch[i]>'z')
                        return false;
                }
            }
            else{//all capitals
                for(char c : ch){
                    if(c <'A' || c>'Z')
                        return false;
                }
            }
        }
        return true;
    }	
}

public class DetectCapital{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.detectCapitalUse(args[0]));
	}
}
