//Leetcode problem 717 1-bit and 2-bit Characters
//Solution written by Xuqiang Fang on 
class Solution{
    public boolean isOneBitCharacter(int[] bits){
        int n = bits.length;
        int index = 0;
        while(index < n){
            if(bits[index] == 0){
                index++;
                if(index == n)
                    return true;
            }
            else{
                index = index + 2;
            }
        }
        return false;
    }
}

public class OneBitTwoBit{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] bits = {1,1,1,0};
        int[] nums = {1,0,0};
        System.out.println(s.isOneBitCharacter(bits));
        System.out.println(s.isOneBitCharacter(nums));
	}
}
