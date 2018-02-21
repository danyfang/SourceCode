

class Solution{
	public double myPow(double x, int n){
		if(n < 0){
			x = 1/x;
			n = -n;
		}
		double result = 1;
		for(int i=0; i<n; i++){
			result = x * result;
		}
		return result;
	}
}

public class Pow{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.myPow(2,10));
		System.out.println(s.myPow(2.1,3));
	}
}
