#include <iostream>
#include <vector>
using namespace std;

class Subset{
public:
    /**save all possible subsets in vector*/
    vector<vector<int>> subset(const vector<int> s){
        int n = s.size();
        vector<vector<int>> ans;
        vector<int> t;
        dfs(s, ans, t, 0);
        return ans;
    }
    /**directly print the subset*/
    void subset_(const vector<int> &s, int n, vector<int> &p, int c, int e){
        for(int i=e; i<n; ++i){
            p[c] = s[i];
            for(int j=0; j<=c; ++j){
                cout << p[j] << " ";
            }
            cout << endl;
            subset_(s, n, p, c+1, i+1);
        }
    }
private:
    void dfs(const vector<int>& s, vector<vector<int>>& a,vector<int>& t, int e){
        if(t.size() > 0){
            a.push_back(t);
        } 
        for(int i=e; i<s.size(); ++i){
            t.push_back(s[i]);
            dfs(s, a, t, i+1);
            t.pop_back();
        }
    }
};

int main(){
    vector<int> s{1,2,3,4,5,6};
    int n = s.size();
    vector<int> p(n,n, 0);
    Subset s_;
    s_.subset_(s, n, p, 0, 0);
    vector<vector<int>> res = s_.subset(s);
    for(auto r : res){
        for(auto i : r){
            cout << i << " ";
        }
        cout << endl;
    }
    cout << "Total " << res.size() << " subsets" << endl;
}
