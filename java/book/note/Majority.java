import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;

public class Majority{
    public int[] solution(int K, int M, int[] A){
        int N = A.length;
        int[] count = new int[M+K+1];
        Set<Integer> set = new HashSet<>();
        for(int a : A){
            count[a]++;
            if(count[a] > N/2){
                set.add(a);
            }
        }
        /*complexity O(N*K)*/
        for(int i=0; i<=N-K; ++i){
            for(int j=0; j<K; ++j){
                count[A[i+j]]--;
                A[i+j]++;
                count[A[i+j]]++;
                if(count[A[i+j]] > N/2){
                    set.add(A[i+j]);
                }
            }
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for(int s : set){
            ans[i++] = s;
        }
        Arrays.sort(ans);
        return ans;
    } 

    public int[] solution2(int K, int M, int[] A){
        int N = A.length;
        int[] count = new int[M+2];
        Set<Integer> set = new HashSet<>();
        for(int a : A){
            count[a]++;
            if(count[a] > N/2){
                set.add(a);
            }
        }
        for(int i=0; i<K; ++i){
            count[A[i]]--;
            A[i]++;
            count[A[i]]++;
        }
        for(int i=0; i<=M+1; ++i){
            if(count[i] > N/2){
                set.add(i);
                break;
            }
        }
        /*complexity O(N)*/
        for(int i=K; i<N; ++i){
            count[A[i-K]]--;
            count[A[i]]--;
            A[i]++;
            count[A[i]]++;
            if(count[A[i]] > N/2){
                set.add(A[i]);
            }
             
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for(int s : set){
            ans[i++] = s;
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args){
        Majority m = new Majority();
        int[] A = {1,1,1,2,3};
        //int[] ans = m.solution(2, 3, A);
        A = new int[]{1,2,2,2,1};
        int[] ans = m.solution2(2,2,A);
        for(int a : ans){
            System.out.println(a);
        }
    }
}
