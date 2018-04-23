//Leetcode problem 223 Rectangle Area
//Solution written by Xuqiang Fang on 23 April, 2018 

class Solution{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
        int areaA = (C-A) * (D-B);
        int areaB = (G-E) * (H-F);
        if(C <= E || G <= A || H <= B || D <= F) 
            return areaA + areaB;

        int width = interval(A,C,E,G);
        int height = interval(B,D,F,H);

        return areaA+areaB - width * height;
    }	

    public int interval(int l1, int r1, int l2, int r2){
        if(l1 >= l2 && r1 <= r2)
            return r1-l1;
        else if(l1 <= l2 && r1 >= r2)
            return r2-l2;
        else if(l1 <= l2 && r1 >= l2)
            return r1-l2;
        else
            return r2-l1;
    }
}

public class RectangleArea{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.computeArea(-3,0,3,4,0,-1,9,2));
        System.out.println(s.computeArea(-3,0,3,4,0,-1,9,2));
	}
}
