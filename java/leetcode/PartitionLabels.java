//Leetcode problem 763 Parition Labels
//Solution written by Xuqiang Fang on 7 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
class Solution{
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if(S == null)
            return list;

        HashMap<Character, Value> map = new HashMap<>();
        List<Character> order = new ArrayList<>();
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new Value(i,i));
                order.add(c);
            }
            else{
                map.get(c).last = i;
            }
        }
        int first = 0;
        int last = map.get(order.get(0)).last;
        for(int i=1; i<order.size(); i++){
            char c = order.get(i);
            if(map.get(c).first < last){
                last = last > map.get(c).last ? last : map.get(c).last;
            }
            else{
                list.add(last - first + 1);
                first = map.get(c).first;
                last = map.get(c).last;
            }
        }
        list.add(S.length()-first);
        return list;
    }	
    class Value{
        int first;
        int last;
        public Value(int x, int y){
            first = x;
            last = y;
        }
    }
}

public class PartitionLabels{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "ababcbacadefegdehijhklijjfdkkfdmdfdfdjkfdoooopppqqrrssttn";
        System.out.println(s.partitionLabels(S));
	}
}
