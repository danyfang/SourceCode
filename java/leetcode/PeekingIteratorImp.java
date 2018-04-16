//Leetcode problem 284 Peeking Iterator
//Solution written by Xuqiang Fang on 14 April, 2018 
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

class PeekingIterator implements Iterator<Integer>{
    public PeekingIterator(Iterator<Integer> iterator){
        iter = iterator;
        if(iter.hasNext()){
            next = iter.next();
        }
    }
    public Integer peek(){
        return next;
    }

    @Override
    public Integer next(){
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    @Override
    public boolean hasNext(){
        return next != null;
    }
    private Integer next = null;
    private Iterator<Integer> iter;
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
