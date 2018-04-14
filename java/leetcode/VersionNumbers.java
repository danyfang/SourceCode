//Leetcode problem 164 Compare Version Numbers
//Solution written by Xuqiang Fang on 12 April, 2018 
//Strings are non-empty and only contains digits and '.'
class Solution{
    int compareVersion(String version1, String version2){
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n = Math.min(s1.length, s2.length);
        int m = Math.max(s1.length, s2.length);
        for(int i=0; i<n; i++){
            if(Integer.valueOf(s1[i]) == Integer.valueOf(s2[i]))
                continue;
            if(Integer.valueOf(s1[i]) > Integer.valueOf(s2[i]))
                return 1;
            if(Integer.valueOf(s1[i]) < Integer.valueOf(s2[i]))
                return -1;
        }
        if(s1.length > s2.length){
            for(int i=n; i<m; i++){
                if(Integer.valueOf(s1[i]) == 0)
                    continue;
                return 1;
            }
        }
        else{
            for(int i=n; i<m; i++){
                if(Integer.valueOf(s2[i]) == 0)
                    continue;
                return -1;
            }
        }
        return 0;
    }	
}

public class VersionNumbers{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.compareVersion(args[0], args[1]));
	}
}
