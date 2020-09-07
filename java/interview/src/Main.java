import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Leet s = new Leet();
        System.out.println(s.findLengthOfShortestSubarray(new int[]{1,2,3}));
        System.out.println(s.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
        System.out.println(s.findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
        System.out.println(s.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5,5,4,3,2,1}));
    }
}
