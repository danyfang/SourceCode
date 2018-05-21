//Leetcode problem  632 Smallest Range
//Solution written by Xuqiang Fang on 19 May, 2018
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
class Element{
    int firstIndex;
    int secondIndex;
    int value;
    Element(int i, int j, int v){
        firstIndex = i;
        secondIndex = j;
        value = v;
    }
}
class Solution{
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        if(k == 1){
            return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
        }
        PriorityQueue<Element> minQueue = new PriorityQueue<>((a,b)->(a.value-b.value));
        PriorityQueue<Element> maxQueue = new PriorityQueue<>((a,b)->(b.value-a.value));
        int lower = 0;
        int higher = Integer.MAX_VALUE;
        for(int i=0; i<k; ++i){
            Element ele = new Element(i, 0, nums.get(i).get(0));
            minQueue.offer(ele);
            maxQueue.offer(ele);
        }
        /*
        while(!maxQueue.isEmpty()){
            System.out.println(maxQueue.poll().value);
        }
        */
        while(true){
            Element min = minQueue.poll();
            Element max = maxQueue.peek();
            if(max.value-min.value<higher-lower){
                lower = min.value;
                higher = max.value;
            }
            int updateIndex = min.secondIndex;
            if(++updateIndex >= nums.get(min.firstIndex).size()){
                break;
            }
            else{
                maxQueue.remove(min);
                //System.out.println("remove element :" + min.value);
                int value = nums.get(min.firstIndex).get(updateIndex);
                Element ele = new Element(min.firstIndex,updateIndex, value);
                minQueue.offer(ele);
                maxQueue.offer(ele);
            }
        }

        return new int[]{lower, higher};
    }
}

public class SmallestRange{
	public static void main(String[] args){
		Solution s = new Solution();
        List<Integer> list1 = Arrays.asList(4,10,15,24,26);
        List<Integer> list2 = Arrays.asList(0,9,12,20);
        List<Integer> list3 = Arrays.asList(5,18,22,30);
        List<List<Integer>> nums = Arrays.asList(list1, list2, list3);
        int[] range = s.smallestRange(nums);
        System.out.println(range[0] + "\t" + range[1]);
	}
}
