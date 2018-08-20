//Codeforces Problem No. 1025 A
//Written by Xuqiang Fang on 19 Aug, 2018
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
    int n;
    cin >> n;
    string s;
    cin >> s;
    int color[26] = {0};
    for(int i=0; i<n; ++i){
        int index = (int)(s[i]-'a');
        color[index]++;
        if(color[index] >= 2){
            cout << "Yes" << endl;
            return 0;
        }
    }
    if(n == 1){
        cout << "Yes" << endl;
        return 0;
    }
    cout << "No" << endl;
    return 0;
}
