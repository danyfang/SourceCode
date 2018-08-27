//Codeforces Problem No. 1029 D
//Written by Xuqiang Fang on 24 Aug, 2018
/*
Description:
You are given an array a , consisting of n positive integers.  Let's call a concatenation of numbers x and y the
number that is obtained by writing down numbers x and y one right after another without changing the order. 
For example, a concatenation of numbers 12 and 3456 is a number 123456 .  Count the number of ordered pairs
of positions ( i , j) ( i ≠ j) in array a such that the concatenation of a i and a j is divisible by k .
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

const int N = 200 * 1000 + 13;
const int LOGN = 11;

int n, k;
int a[N];
int len[N];
vector<int> rem[LOGN];
int pw[LOGN];

int main(){
    cin >> n >> k;
    for(int i=0; i<n; ++i){
        cin >> a[i];
    }
    pw[0] = 1;
    for(int i=0; i<LOGN-1; ++i){
        pw[i+1] = pw[i] * 10 % k;
    }
    for(int i=0; i<n; ++i){
        int x = a[i];
        while(x > 0){
            ++len[i];
            x /= 10;
        }
        rem[len[i]].push_back(a[i]%k);
    }
    for(int i=0; i<LOGN; ++i){
        sort(rem[i].begin(), rem[i].end());
    }

    long long ans = 0;
    for(int i=0; i<n; ++i){
        for(int j=1; j<LOGN; ++j){
            int r = (a[i] * (long long)(pw[j])) % k;
            int x = (k - r) % k;
            auto left = lower_bound(rem[j].begin(), rem[j].end(), x);
            auto right = upper_bound(rem[j].begin(), rem[j].end(), x);
            ans += (right - left);
            if(len[i] == j && (r + a[i]%k)%k == 0){
                ans--;
            }
        }
    }
    cout << ans << endl;
    return 0;
}
