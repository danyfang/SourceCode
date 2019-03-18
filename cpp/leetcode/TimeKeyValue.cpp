//Leetcode Problem No 981. Time Based Key-Value Store
//Solution written by Xuqiang Fang on 18 March, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class TimeMap{
public:
  TimeMap(){

  }
  void set(string key, string value, int timestamp){
    if(m.count(key) == 0){
      m[key] = {};
    }
    m[key][timestamp] = value;
  }
  string get(string key, int timestamp){
    string ans = "";
    if(m.count(key) != 0){
      auto& mm = m[key];
      auto it = mm.lower_bound(timestamp);
      if(it != mm.begin()){
        if(it != mm.end() && it->first == timestamp){
          ans = mm[it->first];
        }
        else{
          --it;
          ans = mm[it->first];
        }
      }
      else{
        if(it->first == timestamp)
          ans = mm[it->first];
      }
    }
    return ans;
  }
private:
  unordered_map<string, map<int, string>> m;
};

int main(){
  TimeMap kv;
  kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1   
  cout << kv.get("foo", 1) << endl;  // output "bar"   
  cout << kv.get("foo", 3) << endl;
  kv.set("foo", "bar2", 4);   
  cout << kv.get("foo", 4) << endl; // output "bar2"   
  cout << kv.get("foo", 5) << endl; //output "bar2"   
  return 0;
}
