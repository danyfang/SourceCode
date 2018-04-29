//Leetcode problem 599 Minimum Index Sum of Two Lists
//Solution written by Xuqiang Fang on 28 April, 2018 
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
class Solution{
    public String[] findRestaurant(String[] list1, String[] list2){
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int index = 2000;//as both lists are of length [1,1000]
        if(list1.length < list2.length){
            String[] temp = list1;
            list1 = list2;
            list2 = temp;
        }
        for(int i=0; i<list1.length; ++i){
            map.put(list1[i], i);
        }
        for(int i=0; i<list2.length; ++i){
            index = Math.min(index, i+map.getOrDefault(list2[i], 2000)); 
        }
        for(int i=0; i<list2.length; ++i){
            if(i + map.getOrDefault(list2[i], 2000) == index){
                result.add(list2[i]);
            }
        }
        String[] ret = new String[result.size()];
        for(int i=0; i<ret.length; ++i){
            ret[i] = result.get(i);
        }
        return ret;
    }	
}

public class MinimumIndexSum{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] res1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] res2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] res = s.findRestaurant(res1, res2);
        for(String t : res){
            System.out.println(t);
        }
	}
}
