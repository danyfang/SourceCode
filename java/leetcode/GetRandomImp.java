//Leetcode problem 380 Insert Delete GetRandom O(1)
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
	}
}
