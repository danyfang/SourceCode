//Leetcode problem 120 Triangle
//Solution written by Xuqiang Fang on 4 April 2018
import java.util.ArrayList;
import java.util.List;
class Solution{
    public int minimumTotal(List<List<Integer>> triangle){
        int result = 0;
        int row = triangle.size();
        List<Integer> prev = triangle.get(0);
        List<Integer> next = triangle.get(0);
        for(int i=1; i<row; i++){
            next = triangle.get(i);
            int size = next.size();
            next.set(0, prev.get(0)+next.get(0));
            next.set(size-1, prev.get(size-2)+next.get(size-1));
            for(int j=1; j<size-1; j++){
               int temp = prev.get(j-1) > prev.get(j) ? prev.get(j) : prev.get(j-1);
               next.set(j, temp+next.get(j));
            }
            prev = next;
        }
        result = next.get(0);
        for(int i : next){
            result = i > result ? result : i;
        }
        return result;
    }	
}

public class Triangle{
	public static void main(String[] args){
		Solution s = new Solution();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(6);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(8);
        l4.add(3);
        l4.add(1);

        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        System.out.println(s.minimumTotal(list));
	}
}
