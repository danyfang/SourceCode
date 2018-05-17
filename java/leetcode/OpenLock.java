//Leetcode problem 752 Open the Lock
//Solution written by Xuqiang Fang on 17, May, 2018
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
class Solution{
    public int openLock(String[] deadends, String target){
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String deadend : deadends){
            set.add(deadend);
        }
        String start = "0000";
        if(set.contains(start)){
            return -1;
        }
        visited.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int steps = 0;
        while(!queue.isEmpty()){
            ++steps;
            int size = queue.size();
            //each level
            for(int i=0; i<size; ++i){
                String head = queue.poll();
                for(int j=0; j<4; ++j){
                    for(int x=-1; x<=1; x+=2){
                        StringBuilder sb = new StringBuilder(head);
                        sb.setCharAt(j, (char)((sb.charAt(j)-'0'+x+10)%10+'0'));
                        String next = sb.toString();
                        if(next.equals(target)){
                            return steps;
                        }
                        if(set.contains(next) || visited.contains(next)){
                            continue;
                        }
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }
    public int open(String[] deadends, String target){
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String deadend : deadends){
            set.add(deadend);
        }
        String start = "0000";
        if(set.contains(start)){
            return -1;
        }
        visited.add(start);
        List<String> queue = new ArrayList<>();
        queue.add(start);
        int steps = 0;
        while(!queue.isEmpty()){
            ++steps;
            int size = queue.size();
            //each level
            for(int i=0; i<size; ++i){
                String head = queue.remove(0);
                for(int j=0; j<4; ++j){
                    for(int x=-1; x<=1; x+=2){
                        StringBuilder sb = new StringBuilder(head);
                        sb.setCharAt(j, (char)((sb.charAt(j)-'0'+x+10)%10+'0'));
                        String next = sb.toString();
                        if(next.equals(target)){
                            return steps;
                        }
                        if(set.contains(next) || visited.contains(next)){
                            continue;
                        }
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }
}

public class OpenLock{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String[] dead = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        System.out.println(s.openLock(deadends, "0202"));
        System.out.println(s.openLock(dead, "8888"));
        System.out.println(s.open(deadends, "0202"));
        System.out.println(s.open(dead, "8888"));
	}
}
