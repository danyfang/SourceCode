//Leetcode problem 492 Construct the Rectangle
//Solution written by Xuqiang Fang on 9 May, 2018
class Solution{
    public int[] constructRectangle(int area){
        int w = 0;
        int l = 0;
        for(int i=(int)Math.sqrt(area); i>=0; --i){
            if(area % i == 0){
                w = i;
                l = area / w;
                break;
            }
        }
        int[] res = new int[]{l,w};
        return res;
    }
}

public class ConstructTriangle{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] res = s.constructRectangle(Integer.valueOf(args[0]));
        System.out.println(res[0] + "\t" + res[1]);
	}
}
