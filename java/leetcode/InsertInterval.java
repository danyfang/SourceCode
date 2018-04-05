//Leetcode problem 57 Insert Interval
//Leetcode problem 56 Merge Interval
//Solution written by Xuqiang Fang on 29 March 2018 

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Interval {
	int start;
	int end;
	Interval(){ start = 0; end  = 0;}
	Interval(int s, int e){
		start = s;
		end = e;
	}
}
class Solution{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> list = new ArrayList<Interval>();    
		if(intervals == null || intervals.size() <= 0){
			list.add(newInterval);
			return list;
		}
		int once = 1;
		for(Interval i : intervals){
			if(i.start <= newInterval.start)
				list.add(new Interval(i.start, i.end));
			else{
				if(once == 1){
					list.add(new Interval(newInterval.start, newInterval.end));
					once--;
				}
				list.add(new Interval(i.start, i.end));
			}
		}
		
		if(once == 1)
			list.add(new Interval(newInterval.start, newInterval.end));

		list = merge(list);

		return list;
    }	

	//Create new intervals
	public List<Interval> merge_(List<Interval> intervals) {
    	List<Interval> list = new ArrayList<>();    
		if(intervals.size() <= 1)
			return intervals;

		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for(Interval i : intervals){
			if(i.start <= end)
				end = Math.max(end, i.end);
			else{
				list.add(new Interval(start, end));
				start = i.start;
				end = i.end;
			}
		}
		list.add(new Interval(start, end));

		return list;
    }
	public List<Interval> merge(List<Interval> intervals){
		if(intervals == null || intervals.isEmpty())
			return intervals;

		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2){
				if(i1.start != i2.start)
					return i1.start - i2.start;
				return i1.end - i2.end;
			}
		});

		int i = 0;
		while(i < intervals.size() - 1){
			Interval cur = intervals.get(i);
			Interval next = intervals.get(i+1);
			if(next.start <= cur.end){
				int max = Math.max(next.end, cur.end);
				cur.end = max;
				intervals.remove(i+1);
			}
			else
				i++;
		}
		return intervals;
	}
}

public class InsertInterval{
	public static void main(String[] args){
		Solution s = new Solution();
		Interval a = new Interval(1,3);
		Interval b = new Interval(2,6);
		Interval c = new Interval(8,10);
		Interval d = new Interval(15,18);

		List<Interval> intervals = new ArrayList<>();
		/*
		intervals.add(a);
		intervals.add(b);
		intervals.add(c);
		intervals.add(d);
		*/	
		//print(s.merge(intervals));

		Interval h = new Interval(1,2);
		Interval i = new Interval(3,5);
		Interval j = new Interval(6,7);
		Interval k = new Interval(8,10);
		Interval l = new Interval(12,16);
		Interval m = new Interval(4,9);
		Interval n = new Interval(1,2);
		Interval o = new Interval(1,2);
		intervals.add(h);
		intervals.add(i);
		intervals.add(j);
		intervals.add(k);
		intervals.add(l);
		
		print(s.insert(intervals, m));
	}
	public static void print(List<Interval> intervals){
		if(intervals == null)
			return;
		for(Interval i : intervals){
			System.out.println("[" + i.start + "," + i.end + "]");	
		}
	}
}
