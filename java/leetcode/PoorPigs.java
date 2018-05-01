//Leetcode problem 458 Poor Pigs
//Solution written by Xuqiang Fang on 26 April, 2018
/*
With 2 pigs, poison killing in 15 minutes, and having 60 minutes, we can find the
poison in up to 25 buckets in the following way. Arrange the buckets in a 5×5 square:

 1  2  3  4  5
 6  7  8  9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
Now use one pig to find the row (make it drink from buckets 1, 2, 3, 4, 5, 
wait 15 minutes, make it drink from buckets 6, 7, 8, 9, 10, wait 15 minutes, etc).
Use the second pig to find the column (make it drink 1, 6, 11, 16, 21, then 
2, 7, 12, 17, 22, etc).
*/
//Solution referred from @StephanPorchman
class Solution{
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest){
        int pigs = 0;
        int unit = minutesToTest / minutesToDie + 1;
        int ability = 1;
        while(ability < buckets){
            ability *= unit;
            pigs++;
        }
        return pigs;
    }	
}

public class PoorPigs{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.poorPigs(7,5,10));
	}
}
