//Leetcode Problem No 953 Verifying an Alien Dictionary
//Solution written by Xuqiang Fang on 10 Dec, 2018

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
    bool isAlienSorted(vector<string>& words, string order) {
        const int n = words.size();
        unordered_map<char, int> m;
        int index = 0;
        for(auto& c : order){
            m[c] = index++;
        }
        for(int i=0; i<n-1; ++i){
            if(!less(words[i], words[i+1], m))
                return false;
        }
        return true;
    }
private:
    bool less(string& a, string& b, unordered_map<char, int>& m){
        /*determine if a is less than b*/
        int l = 0, r = 0;
        while(l < a.length() && r < b.length()){
            if(m[a[l]] < m[b[r]]){
                return true;
            }
            else if(m[a[l]] > m[b[r]]){
                return false;
            }
            l++;
            r++;
        }
        if(l == a.length()){
            return true;
        }
        return false;
    }
};

int main(){
    Solution s;
    vector<string> words{"word","world","row"};
    string order{"worldabcefghijkmnpqstuvxyz"};
    cout << s.isAlienSorted(words, order) << endl;
    words = {"apple","app"};
    order = "abcdefghijklmnopqrstuvwxyz";
    cout << s.isAlienSorted(words, order) << endl;
    words = {"hello","leetcode"};
    order = "hlabcdefgijkmnopqrstuvwxyz";
    cout << s.isAlienSorted(words, order) << endl;
    words = {"ubg","kwh"};
    order = "qcipyamwvdjtesbghlorufnkzx";
    cout << s.isAlienSorted(words, order) << endl;
    return 0;
}
