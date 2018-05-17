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
    }
    
    public boolean book(int start, int end) {
        return true;
    } 
    List<int[]> booked;
}
public class MyCalendarImp{
	public static void main(String[] args){
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(1,2));
        System.out.println(calendar.book(3,4));
        System.out.println(calendar.book(5,6));
        System.out.println(calendar.book(3,7));
	}
}
