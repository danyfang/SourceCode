//Leetcode Problem No  826 Most Profit Assigning Work
//Solution written by Xuqiang Fang on 29 May, 2018

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
    int maxProfitAssignment(vector<int>& d, vector<int>& p, vector<int>& w) {
        int n = d.size();
        vector<vector<int>> a(n, vector<int>(2, 0));         
        for(int i=0; i<n; ++i){
            a[i][0] = d[i];
            a[i][1] = p[i];
        }
        for(auto x : a){
            cout << x[0] << "   " << x[1] << endl;
        }
        sort(a.begin(), a.end(),[](const vector<int>& x, const vector<int>& y){
            if(x[0] == y[0]){
                return y[1] < x[1];
            }
            return x[0] < y[0];
        });
        /*
        for(auto x : a){
            cout << x[0] << "   " << x[1] << endl;
        }
        */
        int m = a[0][1];
        for(int i=0; i<n; ++i){
            m = max(m, a[i][1]);
            a[i][1] = m;
        }
        int ans = 0;
        for(auto i : w){
            int t = binary_search(a, i); 
            //cout << "t = " << t << endl;
            ans += t;
        }
        return ans;
    }
private:
    int binary_search(vector<vector<int>>& a, int i){
        int l = 0;
        int r = a.size()-1;
        if(a[r][0] <= i){
            return a[r][1];
        }
        else if(a[l][0] > i){
            return 0;
        }
        while(l < r){
            if(l == r-1){
                return a[l][1];
            }
            int m = l + (r-l)/2;
            if(a[m][0] == i){
                return a[m][1];
            }
            else if(a[m][0] < i){
                l = m;
            }
            else{
                r = m;
            }
        }
        return 0;
    }    
};


class Xuqiang{
public:
    int maxProfitAssignment(vector<int>& d, vector<int>& p, vector<int>& w){
        const int n = d.size();
        vector<pair<int, int>> jobs;
        for(int i=0; i<n; ++i){
            jobs.emplace_back(d[i], p[i]);
        }
        sort(jobs.begin(), jobs.end());
        sort(w.begin(), w.end());
        int x = 0, y = 0, ans = 0, best = 0;
        while(x < w.size()){
            while(y < n && jobs[y].first <= w[x]){
                best = max(best, jobs[y].second);
                y++;
            }
            x++;
            ans += best;
        }
        return ans;
    }

    int maxProfitAssignment_(vector<int>& d, vector<int>& p, vector<int>& w){
        const int n = d.size();
        vector<int> a(100001, 0);
        for(int i=0; i<n; ++i){
            a[d[i]] = max(a[d[i]],p[i]);
        }
        int m = 0;
        for(int i=0; i<a.size(); ++i){
            m = max(m, a[i]);
            a[i] = m;
        }
        int ans = 0;
        for(auto i : w){
            ans += a[i];
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> d{2,4,6,8,10};
    vector<int> p{100,20,30,40,50};
    vector<int> w{4,5,6,7};
    //cout << s.maxProfitAssignment(d, p, w) << endl;
    vector<int> di{23,30,35,35,43,46,47,81,83,98};
    vector<int> pr{8,11,11,20,33,37,60,72,87,95};
    vector<int> wo{95,46,47,97,11,35,99,56,41,92};
    cout << s.maxProfitAssignment(di, pr, wo) << endl;
    return 0;
}
