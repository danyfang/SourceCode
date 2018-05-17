//Leetcode problem 729 My Calendar I
//Leetcode problem 731 My Calendar II
//Solution written by Xuqiang Fang on 16 May, 2018
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
class MyCalendar {
    public MyCalendar() {
        booked = new TreeMap<>(); 
    }
    public boolean book(int start, int end) {
        Integer low = booked.floorKey(start);
        if(low != null && booked.get(low) > start) 
            return false;
        Integer high = booked.ceilingKey(start);
        if(high != null && high < end) 
            return false;
        booked.put(start, end);
        return true;
    }
    private TreeMap<Integer, Integer> booked;
}
/**
//Brutal force solution, O(n^2), a good method for checking interval overlapping
// is_overlap(s1, e1, s2, e2){return Math.max(s1,s2) < Math.min(e1,e2);}
class MyCalendar{
    public MyCalendar(){
        booked = new ArrayList<>(); 
    }
    public boolean book(int start, int end){
        for(int[] b : booked){
            if(Math.max(b[0], start) < Math.min(b[1], end))
                return false;
        } 
        booked.add(new int[]{start, end});
        return true;
    }
    List<int[]> booked;
}
*/
class MyCalendarTwo{
    public MyCalendarTwo() {
        booked = new ArrayList<>(); 
        overlap = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] b : overlap){
            if(Math.max(b[0], start) < Math.min(b[1], end)){
                return false;
            }
        }
        for(int[] b : booked){
            int low = Math.max(b[0], start);
            int high = Math.min(b[1], end);
            if(low < high){
                overlap.add(new int[]{low, high});
            }
        }
        booked.add(new int[]{start, end});
        return true;
    } 
    List<int[]> booked;
    List<int[]> overlap;
}

class MyCalendarThree{
    public MyCalendarThree() {
        map = new TreeMap<>(); 
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);
        int max = 0;
        int count = 0;
        for(int key : map.keySet()){
            count += map.get(key);
            max = Math.max(count, max);
        }
        return max;
    }
    TreeMap<Integer, Integer> map;
}
public class MyCalendarImp{
	public static void main(String[] args){
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(1,2));
        System.out.println(calendar.book(3,4));
        System.out.println(calendar.book(5,6));
        System.out.println(calendar.book(3,7));

        MyCalendarThree three = new MyCalendarThree();
        System.out.println(three.book(5,10));
        System.out.println(three.book(5,10));
        System.out.println(three.book(5,10));
        System.out.println(three.book(5,10));
	}
}
