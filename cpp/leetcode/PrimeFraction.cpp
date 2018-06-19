//Leetcode Problem No  786 K-th Smallest Prime Fraction
//Solution written by Xuqiang Fang on 18 June, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;

class Solution{
public:
    //an MLE solution O(n^2)
    vector<int> kthSmallestPrimeFraction_(vector<int>& A, int K) {
        const int n = A.size();
        vector<pair<int, int>> frac;
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                pair<int, int> p;
                p.first = A[i];
                p.second = A[j];
                frac.push_back(p);
            }
        }
        sort(frac.begin(), frac.end(), [](pair<int, int>& a, pair<int, int>& b){
            return a.first*b.second < a.second*b.first;
        });
        for(auto x : frac){
            cout << x.first << ", " << x.second << endl;
        }
        vector<int> ans(2);
        ans[0] = frac[K-1].first;
        ans[1] = frac[K-1].second;
        return ans;
    }

    //try using priority queue, accepted
    vector<int> kthSmallestPrimeFraction__(vector<int>& A, int K){
        const int n = A.size();
        priority_queue<pair<int, int>, vector<pair<int, int>>, Compare> q;
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                pair<int, int> p;
                p.first = A[i];
                p.second = A[j];
                if(q.size() < K){
                    q.push(p);
                }
                else if(q.size() == K){
                    auto t = q.top();
                    if(p.first * t.second < p.second * t.first){
                        q.pop();
                        q.push(p);
                    }
                }
            }
        }
        vector<int> ans(2);
        ans[0] = q.top().first;
        ans[1] = q.top().second;
        return ans;
    }


    //binary search method
    vector<int> kthSmallestPrimeFraction(vector<int>& A, int K){
        const int n = A.size();
        double l = 0, r = 1;
        while(l < r){
            double m = (l + r) / 2;
            double max_f = 0;
            int total = 0, p = 0, q = 0;
            int j = 1;
            for(int i=0; i<n-1; ++i){
                while(j < n && A[i] > m * A[j]){
                    ++j;
                }
                total += n - j;
                if(n == j){
                    break;
                }
                const double f = static_cast<double>(A[i]) / A[j];
                if(f > max_f){
                    p = i;
                    q = j;
                    max_f = f;
                }
            }
            if(total == K){
                return {A[p], A[q]};
            }
            else if(total > K){
                r = m;
            }
            else{
                l = m;
            }
        }
        return {};
    }
private:
    struct Compare{
        bool operator()(const pair<int, int>& a, const pair<int, int>& b){
            return a.first * b.second < a.second * b.first;
        }
    };
};


int main(){
    Solution s;
    vector<int> A{1,2,3,5};
    vector<int> ans = s.kthSmallestPrimeFraction(A, 3);
    cout << ans[0] << " " << ans[1] << endl;
    return 0;
}
