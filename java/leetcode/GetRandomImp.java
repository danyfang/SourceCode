//Leetcode problem 380 Insert Delete GetRandom O(1)
//Leetcode problem 381 Insert Delete GetRandom O(1)  - Duplicates allowed
//Solution written by Xuqiang Fang on 17 May, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class RandomizedSet {
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        index = new ArrayList<>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, index.size());
        index.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int last = index.get(index.size()-1); 
        int removeIndex = map.get(val);
        map.put(last, removeIndex);
        map.remove(val);
        index.remove(index.size()-1);
        if(removeIndex < index.size())
            index.set(removeIndex, last);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = r.nextInt(index.size()); 
        return index.get(randomIndex);
    }

    private Map<Integer, Integer> map;
    private List<Integer> index;
    private Random r;
}

//No 381
class RandomizedCollection {
    List<int[]> list;
    Map<Integer, List<Integer>> map;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ans = false;
        if(!map.containsKey(val)){
            map.put(val, new ArrayList<>());
            map.get(val).add(list.size());
            list.add(new int[]{val, 0});
            ans = true;
        }
        else{
            map.get(val).add(list.size()); 
            list.add(new int[]{val, map.get(val).size()-1});
        }
        return ans;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        else{
            List<Integer> l = map.get(val); 
            int index = l.get(l.size()-1);
            l.remove(l.size()-1);
            if(l.isEmpty()){
                map.remove(val);
            }
            if(index == list.size()-1){
                list.remove(index);
            }
            else{
                list.set(index, list.get(list.size()-1));
                int v = list.get(index)[0];
                int i = list.get(index)[1];
                map.get(v).set(i, index);
                list.remove(list.size()-1);
            }
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int key = r.nextInt(list.size());
        return list.get(key)[0];
    }
}

public class GetRandomImp{
	public static void main(String[] args){
        RandomizedSet s = new RandomizedSet();
        System.out.println(s.insert(1));
        System.out.println(s.remove(2));
        System.out.println(s.insert(2));
        System.out.println(s.getRandom());
        System.out.println(s.remove(1));
        System.out.println(s.insert(2));
        System.out.println(s.getRandom());
        RandomizedCollection t = new RandomizedCollection();
        t.insert(1);
        t.insert(1);
        t.insert(2);
        System.out.println(t.getRandom());
        t.remove(1);
        System.out.println(t.getRandom());
        System.out.println(t.getRandom());
        System.out.println(t.getRandom());
        System.out.println(t.getRandom());
	}
}
