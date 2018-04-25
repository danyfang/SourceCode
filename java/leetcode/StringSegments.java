//Leetcode problem 434 Number of Segments in a String
//Solution written by Xuqiang Fang on 25 April, 2018 

class Solution{
    public int countSegment(String s){
        s = s.trim();
        if(s.length() == 0)
            return 0;
        return s.split("\\s+").length;
    }	
}

public class StringSegments{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.countSegment(args[0]));
	}
}
