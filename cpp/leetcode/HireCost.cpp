//Leetcode Problem No 857 Minimum Cost to Hire K Workers
//Solution written by Xuqiang Fang on 24 June, 2018

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
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int K) {
        const int n = quality.size();
        vector<pair<double, int>> work;    
        for(int i=0; i<n; ++i){
            work.push_back({(double)wage[i]/quality[i], quality[i]});
        }
        sort(work.begin(), work.end());
        /*
        for(auto w : work){
            cout << w.first << " " << w.second << endl;
        }
        */
        priority_queue<int> q;
        int s = 0;
        for(int i=0; i<K; ++i){
            q.push(work[i].second);
            s += work[i].second;
        }
        double ans = (double)s * work[K-1].first;
        for(int i=K; i<n; ++i){
            int t = q.top();
            q.pop();
            q.push(work[i].second);
            s = s - t + work[i].second;
            ans = min(ans, s * work[i].first);
            cout << "ans = " << ans << endl;
        }
        /*
        while(q.size() > 0){
            cout << q.top() << endl;
            q.pop();
        }
        */
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> quality{10,20,5};
    vector<int> wage{70, 50, 30};
    cout << s.mincostToHireWorkers(quality, wage, 1) << endl;
    cout << s.mincostToHireWorkers(quality, wage, 2) << endl;
    cout << s.mincostToHireWorkers(quality, wage, 3) << endl;
    quality = {3,1,10,10,1};
    wage = {4,8,2,2,7};
    cout << s.mincostToHireWorkers(quality, wage, 1) << endl;
    cout << s.mincostToHireWorkers(quality, wage, 2) << endl;
    cout << s.mincostToHireWorkers(quality, wage, 3) << endl;
    cout << s.mincostToHireWorkers(quality, wage, 4) << endl;
    cout << s.mincostToHireWorkers(quality, wage, 5) << endl;
    quality = {2,1,5};
    wage = {17, 6, 4};
    cout << s.mincostToHireWorkers(quality, wage, 2) << endl;
    quality = {14,56,59,89,39,26,86,76,3,36};
    wage = {90,217,301,202,294,445,473,245,415,487};
    cout << s.mincostToHireWorkers(quality, wage, 2) << endl;
    return 0;
}
