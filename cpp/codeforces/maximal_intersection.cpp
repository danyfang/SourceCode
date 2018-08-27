//Codeforces Problem No. 1029 C
//Written by Xuqiang Fang on  24 Aug, 2018
/*
Description:
You are given n segments on a number line; each endpoint of every segment has integer coordinates. Some segments can degenerate to points. Segments can intersect with each other, be nested in each other or even coincide.

The intersection of a sequence of segments is such a maximal set of points (not necesserily having integer coordinates) that each point lies within every segment from the sequence. If the resulting set isn't empty, then it always forms some continuous segment. The length of the intersection is the length of the resulting segment or 
0
 in case the intersection is an empty set.  For example, the intersection of segments [ 1 ; 5 ] and [ 3 ; 10 ] is [ 3 ; 5 ] (length 2), the intersection of segments [ 1 ; 5 ] and [ 5 ; 7 ] is [ 5 ; 5 ] (length 0) and the intersection of segments [ 1 ; 5 ] and [ 6 ; 6 ] is an empty set (length 0).  Your task is to remove exactly one segment from the given sequence in such a way that the intersection of the remaining ( n − 1) segments has the maximal possible length
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
    set<long> s;
    long m = 10000000000;
    priority_queue<int> left;
    priority_queue<int,vector<int>,greater<int>> right;
    vector<pair<int, int>> a(n, {0, 0});
    for(int i=0; i<n; ++i){
        cin >> a[i].first >> a[i].second;
        left.push(a[i].first);
        right.push(a[i].second);
        long t = m * a[i].first + a[i].second;
        s.insert(t);
    }
    long l = left.top() * m + right.top();
    if(s.count(l) != 0){
        left.pop();
        right.pop();
        if(left.top() < right.top()){
            cout << right.top() - left.top() << endl;
        }
        else{
            cout << 0 << endl;
        }
    }
    else{
        int l1 = left.top();
        left.pop();
        int l2 = left.top();

        int r1 = right.top();
        right.pop();
        int r2 = right.top();
        int ans = max(r1-l2, r2-l1);
        if(ans > 0){
            cout << ans << endl;
        }
        else{
            cout << 0 << endl;
        }
    }
    return 0;
}
