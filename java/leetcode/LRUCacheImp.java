//Leetcode problem 146 LRU Cache
//Solution written by Xuqiang Fang on 27 Aug, 2018
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
class Node{
    int val;
    int key;
    Node prev;
    Node next;
    Node(int v, int k, Node p, Node n){
        val = v;
        key = k;
        prev = p;
        next = n;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, head, null);
        head.next = tail;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node change = map.get(key);
            change.prev.next = change.next;
            change.next.prev = change.prev;
            change.next = tail;
            change.prev = tail.prev;
            tail.prev.next = change;
            tail.prev = change;
            return map.get(key).val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node change = map.get(key);
            change.val = value;
            change.prev.next = change.next;
            change.next.prev = change.prev;
            change.next = tail;
            change.prev = tail.prev;
            tail.prev.next = change;
            tail.prev = change;
        } 
        else{
            if(map.size() >= capacity){
                Node delete = head.next;
                map.remove(delete.key);
                head.next = delete.next;
                head.next.prev = head;
            }
            map.put(key, new Node(value, key, tail.prev, tail));
            tail.prev.next = map.get(key);
            tail.prev = map.get(key);
        }
    }
}
public class LRUCacheImp{
	public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    
        System.out.println(cache.get(2));
        cache.put(4, 4);   
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        cache.put(5,5);
        System.out.println(cache.get(4));
	}
}
