public class Main {
	public static void main(String[] args){
		Interleave s = new Interleave();
		//System.out.println(s.isInterleave(s1,s2,s3));
		//System.out.println(s.isInterleave(s1,s2,s4));
		String s5 = "aa";
		String s6 = "ab";
		String s7 = "aaba";
		/*
		String s1 = "abaa";
		String s2 = "abcc";
		String s3 = "ababccaa";

		/*
		String s1 = "aabd";
		String s2 = "abdc";
		String s3 = "aabdabcd";


		String s1 = "aabc";
		String s2 = "abad";
		String s3 = "aabaabdc";
		*/

		String s1 = "aabc";
		String s2= "abad";
		String s3 = "aabacbad";
		//System.out.println(s.isInterleave(s5,s6,s7));
		//System.out.println(s.isInterleave(s1,s2,s3));



		//subArray

		int[] num = {-2,1,-3,4,-1,2,1,-5,4};
		SubArray sub = new SubArray();
		System.out.println(sub.maxSubArray(num));

	}
}
