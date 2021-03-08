public class DoubleCheckLock {
    private DoubleCheckLock() {}

    private static volatile DoubleCheckLock INSTANCE;

    public static DoubleCheckLock getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLock.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLock();
                }
            }
        }
        return INSTANCE;
    }
}
