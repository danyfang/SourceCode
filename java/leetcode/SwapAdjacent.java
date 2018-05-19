//Leetcode problem 777 Swap Adjacent in LR String
//Solution written by Xuqiang Fang on 19 May, 2018
//L can only be moved to the left, and R can only be moved to the right
class Solution{
    public boolean canTransform(String start, String end) {
        if(!start.replaceAll("X","").equals(end.replaceAll("X",""))){
            return false;
        }
        int SR_count = 0, SL_count = 0, ER_count = 0, EL_count = 0;
        for(int i=0; i<start.length(); ++i){
            if(start.charAt(i) == 'R'){
                SR_count++;
            }
            else if(start.charAt(i) == 'L'){
                SL_count++;
            }

            if(end.charAt(i) == 'R'){
                ER_count++;
            }
            else if(end.charAt(i) == 'L'){
                EL_count++;
            }

            if(ER_count > SR_count || SL_count > EL_count){
                return false;
            }
        }
        return true;
    }
}

public class SwapAdjacent{
	public static void main(String[] args){
		Solution s = new Solution();
        String start = "XXRXXLXXXX";
        String end = "XXXXRXXLXX";
        System.out.println(s.canTransform(start, end));
	}
}
