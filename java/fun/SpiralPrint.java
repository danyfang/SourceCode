public class SpiralPrint{
    int[][] loop1(int m, int n){
        int[][] ans = new int[m][n];
        int i, k = 0, l = 0; 
        int cnt = 0; 
        int total = m * n; 
        while(k < m && l < n){
            if (cnt == total) 
                break; 

            /**first column**/
            for (i = k; i < m; ++i)  
                ans[i][l] = ++cnt;
            l++; 
      
            if (cnt == total) 
                break; 
      
            /**last row**/
            for (i = l; i < n; ++i)   
                ans[m-1][i] = ++cnt;
            m--; 
      
            if (cnt == total) 
                break; 

            /**last column**/
            for (i = m - 1; i >= k; --i)   
                ans[i][n-1] = ++cnt;
            n--; 

            if (cnt == total) 
                break; 

            /**last column**/
            for (i = k; i < m; ++i)   
                ans[i][n-1] = ++cnt;
            n--; 

            if (cnt == total) 
                break; 
      
            /**last row**/
            for (i = n-1; i >= l; --i)   
                ans[m-1][i] = ++cnt;
            m--; 

            if (cnt == total) 
                break; 

            /**first column**/
            for (i = m-1; i >= k; --i)  
                ans[i][l] = ++cnt;
            l++; 
        }
        return ans;
    }

    public static void  main(String[] args){
        SpiralPrint s = new SpiralPrint();
        int[][] ans = s.loop1(9,8);
        for(int[] bns : ans){
            for(int b : bns){
                System.out.print(b + " "); 
            }
            System.out.println("\n");
        }
    }
}
