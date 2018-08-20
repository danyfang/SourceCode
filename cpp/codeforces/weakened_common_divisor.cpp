//Codeforces Problem No. 1025 B
//Written by Xuqiang Fang on 20 Aug, 2018
/*
Description:
During the research on properties of the greatest common divisor (GCD) of a set of numbers, Ildar,
a famous mathematician, introduced a brand new concept of the weakened common divisor (WCD)
of a list of pairs of integers.

For a given list of pairs of integers 
( a 1 , b 1) , ( a 2 , b 2) , ..., ( a n , b n) their WCD is arbitrary integer greater than 1 ,
such that it divides at least one element in each pair. WCD may not exist for some lists.  
For example, if the list looks like 
[ ( 12 , 15) , ( 25 , 18) , ( 10 , 24) ] , then their WCD can be equal to 2 , 3 , 5 or 6
(each of these numbers is strictly greater than 1 and divides at least one number in each pair).

You're currently pursuing your PhD degree under Ildar's mentorship, and that's why this problem was
delegated to you. Your task is to calculate WCD efficiently.
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
#include <utility>
#include <cmath>

using namespace std;

void fact(set<int>&s, int x){
    int m = (int)sqrt(x);
    for(int i=2; i<=m; ++i){
        if(x%i == 0){
            s.insert(i);
        }
        while(x%i==0){
            x /= i;
        }
    }
    if(x != 1){
        s.insert(x);
    }
}

int main(){
    int n;
    cin >> n;
    vector<pair<int, int>> list(n, {0, 0});
    for(int i=0; i<n; ++i){
        cin >> list[i].first >> list[i].second;
    }
    set<int> s;
    fact(s, list[0].first);
    fact(s, list[0].second);
    set<int>::iterator it;
    for(it=s.begin(); it!=s.end(); ++it){
        int t = *it;
        int i = 0;
        for(i=1; i<n; ++i){
            auto& p = list[i];
            if(p.first%t!=0 && p.second%t!=0){
                break;
            }
        }
        if(i == n){
            cout << *it << endl;
            return 0;
        }
    }
    cout << -1 << endl;
    return 0;
}
