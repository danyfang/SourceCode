//Leetcode problem  855 Exam Room
//Solution written by Xuqiang Fang on 24 July, 2018
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
import java.util.TreeSet;

public class ExamRoom{
    public ExamRoom(int N){
        set = new TreeSet<>();
        M = N;
    }

    public int seat(){
        if(set.size() == 0){
            set.add(0);
            return 0;
        }
        int ans = 0, width = 0, p = 0, w = 0;
        if(set.first() != 0){
            width = set.first();
        }
        for(int i : set){
            w = (i - p) / 2;
            if(w > width){
                width = w;
                ans = p + w;
            }
            p = i;
        }
        if(p != M-1 && M-1-p > width){
            ans = M-1;
        }
        set.add(ans);
        return ans;
    }

    public void leave(int p){
        set.remove(p);
    }

    private TreeSet<Integer> set;
    private int M;
	public static void main(String[] args){
        ExamRoom s = new ExamRoom(10);
        int a = s.seat();
        System.out.println(a);
        s.leave(0);
        System.out.println(s.seat());
        System.out.println(s.seat());
        System.out.println(s.seat());
        System.out.println(s.seat());
	}
}

