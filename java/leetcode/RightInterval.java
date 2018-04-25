//Leetcode problem 436 Find Right Interval
//Solution written by Xuqiang Fang on 25 April, 2018 
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

class Interval{
    int start;
    int end;
    Interval(){start = 0; end = 0;}
    Interval(int s, int e){start = s; end = e;}
}
class Solution{
    //Solution exceeded time limit
    public int[] findRight(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        int right = intervals[0].end;
        for(int i=0; i<intervals.length; ++i){
            map.put(intervals[i].start, i); 
            right = Math.max(right, intervals[i].end); 
        }            
        
        List<Integer> list = new ArrayList<>();
        /*
        Arrays.sort(intervals, new myComparator());
        for(int i=0; i<intervals.length; ++i){
            //System.out.println( "aaa " + intervals[i].start);
            boolean exist = false;
            for(int j=i+1; j<intervals.length; ++j){
                if(intervals[j].start >= intervals[i].end){
                    //System.out.println("j = " + j + " " + intervals[j].start);
                    list.add(map.get(intervals[j].start));
                    exist = true;
                    break;
                }
            }
            if(!exist){
                list.add(-1);
            }
        }
        */
        
        for(int i=0; i<intervals.length; ++i){
            int min = right;
            for(int j=0; j<intervals.length; ++j){
                if(intervals[j].start >= intervals[i].end){
                    min = Math.min(intervals[j].start, min);
                } 
            }
            if(min == right){
                list.add(-1);
            }
            else{
                list.add(map.get(min));
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<result.length; ++i){
            result[i] = list.get(i);
        }
        return result;
    }	


    //Solution provided by user@ivtoskov
    public int[] findRightInterval(Interval[] intervals){
        int[] result = new int[intervals.length];
        
        NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();
        for(int i=0; i<intervals.length; ++i){
            intervalMap.put(intervals[i].start, i);
        }
        
        for(int i=0; i<intervals.length; ++i){
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        return result;
    }
}

class myComparator implements Comparator<Interval>{
    @Override
    public int compare(Interval a, Interval b){
        return a.start - b.start;
    }
}

public class RightInterval{
	public static void main(String[] args){
		Solution s = new Solution();
        Interval a = new Interval(3,4);
        Interval b = new Interval(2,3);
        Interval c = new Interval(1,2);
        Interval d = new Interval(1,4);
        Interval e = new Interval(2,3);
        Interval f = new Interval(3,4);
        Interval[] intervals = {a,b,c};
        Interval[] intervals2 = {d,e,f};
        int[] result = s.findRightInterval(intervals);
        for(int i : result){
            System.out.println(i);
        }
        result = s.findRightInterval(intervals2);
        for(int i : result){
            System.out.println(i);
        }
	}
}
