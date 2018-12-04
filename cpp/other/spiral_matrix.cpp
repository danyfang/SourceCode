#include <iostream>
#include <vector>

using namespace std; 
  
vector<vector<int>> loop1(int m, int n){ 
    vector<vector<int>> ans(m,vector<int>(n,0));
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

vector<vector<int>> loop2(int m, int n){ 
    vector<vector<int>> ans(m,vector<int>(n,0));
    int i, k = 0, l = 0; 
    int cnt = 0; 
    int total = m * n; 
  
    while (k < m && l < n){ 
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
  
        /**first row**/
        for (i = n - 1; i >= l; --i)   
            ans[k][i] = ++cnt;
        k++; 
    } 
    return ans;
} 
  
int main() 
{ 
    int r, c;
    cin >> r >> c;

    auto&& ans = loop1(r, c); 
    for(auto& line : ans){
        for(auto& l : line){
            cout << l << " ";
        }
        cout << endl;
    }
    cout << "********************" << endl;
    auto&& bns = loop2(r, c); 
    for(auto& line : bns){
        for(auto& l : line){
            cout << l << " ";
        }
        cout << endl;
    }
    return 0; 
} 
