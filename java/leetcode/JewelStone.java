//Leetcode problem 771 Jewels and Stones
//Solution written by Xuqiang Fang on 3 March 2018

class Solution{
	public int numJewelsInStones(String J, String S){
		if(J.length()==0 || S.length()==0){
			return 0;
		}
		int nums = 0;
		for(int i=0; i<S.length(); i++){
			for(int j=0; j<J.length(); j++){
				if(S.charAt(i) == J.charAt(j)){
					nums++;
					break;
				}
			}
		}	
		return nums;
	}
}

public class JewelStone{
	public static void main(String[] args){
		Solution s = new Solution();
		String J = "z";
		String S = "ZZ";
		System.out.println(s.numJewelsInStones(J,S));
	}
}
