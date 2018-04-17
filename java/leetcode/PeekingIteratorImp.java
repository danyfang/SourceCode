//Leetcode problem 284 Peeking Iterator
//Solution written by Xuqiang Fang on 14 April, 2018 
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

class PeekingIterator implements Iterator<Integer>{
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        it = iterator;
        if(it.hasNext())
            next = it.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer result = next;
        next = it.hasNext() ? it.next() : null;
        return result;
	}

	@Override
	public boolean hasNext() {
        return next != null;
	}
    private Iterator<Integer> it;
    private Integer next = null;
}

public class PeekingIteratorImp{
	public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iter = list.iterator();
        PeekingIterator it = new PeekingIterator(iter);
        System.out.println(it.peek());
        System.out.println(it.next());
        System.out.println(it.peek());
        System.out.println(it.next());
        System.out.println(it.peek());
	}
}
