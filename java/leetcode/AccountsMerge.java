//Leetcode problem 721 Accounts Merge
//Solution written by Xuqiang Fang on 15 may, 2018 

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution{
    private int groupId = 0;
    public List<List<String>> accountsMerge(List<List<String>> acts){
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        /** use treeset to get order between emails*/
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for(List<String> a : acts){
            for(int i=1; i<a.size(); ++i){
                parents.put(a.get(i), a.get(i));//each email is its own representative
                owner.put(a.get(i), a.get(0));
            }
        }
        for(List<String> a : acts){
            String p = find(a.get(1), parents);
            for(int i=1; i<a.size(); ++i){
                parents.put(find(a.get(i), parents), p);
            }
        }
        for(List<String> a : acts){
            String p = find(a.get(1), parents);//each email should have its final parent
            if(!unions.containsKey(p))
                unions.put(p, new TreeSet<>());
            for(int i=1; i<a.size(); ++i){
                unions.get(p).add(a.get(i));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(String p : unions.keySet()){
            List<String> emails = new ArrayList<>(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    
    //this recursive call will find each email's final parent
    private String find(String s, Map<String, String> p){
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}

public class AccountsMerge{
	public static void main(String[] args){
		Solution s = new Solution();
        List<String> john = Arrays.asList("John", "johnsmith@mail.com", "John00@mail.com");
        List<String> jon = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> jo = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> mary = Arrays.asList("Mary", "mary@mail.com");

        List<List<String>> accounts = Arrays.asList(john, jon, jo, mary);
        List<List<String>> res = s.accountsMerge(accounts);
        for(List<String> account : res){
            System.out.println(account);
        }
	}
}
