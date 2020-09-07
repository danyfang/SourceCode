import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Util {
    public static void printArray(int[] a) {
        for(int i=0; i<a.length; ++i) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println( "");
    }
    public static void printArray(long[] a) {
        for(int i=0; i<a.length; ++i) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println( "");
    }

    public static boolean isPrime(long n){
        if(n == 2){
            return true;
        }
        for(int i=2; i<=Math.sqrt(n); ++i){
            if(n % i == 0){
                return false;
            }
        }
        return true;
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
        return -1;
    }

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    static class UnionFind{
        private int[] parent;
        private int[] size;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i=0; i<n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public int getLargestComponentSize() {
            int ans = 0;
            for (int i=0; i<parent.length; ++i) {
                if (parent[i] == i && size[i] > ans) {
                    ans = Math.max(ans, size[i]);
                }
            }
            return ans;
        }

        public int getParentCount() {
            Set<Integer> set = new HashSet<>();
            for (int i=0; i<parent.length; ++i) {
                set.add(find(parent[i]));
            }
            return set.size();
        }
    }
}
