import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Now.mountainSequence(new int[]{1,2,3,6,1}));
        //System.out.println(Now.mountainSequence(new int[]{1,2,2,1}));
        Leet s = new Leet();
        String str = s.convertToTitle(53314);
        System.out.println(s.titleToNumber(str));
        System.out.println(s.trailingZeroes(101));
        System.out.println(s.trailingZeroes(1808548329));
        System.out.println(s.isIsomorphic("ab", "aa"));
    }
}
