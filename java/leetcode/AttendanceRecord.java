//Leetcode problem 551 Student Attendance Record I
//Solution written by Xuqiang Fang on 

class Solution{
    public boolean checkRecord(String s){
        if(s.length() == 0)
            return true;
        int count = 0;
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; ++i){
            if(ch[i] == 'A'){
                count++;
            } 
            if(count > 1){
                return false;
            }
            if(i>=1 && i<ch.length-1 && (ch[i-1] == 'L' && ch[i] == 'L' && ch[i+1] == 'L')){
                return false;
            }
        }

        return true;
    }	
}

public class AttendanceRecord{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
