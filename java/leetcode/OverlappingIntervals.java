//Leetcode problem 435 Non-overlapping Intervals
//Solution written by Xuqiang Fang on 25 April, 2018 

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start;
    int end;
    Interval(){
        start = 0;
        end = 0;
    }
    Interval(int s, int e){
        start = s;
        end = e;
    }
}
class Solution{
    public int eraseOverlapIntervals(Interval[] intervals){
        if(intervals == null || intervals.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(Interval in : intervals){
            if(map.containsKey(in.start)){
                map.put(in.start, Math.min(map.get(in.start), in.end));
            }
            else{
                map.put(in.start, in.end);
            }
        }
        int count = 0;
        int[] allstart = new int[map.size()];
        int index = 0;
        for(int begin : map.keySet()){
            allstart[index++] = begin;
        }
        Arrays.sort(allstart);
        int prev = allstart[0];
        int inbetween = 0;
        for(int begin : allstart){
            if(map.get(begin) <= prev){
                inbetween++;
            }
            System.out.println(begin);
            if(begin >= prev){
                count++;
                prev = map.get(begin);
            }
            else if(map.get(begin) < prev){
                prev = map.get(begin);
            }
        }
        return intervals.length - count;
    }	


    //another solutioin provided by user@crickey180
    public int erase(Interval[] intervals){
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;
        for(int i=1; i<intervals.length; ++i){
            if(intervals[i].start >= end){
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
    class myComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval a, Interval b){
            return a.end - b.end;
        }
    }
}

public class OverlappingIntervals{
	public static void main(String[] args){
		Solution s = new Solution();
        Interval a = new Interval(1,2);
        Interval b = new Interval(2,3);
        Interval c = new Interval(3,4);
        Interval d = new Interval(1,3);
        Interval[] intervals = {c,b,a,d};
        System.out.println(s.eraseOverlapIntervals(intervals));
	}
}
