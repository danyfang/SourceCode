//Leetcode problem 332 Reconstruct Itineray
//Solution written by Xuqiang Fang on 19 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
class Solution{
    public List<String> findItinerary(String[][] tickets){
        List<String> list = new ArrayList<>();
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0)
            return list;

        int row = tickets.length;
        map = new HashMap<>();
        for(int i=0; i<row; ++i){
            if(map.get(tickets[i][0]) == null){
                PriorityQueue<String> queue = new PriorityQueue<>((a,b)->a.compareTo(b));
                queue.add(tickets[i][1]);
                map.put(tickets[i][0], queue);
            }
            else{
                PriorityQueue<String> queue = map.get(tickets[i][0]);
                queue.add(tickets[i][1]);
                map.put(tickets[i][0], queue);
            }

        }
        String begin = "JFK";
        Stack<String> stack = new Stack<>();
        visit(stack, begin);
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }	
    private Map<String, PriorityQueue<String>> map = null;
    private void visit(Stack<String> stack, String begin){
        PriorityQueue<String> queue = map.get(begin);
        while(queue != null && !queue.isEmpty()){
            visit(stack, queue.poll());
        }
        stack.push(begin);
    }
}

public class ReconstructItinerary{
	public static void main(String[] args){
		Solution s = new Solution();
        String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[][] tickets2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        String[][] tickets3 = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        System.out.println(s.findItinerary(tickets));
        System.out.println(s.findItinerary(tickets2));
        System.out.println(s.findItinerary(tickets3));
	}
}
