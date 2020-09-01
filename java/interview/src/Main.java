import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Leet s = new Leet();
        System.out.println(s.arrangeWords("Leetcode is cool"));
        System.out.println(s.arrangeWords("Keep calm and code on"));
        System.out.println(s.arrangeWords("To be or not to be"));
    }
}
