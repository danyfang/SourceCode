//Leetcode problem 216 Combination Sum III
//Leetcode problem 377 Combination Sum IIII
//Solution written by Xuqiang Fang on 5 April, 2018 
import java.util.ArrayList;
import java.util.List;
class Solution{
    //Solution provided by user@tinawma
    public List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> list = new ArrayList<>();
        if(n < k || k * 9 < n)
            return list;
        combination(list, new ArrayList<>(), k, n, 1);
        return list;
    }	
    private void combination(List<List<Integer>> list, List<Integer> temp, int k, int n, int index){
        if(temp.size() == k && n == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index; i<=9 && k>0 && n>0; i++){
            temp.add(i);
            combination(list, temp, k, n-i, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public int combinationSum4(int[] nums, int target){
    
    }
}

public class CombinationSum{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.combinationSum3(3,7));
	}
}
