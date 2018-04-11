//Leetcode problem 131 Palindrome Partitioning
//Solution written by Xuqiang Fang on 7 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
class Solution{
    //Solution exceeded time limit
    public List<List<String>> partition_(String s){
        List<List<String>> list = new ArrayList<>(); 
        if(s == null || s.length() <= 0)
            return list;
        int n = s.length();
        if(n == 1){
            List<String> temp = new ArrayList<>();
            temp.add(s);
            list.add(temp);
            return list;
        }
        List<List<String>> sub = partition(s.substring(0,n-1));
        list.addAll(sub);
        String last = s.substring(n-1,n);
        for(List<String> l : list){
            l.add(last);
        }
        List<List<String>> newList = new ArrayList<>();
        for(List<String> l : list){
            int size = l.size();
            //System.out.println(size);
            for(int i=size-2; i>=0; i--){
                if(isPalin(String.join("",l.subList(i,size)))){
                    List<String> one = new ArrayList<>();
                    //System.out.println(String.join("",l.subList(i,size)));
                    one.addAll(l.subList(0,i));
                    one.add(String.join("",l.subList(i,size)));
                    //System.out.println(one);
                    newList.add(one);
                }
            }
        }
        for(List<String> l : newList){
            if(!list.contains(l)){
                list.add(l);
            }
        }
        return list;
    }	


    //Very simple backtracking solution
    public List<List<String>> partition(String s){
        List<List<String>> list = new ArrayList<>();
        if(s == null || s.length() == 0)
            return list;
        dfs(list, new ArrayList<String>(), 0,s);
        return list;
    }
    private void dfs(List<List<String>> list, List<String> temp, int splitat, String s){
        if(splitat == s.length())
            list.add(new ArrayList<>(temp));
        for(int i=splitat; i<s.length(); i++){
            if(isPalin(s.substring(splitat, i+1))){
                temp.add(s.substring(splitat, i+1));
                dfs(list, temp, i+1, s);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalin(String s){
        for(int m=0, n=s.length()-1; m<=n; m++,n--){
            if(s.charAt(m) != s.charAt(n))
                return false;
        }
        return true;
    }

}

public class PalindromePart{
	public static void main(String[] args){
		Solution s = new Solution();
        //System.out.println(s.partition("ff"));
        //System.out.println(s.partition("aabcddc"));
        /*
        [["a","a","b","c","d","d","c"],["a","a","b","c","dd","c"],
        ["a","a","b","cddc"],["aa","b","c","d","d","c"],["aa","b","c","dd","c"],
        ["aa","b","cddc"]]
        */
        //System.out.println(s.partition("aabcb"));
        /*
        [["a","a","b","c","b"],["a","a","bcb"],["aa","b","c","b"],["aa","bcb"]]
        */
	}
}
