//Leetcode Problem No 862 Shortest Subarray with Sum at Least
//Solution written by Xuqiang Fang on 2 July, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <deque>

using namespace std;
class Solution{
public:
    //for the rvalue function call
    int shortestSubarray_(vector<int>&& A, int K) {
        const int N = A.size();
        vector<int> B(N+1, 0);
        for(int i=0; i<N; ++i){
            B[i+1] = B[i] + A[i];
        }
        int ans = N + 1;
        deque<int> d;
        for(int i=0; i<N+1; ++i){
            while(d.size() > 0 && B[i]-B[d[0]] >= K){
                ans = min(ans, i-d.front());
                d.pop_front();
            }
            while(d.size() > 0 && B[i] <= B[d.back()]){
                d.pop_back();
            }
            d.push_back(i);
        }
        return ans <= N ? ans : -1;
    }
    int shortestSubarray(vector<int>&& A, int K) {
        const int N = A.size();
        vector<int> B(N+1, 0);
        for(int i=0; i<N; ++i){
            B[i+1] = B[i] + A[i];
        }
        int ans = N + 1;
        deque<int> d;
        for(int i=0; i<N+1; ++i){
            while(d.size() > 0 && B[i]-B[d[0]] >= K){
                ans = min(ans, i-d.front());
                d.pop_front();
            }
            while(d.size() > 0 && B[i] <= B[d.back()]){
                d.pop_back();
            }
            d.push_back(i);
        }
        return ans <= N ? ans : -1;
    }
};

int main(){
    Solution s;
    cout << (s.shortestSubarray({2,-1,2}, 3)) << endl;
    cout << (s.shortestSubarray({1,2}, 4)) << endl;
    cout << (s.shortestSubarray({1}, 1)) << endl;
    cout << (s.shortestSubarray({1,2,3,-5,4,-7,5,-8,6,-9,7,8,-4}, 5)) << endl;
    cout << (s.shortestSubarray({1,2,-5,3,-5,4,-7,5,-8,6,-9,7,8,-4}, 5)) << endl;
    return 0;
}
