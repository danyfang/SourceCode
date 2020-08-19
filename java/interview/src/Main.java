import java.util.*;

public class Main {
    public static void main(String[] args){
        System.out.println(Now.mountainSequence(new int[]{1,2,3,6,1}));
        System.out.println(Now.mountainSequence(new int[]{1,2,2,1}));
        Leet s = new Leet();
        System.out.println(s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println(s.convertToTitle(53314));
        System.out.println(s.convertToTitle(1424242));
    }
}
