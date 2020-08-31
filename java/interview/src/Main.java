import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Now.mountainSequence(new int[]{1,2,3,6,1}));
        //System.out.println(Now.mountainSequence(new int[]{1,2,2,1}));
        Leet s = new Leet();
        //Util.printArray(s.findDiagonalOrder(Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(7,8,9))));
        Util.printArray(s.findDiagonalOrder(Arrays.asList(Arrays.asList(1,2,3,4,5), Arrays.asList(6,7), Arrays.asList(8),
                Arrays.asList(9,10,11), Arrays.asList(12,13,14,15,16))));
    }
}
