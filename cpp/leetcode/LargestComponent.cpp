//Leetcode Problem No 952 Largest Component Size by Common Factor
//Solution written by Xuqiang Fang on 13 Dec, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class UF {
    vector<int> p, sz;
public:
    
    int maxsz;
    UF(int n): maxsz(0){
        p = vector<int> (n);
        for(int i = 0; i < n; i++) p[i] = i;
        sz = vector<int> (n, 1);
    }
    int find(int x){
        if(x == p[x]) return p[x];
        return p[x] = find(p[x]);
    }
    void uni(int x, int y){
        int rx = find(x), ry = find(y);
        if(rx == ry) return;
        if(sz[rx] > sz[ry]){
            p[ry] = rx;
            sz[rx] += sz[ry];
        }
        else{
            p[rx] = ry;
            sz[ry] += sz[rx];
        }
        maxsz = max(maxsz, max(sz[rx], sz[ry]));
    }
};


class Solution {
public:
    int largestComponentSize(vector<int>& A) {
        UF s = UF(A.size());
        unordered_map<int, int> m;
        for(int i = 0; i < A.size(); i++){
            for(int f = 2; f*f <= A[i]; f++){
                if(A[i]%f == 0){
                    if(m.count(f)) s.uni(i, m[f]);
                    else m[f] = i;
                    if(m.count(A[i]/f)) s.uni(i, m[A[i]/f]);
                    else m[A[i]/f] = i;
                }
            }
            //factor A[i] itself
            if(m.count(A[i])) s.uni(i, m[A[i]]);
            else m[A[i]] = i;
        }
        
        return s.maxsz;
    }
};

int main(){
    Solution s;

    return 0;
}
