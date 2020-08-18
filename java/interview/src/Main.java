import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] coord = new int[N][2];
        int index = 0;
        for(int i=0; i<N; ++i){
            String s = sc.nextLine();
            String[] a = s.split(" ");
            coord[index][0] = Integer.parseInt(a[0]);
            coord[index][1] = Integer.parseInt(a[1]);
            index++;
        }
        maxCoord(coord);
    }

    public static void maxCoord(int[][] coord) {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        for (int[] ints : coord) {
            if (!left.containsKey(ints[0])) {
                left.put(ints[0], ints[1]);
            } else {
                left.put(ints[0], Math.max(ints[1], left.get(ints[0])));
            }
            if(!right.containsKey(ints[1])){
                right.put(ints[1], ints[0]);
            } else {
                right.put(ints[1], Math.max(ints[0], right.get(ints[1])));
            }
        }
        int current = right.get(right.lastKey());
        for(int k : right.descendingKeySet()) {
            int v = right.get(k);
            if(v < current) {
                continue;
            }
            current = v;
            System.out.println(current + " " + left.get(current));
        }
    }

    public static int binarySearch(int[] k, int x){
        int l = 0;
        int r = k.length;
        while(l < r){
            int m = l + (r-l)/2;
            if(k[m] == x){
                return m;
            } else if(k[m] < x){
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
