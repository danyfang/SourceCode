class AB{
    /**
    K = a * b s.t. a+b<=N
    */
    public String createString(int N, int K){
        StringBuilder sb = new StringBuilder();
        if(K > (N - N/2) * N/2){
            return sb.toString();
        }
        else if(K == 0){
            for(int i=0; i<N; ++i){
                sb.append('B');
            } 
            return sb.toString();
        }
        int k = find(N, K);
        if(k == -1){
            return sb.toString();
        }
        for(int i=0; i<k; ++i){
            sb.append('A');
        }
        for(int j=0; j<K/k; ++j){
            sb.append('B');
        }
        for(int x=0; x<N-k-K/k; ++x){
            sb.append('A');
        }
        return sb.toString();
    }

    private int find(int N, int K){
        for(int i=1; i<=N; ++i){
            if(K % i == 0 && (K/i + i <= N)){
                return i;
            }
        }
        return -1;
    }
}

public class ABC{
	public static void main(String[] args){
		AB s = new AB();
        System.out.println(s.createString(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
	}
}
