//Leetcode problem 593 Valid Square 
//Solution written by Xuqiang Fang on 28 April, 2018 

class Solution{
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4){
        //p1 and p2 are digonal
        if(isValid(p1,p2,p3,p4)){
            System.out.println("["+p1[0]+","+p1[1]+"]" + " "+"["+p2[0]+","+p2[1]+"]");
            return true;
        }
        //p1 and p3 are diagonal
        if(isValid(p1,p3,p2,p4)){
            System.out.println("["+p1[0]+","+p1[1]+"]" + " "+"["+p3[0]+","+p3[1]+"]");
            return true;
        }
        //p1 and p4 are diagonal
        if(isValid(p1,p4,p2,p3)){
            System.out.println("["+p1[0]+","+p1[1]+"]" + " "+"["+p4[0]+","+p4[1]+"]");
            return true;
        }
        return false;
    }
    public boolean isValid(int[] p, int[] q, int[] r, int[] s){
        //p1 and p2 are diagonal
        if(p[0] == q[0]){
            return r[1] == s[1] && distance(p,r) == distance(q,r) && distance(p,s) == distance(q,s) && distance(p,q) == distance(r,s);
        }
        else if(r[0] == s[0]){
            return p[1] == q[1] && distance(p,r) == distance(q,r) && distance(p,s) == distance(q,s) && distance(p,q) == distance(r,s);
        }
        else{
            return (p[1]-q[1]) * (r[1]-s[1]) + (p[0]-q[0]) * (r[0]-s[0]) == 0 &&  distance(p,r) == distance(q,r) && distance(p,s) == distance(q,s) && distance(p,q) == distance(r,s);
        }
    }
    public int distance(int[] p, int[] q){
        return (p[0] - q[0]) * (p[0]-q[0]) + (p[1]-q[1])*(p[1]-q[1]);
    }

}

public class ValidSquareShape{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] p1 = {0,0};
        int[] p2 = {1,1};
        int[] p3 = {1,0};
        int[] p4 = {0,1};
        System.out.println(s.validSquare(p1,p2,p3,p4));
	}
}
