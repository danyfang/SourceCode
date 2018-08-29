//Codeforces Problem No. 1028 A
//Written by Xuqiang Fang on 27 Aug, 2018
/*
Description:

*/
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <set>
#include <stack>
#include <queue>
using namespace std;


int main(){
    int n, m;
    int u=-1, d=-1, l=-1, r=-1;
    cin >> n >> m;
    string s;
    for(int i=0; i<n; ++i){
        cin >> s; 
        for(int j=0; j<m; ++j){
            if(s[j] == 'B'){
                if(u == -1){
                    u = i+1;
                    d = i+1;
                }
                else{
                    d = i+1;
                }
                if(l == -1){
                    l = j+1;
                    r = j+1;
                }
                else{
                    r = j+1;
                }
            }
        }
    }
    cout << (u+d)/2 << " " << (l+r)/2 << endl;
    return 0;
}
