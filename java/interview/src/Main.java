import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main implements Runnable{

    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static List<ExecutorService> threadList = new ArrayList<>();
    private static final int MAX = 1024;
    private static int current = 1;

    @Override
    public void run() {
        if (current <= MAX) {
            System.out.println(current++);
            threadList.get(current % threadList.size()).submit(new Main());
        } else {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            threadList.add(Executors.newFixedThreadPool(1));
        }

        threadList.get(0).submit(new Main());
        countDownLatch.await();
        threadList.forEach(ExecutorService::shutdown);

    }
    public static void process(String s, int[] nums) {
        String[] a = s.split(",");
        int[] b = new int[a.length];
        for (int i=0; i<b.length; ++i) {
            b[i] = Integer.parseInt(a[i]);
        }
        if (nums[0] < b[0]) {
            return;
        }
        if (b[0] >= 100) {
            int t = helper(b[1], 5, 3);
            if (t > b[0] || t > nums[0]) {
                return;
            }
            t = helper(b[2], 5, 3);
            if (nums[0] >= t) {
                nums[0] -= t;
            }
            if(b[2] > b[1] && nums[0] > (b[2]-b[1])) {
                nums[0] -= (b[2] - b[1]);
            }
        } else if (b[0] >= 50) {
            int t = helper(b[1], 3, 2);
            if (t > b[0] || t > nums[0]) {
                return;
            }
            t = helper(b[2], 3,2);
            if (nums[0] >= t) {
                nums[0] -= t;
            }
            if(b[2] > b[1] && nums[0] > (b[2]-b[1])) {
                nums[0] -= (b[2] - b[1]);
            }
        } else {
            int t = 0;
            t += b[2];
            if (t > b[0] || t > nums[0]) {
                return;
            }
            t = b[1];
            if (nums[0] >= t) {
                nums[0] -= t;
            }
            if(b[2] > b[1] && nums[0] >= (b[2]-b[1])) {
                nums[0] -= (b[2] - b[1]);
            }
        }
    }

    private static int helper(int b, int c, int d) {
        if (b <= 15) {
            return b * c;
        } else {
            return 15 * c + (b-15)*d;
        }
    }
}
