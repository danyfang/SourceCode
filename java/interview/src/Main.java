import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Leet s = new Leet();
        System.out.println(s.removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(s.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(s.removeDuplicates("abcd", 2));
    }
}
