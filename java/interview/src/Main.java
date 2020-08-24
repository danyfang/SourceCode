import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Now.mountainSequence(new int[]{1,2,3,6,1}));
        //System.out.println(Now.mountainSequence(new int[]{1,2,2,1}));
        Leet s = new Leet();
        System.out.println(s.shiftGrid(new int[][]{{1}, {2}, {3}, {4}, {7}, {6}, {5}}, 23));
    }
}
