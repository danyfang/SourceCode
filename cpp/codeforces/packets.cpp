//Codeforces Problem No. 1037 A
//Written by Xuqiang Fang on 2 Sep, 2018
/*
Description:
You have n coins, each of the same value of 1 .  Distribute them into packets such that any amount x ( 1 ≤ x ≤ n)
can be formed using some (possibly one or all) number of these packets.  Each packet may only be used entirely or
not used at all. No packet may be used more than once in the formation of the single x , however it may be reused
for the formation of other x 's.  Find the minimum number of packets in such a distribution.
*/
#include <cmath>
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <set>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    int ans = log2(n);
    cout << ans+1 << endl;
    return 0;
}
