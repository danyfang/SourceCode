//Leetcode problem 609 Find Duplicate File in System
//Solution written by Xuqiang Fang on 17 May, 2018

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class Solution{
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>(); 
        for(String path : paths){
            String[] p = path.split("\\s");
            for(int i=1; i<p.length; ++i){
                String file = p[i];
                String content = file.substring(file.indexOf("(")+1, file.indexOf(")"));
                String name = file.substring(0, file.indexOf("."));
                if(!map.containsKey(content)){
                    List<String> temp = new ArrayList<>();
                    map.put(content, temp);
                }
                map.get(content).add(p[0]+"/"+name+".txt");
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> l : map.values()){
            if(l.size() > 1){
                res.add(l);
            }
        }
        return res;
    }
}

public class DuplicateFile{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> res = s.findDuplicate(paths);
        for(List<String> l : res){
            System.out.println(l);
        }
	}
}
