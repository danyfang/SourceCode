//Leetcode problem 295 Find Median from Data Stream
//Solution written by Xuqiang Fang on 5 June, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/*
* The idea is to maintain two heaps, one max heap to maintain elements from lower half and 
* one min heap to maintain elements from higher half
* Think it this way: we need the min from the higher half (min queue) and max from the lower half(max queue)
*/
class MedianFinder {
    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<>((a,b)->(b-a)); 
        min = new PriorityQueue<>(); 
        median = 0;
    }
    
    public void addNum(int num) {
        if(max.size() > min.size()){
            if(num < median){
                min.offer(max.poll());
                max.offer(num);
            }
            else{
                min.offer(num);
            }
            median = (double)(max.peek()+min.peek()) / 2.0;
        }     
        else if(max.size() < min.size()){
            if(num > median){
                max.offer(min.poll());
                min.offer(num);
            }
            else{
                max.offer(num);
            }
            median = (double)(max.peek()+min.peek()) / 2.0;
        }
        else{
            if(num > median){
                min.offer(num);
                median = (double)min.peek();
            }
            else{
                max.offer(num);
                median = (double)max.peek();
            }
        }
    }
    
    public double findMedian() {
        return median; 
    }

    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;
    private double median;
}
public class DataStreamMedian{
	public static void main(String[] args){
		MedianFinder s = new MedianFinder();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        for(int i : nums){
            s.addNum(i);
            System.out.println(s.findMedian());
        }
	}
}
