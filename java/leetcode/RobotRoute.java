//Leetcode problem 657 Judge Route Circle
//Solution written by Xuqiang Fang on 3 March 2018
//Solution accepted

class Solution{
	public boolean judgeCircle(String moves){
		if(moves == null || moves.length() ==0)
			return false;//didn't make a circle
		int x = 0;//the original place
		int y = 0;//the original place
		for(int i=0; i<moves.length(); i++){
			switch (moves.charAt(i)){
				case 'U':
					y++;
					break;
				case 'D':
					y--;
					break;
				case 'L':
					x--;
					break;
				case 'R':
					x++;
					break;
				default:
					break;
			}
		}
		return x==0 && y==0;
	}
}

public class RobotRoute{
	public static void main(String[] args){
		Solution s = new Solution();
		String a = "UDLR";
		System.out.println(s.judgeCircle(a));
		System.out.println(s.judgeCircle(null));
	}
}
