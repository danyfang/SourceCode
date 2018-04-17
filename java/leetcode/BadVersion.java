//Leetcode problem No278 First Bad Version
//Solution written by Xuqiang Fang on 17 April, 2018 
class VersionControl{
    public boolean isBadVersion(int version){
        return version >= 10 ? true : false;
    }
}
class Solution extends VersionControl{
    public int firstBadVersion(int n){
        if(!isBadVersion(n))
            return -1;//none of them is bad
        int l = 1;
        int r = n;
        int m = l + (r - l) / 2 ;
        while(l < r){
            m = l + (r - l) / 2;
            if(isBadVersion(m))
                r = m;
            else 
                l = m + 1;
            if(l == r)
                return l;
        }
        return r;
    }	
}

public class BadVersion{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.firstBadVersion(Integer.valueOf(args[0])));
	}
}
