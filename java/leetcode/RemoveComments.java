//Leetcode problem 722 Remove Comments
//Solution written by Xuqiang Fang on 31 May, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean in = false;
        StringBuilder sb = new StringBuilder();
        for(String s : source){
            for(int i=0; i<s.length(); ++i){
                if(in){
                    if(s.charAt(i) == '*' && i < s.length()-1 && s.charAt(i+1) == '/'){
                        in = false;
                        i++;
                    }
                }
                else{
                    if(s.charAt(i) == '/' && i < s.length()-1 && s.charAt(i+1) == '/'){
                        break;
                    }
                    else if(s.charAt(i) == '/' && i < s.length()-1 && s.charAt(i+1) == '*'){
                        in = true;
                        i++;
                    }
                    else{
                        sb.append(s.charAt(i));
                    }
                }
            } 
            if(!in && sb.length() > 0){
                ans.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return ans;
    }
}

public class RemoveComments{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        System.out.println(s.removeComments(source));
	}
}
