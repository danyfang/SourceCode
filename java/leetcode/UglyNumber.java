//Leetcode problem 313 Super Ugly Number 
//Leetcode problem 264 Ugly Number II
//Leetcode problem 263 Ugly Number 
//Solution written by Xuqiang Fang on 16 March 2018 

class Solution{
	public int nthUglyNumber(int n){
		int[] nums = new int[n];
		nums[0] = 1;
		for(int i=1; i<n; i++){
			int temp = nums[i-1];
			while(!legal(++temp)){
				continue;
			}
			nums[i] = temp;
		}
		return nums[n-1];
	}	

	public boolean legal(int n){
		while(n != 0){
			if(n%2 == 0){
				n = n/2;
				continue;
			}
			else if(n%3 == 0){
				n = n/3;
				continue;
			}
			else if(n%5 == 0){
				n = n/5;
				continue;
			}
			else if(n == 1){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
    public boolean legal_(int n){
        if(n == 0)
            return false;
        int[] prime = {2,3,5};
        for(int i : prime){
            while(n % i == 0)
                n = n / i;
        }
        return n == 1;
    }
	public int nthUglyNumber_2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }

	public int nthUglyNumber_3(int n){
		int[] ugly = new int[n];
		ugly[0] = 1;
		int t2 = 0, t3 = 0, t5 = 0;
		for(int i=1; i<n; i++){
			ugly[i] = Math.min(ugly[t2]*2, Math.min(ugly[t3]*3, ugly[t5]*5));
			if(ugly[i] == ugly[t2]*2)
				t2++;
			if(ugly[i] == ugly[t3]*3)
				t3++;
			if(ugly[i] == ugly[t5]*5)
				t5++;
		}
		return ugly[n-1];
	}
    
    public int nthSuperUglyNumber(int n, int[] primes){
        int[] ugly = new int[n];
        ugly[0] = 1;
        int k = primes.length;
        int[] index = new int[k];
        for(int i=1; i<n; ++i){
            int temp = ugly[index[0]] * primes[0];
            for(int j=1; j<k; ++j){
                if(ugly[index[j]] * primes[j] < temp){
                    temp = ugly[index[j]] * primes[j];
                }
            }
            ugly[i] = temp;
            for(int j=0; j<k; ++j){
                if(ugly[index[j]] * primes[j] == temp){
                    index[j]++;
                }
            }
        }

        return ugly[n-1];
    }
}

public class UglyNumber{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.nthUglyNumber_3(Integer.valueOf(args[0])));
	}
}
