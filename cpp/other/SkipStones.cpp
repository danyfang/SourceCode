#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <map>
#include <set>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution{
public:
  int getDistance(int n, int m, int t, vector<int>& d){
    if(n == 0 || m == n)
      return t;
    vector<int> dis(n+1, 0);
    dis[0] = d[0];
    int ans = d[0];
    for(int i=1; i<n; ++i){
      dis[i] = d[i] - d[i-1];
      ans = max(ans, dis[i]);
    }
    dis[n] = t-d[n-1];
    map<int, vector<int>> m_;
    set<int> s_;
    for(int i=0; i<=n; ++i){
      m_[dis[i]].push_back(i);
      s_.insert(i);
    }
    while(m-- > 0){
      auto k = m_.begin()->first;
      auto id = m_[k][0];
      auto id_add = s_.upper_bound(id);
      if(id_add == s_.end()){
        id_add = s_.lower_bound(id);
        id_add--;
      }
      //found the index of the element in dis to add
      auto addition = dis[*id_add];
      dis[*id_add] += dis[id];
      dis[id] = -1;
      s_.erase(id);
      auto new_add = dis[*id_add];
      //now update the m_, remove some key value pairs
      //the affected are the found one and the add one
      //and we need to add the new_add one
      if(m_[k].size() == 1){
        m_.erase(k);
      }
      else{
        vector<int> v;
        for(int x=0; x<m_[k].size(); ++x){
          v.push_back(m_[k][x]);
        }
        m_[k] = v;
      }
      if(m_[addition].size() == 1){
        m_.erase(addition);
      }
      else{
        vector<int> v;
        for(int x=0; x<m_[addition].size(); ++x){
          if(m_[addition][x] == *id_add){
            continue;
          }
          v.push_back(m_[addition][x]);
        }
        m_[addition] = v;
      }
      m_[new_add].push_back(*id_add);

    }
    for(auto& k : dis){
      if(k != -1){
        ans = min(ans, k);
      }
    }
    return ans;
  }
};

int main(){
  Solution s;
  vector<int> d{2,11,14,17,21};
  //cout << s.getDistance(5,2,25,d) << endl;
  //cout << s.getDistance(0,0,78,d) << endl;
  d = {3,4,5,6,7,8,9};
  cout << s.getDistance(7,4,78,d) << endl;
  return 0;
}
