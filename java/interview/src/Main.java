import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Leet s = new Leet();
        //System.out.println(s.numOfSubarraysOddEven(new int[]{29,14,82,37,42,79,23,70,84,15,57,37,92,82,36,30,12,42,9,49,79,1,54,88,66,63,31,79,4,82,58,49,70,64,86,5,13,41,17,69,42,76,67,14,41,69}));//540
        System.out.println(s.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(false,false,true,true,false,true,true)));
        System.out.println(s.minTime(4, new int[][]{{0,1},{1,2},{0,3}}, Arrays.asList(true,true,true,true)));
    }
}
