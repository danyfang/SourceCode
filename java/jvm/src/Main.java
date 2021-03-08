public class Main {
    public static void main(String[] args) {
        T t = new T();

        // Double check lock
        for (int i=0; i<100; ++i) {
            new Thread(() -> {
                DoubleCheckLock doubleCheckLock = DoubleCheckLock.getInstance();
                System.out.println(doubleCheckLock.hashCode());
            }).start();
        }
    }
}
