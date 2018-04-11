//Leetcode problem 811 Subdomain Visit Count
//Solution written by Xuqiang Fang on 10 April, 2018 
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        if(cpdomains == null || cpdomains.length == 0)
            return list;
        Map<String, Integer> map = new HashMap<>();
        for(String s : cpdomains){
            List<String> temp = split(s);  
            int x = Integer.valueOf(temp.get(0));
            for(int i=1; i<temp.size(); i++){
                String t = temp.get(i);
                int y = map.getOrDefault(t,0);
                map.put(t, x+y);
            }
        }
        map.forEach((k,v)->list.add(""+v+" "+k));
        return list;
    }
    public List<String> split(String s){
        List<String> list = new ArrayList<>();
        String[] str = s.split("[\\.|\\s]");
        list.add(str[0]);
        String temp = "";
        for(int i=1; i<str.length; i++){
            for(int j=i; j<str.length; j++){
                temp = temp + str[j] + "."; 
            }
            temp = temp.substring(0, temp.length()-1);
            list.add(temp); 
            temp = "";
        }
        return list;
    }
}

public class SubdomainCount{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(s.subdomainVisits(cpdomains));
        //System.out.println(s.split(cpdomains[0]));
        s.split(cpdomains[0]);
	}
}
