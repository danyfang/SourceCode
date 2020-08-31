import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Leet s = new Leet();
        System.out.println(s.minDays(new int[][]{{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,0,1,1}}));
        System.out.println(s.minDays(new int[][]{{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,0,1,1}}));
    }
}
