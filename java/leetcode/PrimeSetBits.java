//Leetcode problem 762 Prime Number of Set Bits in Binary Representation
//Solution written by Xuqiang Fang on 10 May, 2018
import java.util.HashSet;
import java.util.Set;
class Solution{
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> set = new HashSet<>();
        int[] prime = {2,3,5,7,11,13,17,19,23,29,31};
        for(int i : prime){
            set.add(i);
        }
        
        int res = 0;
        for(int i=L; i<=R; ++i){
            int count = Integer.bitCount(i);
            if(set.contains(count)){
                res++;
            }
        }

        return res;
    }
}

public class PrimeSetBits{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.countPrimeSetBits(5,15));
	}
}
