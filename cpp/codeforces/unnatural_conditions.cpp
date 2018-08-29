//Codeforces Problem No. 1028 B
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
    int n,m;
    cin >> n >> m;
    int a = 5;
    string ans;
    string bns;
    while(a < n){
        a += 4; 
        ans.append("4");
        bns.append("5");
    }
    ans.append("5");
    bns.append("5");
    cout << ans << endl;
    cout << bns << endl;
    return 0;
}
