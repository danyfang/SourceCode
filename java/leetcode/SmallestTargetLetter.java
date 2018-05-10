//Leetcode problem 744 Find Smallest Letter Greater Than Target
//Solution written by Xuqiang Fang on 10 May, 2018
class Solution{
    public char nextGreatestLetter(char[] letters, char target){
        int min = 26;
        char res = target;
        for(char c : letters){
            int temp = compare(c, target);
            if(temp < min){
                min = temp; 
                res = c;
            }
        }
        return res;
    }
    private int compare(char a, char b){
        int res = a - b;
        if(res <= 0){
            return res + 26;
        }
        return res;
    }
}

public class SmallestTargetLetter{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
