//Leetcode problem 319 Bulb Switcher
//Leetcode problem 672 Bulb Switcher II
//Solution written by Xuqiang Fang on 18 April, 2018 

class Solution{
    public int bulbSwitch(int n) {
        int[] bulb = new int[n+1];
        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                if(j % i == 0){
                    if(bulb[j] == 0)
                        bulb[j] = 1;
                    else
                        bulb[j] = 0;
                }
            }
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            if(bulb[i] == 1)
                count++;
        }
        return count;
    }	
    //this version i figured it out myself
    public int bulbSwitcher(int n){
        if(n == 0)
            return 0;
        int square = 1;
        while(square * square <= n){
            square++;
        }
        return square-1;
    }


    public int flipLights(int n, int m) {
        if(n == 0 || m == 0){
            return 1;
        } 
        else if(n == 1){
            return 2;
        }
        else if(n == 2){
            return m == 1 ? 3 : 4;
        }
        else if(m == 1){
            return 4;
        }
        return m == 2 ? 7 : 8;
    }
}

public class BulbSwitcher{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.bulbSwitch(Integer.valueOf(args[0])));
        System.out.println(s.bulbSwitcher(Integer.valueOf(args[0])));
        for(int i=0; i<1000; i++){
            if(s.bulbSwitch(i) != s.bulbSwitcher(i))
                System.out.println(i);
        }
	}
}
