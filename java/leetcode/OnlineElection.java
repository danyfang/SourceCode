//Leetcode problem  911 Online Election
//Solution written by Xuqiang Fang on 23, Sep, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class TopVotedCandidate_{
    class Node{
        int val, freq;
        Node prev, next;
        Node(int v, int f){val = v; freq = f; prev = null; next = null;}
    }
    private TreeMap <Integer, Integer> map;
    private Map<Integer, Node> link; 
    private Node head, tail;
    public TopVotedCandidate_(int[] persons, int[] times) {
        map = new TreeMap<>();
        link = new HashMap<>();
        head = new Node(-1, 0);
        tail = new Node(-1, 0);
        head.next = tail;
        tail.prev = head;
        int n = times.length;
        for(int i=0; i<n; ++i){
            if(!link.containsKey(persons[i])){
                link.put(persons[i], new Node(persons[i], 1));
                if(head.next == tail || head.next.freq == 1){
                    Node tmp = head.next;
                    head.next = link.get(persons[i]);
                    head.next.prev = head;
                    head.next.next = tmp;
                    tmp.prev = head.next;
                }
                else{
                    Node tmp = tail.prev;
                    tmp.next = link.get(persons[i]);
                    tmp.next.prev = tmp;
                    tmp.next.next = tail;
                    tail.prev = tmp.next;
                }
            }
            else{
                Node node = link.get(persons[i]);
                node.freq += 1;
                if(node.freq >= head.next.freq && head.next != node){
                    node.prev.next = node.next;
                    Node tmp = head.next;
                    head.next = node;
                    node.prev = head;
                    node.next = tmp;
                    tmp.prev = node;
                }
            }
            map.put(times[i], head.next.val);
        }
    }
    
    public int q(int t) {
        return map.get(map.floorKey(t));
    }
}

class TopVotedCandidate {
    private TreeMap<Integer, Integer> map;
    private int[] count;
    private int maxFreq;
    private int person;
    public TopVotedCandidate(int[] persons, int[] times) {
        int n = times.length;
        maxFreq = 0;
        person = -1;
        map = new TreeMap<>();
        count = new int[n+1];
        for(int i=0; i<n; ++i){
            count[persons[i]]++;
            if(count[persons[i]] >= maxFreq){
                maxFreq = count[persons[i]];
                person = persons[i];
            }
            map.put(times[i], person);
        }
    }
    
    public int q(int t) {
        return map.get(map.floorKey(t)); 
    }
}

public class OnlineElection{
	public static void main(String[] args){
        int[] persons = {0,1,1,0,0,1,0};
        int[] times = {0,5,10,15,20,25,30};
		TopVotedCandidate s = new TopVotedCandidate(persons, times);
        System.out.println(s.q(3));
        System.out.println(s.q(12));
        System.out.println(s.q(25));
        System.out.println(s.q(15));
        System.out.println(s.q(24));
        System.out.println(s.q(8));
	}
}
