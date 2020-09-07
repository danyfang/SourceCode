import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Leet s = new Leet();
        System.out.println(s.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0,3),Arrays.asList(1,2), Arrays.asList(0,2))));
    }
}
