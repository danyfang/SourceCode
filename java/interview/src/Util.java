public class Util {
    public static void printArray(int[] a) {
        for(int i=0; i<a.length; ++i) {
            System.out.println(a[i]);
        }
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
}
