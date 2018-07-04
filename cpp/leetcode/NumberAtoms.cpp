//Leetcode Problem No726 Number of Atoms
//Solution written by Xuqiang Fang on 2 July, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <map>

using namespace std;
class Solution{
public:
    string countOfAtoms(string& f){
        i = 0;
        string ans;
        for(const auto& kv : helper(f)){
            ans += kv.first;
            if(kv.second > 1){
                ans += to_string(kv.second);
            }
        }
        return ans;
    }
private:
    map<string, int> helper(const string& f){
        map<string, int> counts;
        while(i != f.length()){
            if(f[i] == '('){
                ++i;
                const auto& tmp = helper(f);
                const int c = getCount(f);
                for(const auto& kv : tmp){
                    counts[kv.first] += kv.second * c;
                }
            }
            else if(f[i] == ')'){
                ++i;
                return counts;
            }
            else{
                const string& name = getName(f);
                counts[name] += getCount(f);
            }
        }
        return counts;
    }
    string getName(const string& f){
        string name;
        while(isalpha(f[i]) && (name.empty() || islower(f[i]))){
            name += f[i++];
        }
        return name;
    }
    int getCount(const string& f){
        string str;
        while(isdigit(f[i])){
            str += f[i++];
        }
        return str.empty() ? 1 : stoi(str);
    }
    int i;
};

int main(){
    Solution s;
    string formula{"K4(ON(SO3)2)2"};
    cout << s.countOfAtoms(formula) << endl;
    formula = "H2MgO2";
    cout << s.countOfAtoms(formula) << endl;
    return 0;
}
