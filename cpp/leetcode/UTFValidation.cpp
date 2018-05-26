//Leetcode Problem No. 398 UTF-8 Validation
//Solution written by Xuqiang Fang on 24 May, 2018

#include <iostream>
#include <vector>
#include <bitset>

using namespace std;
class Solution{
public:
    bool validUtf8(vector<int>& data) {
        vector<string> s;
        for(auto d : data){
            s.push_back(bitset<8>(d).to_string());
        }
        int remain = 0;
        int i = 0;
        while(i < s.size()){
            string w = s[i];

        }
        return false;
    }
};

int main(){
    Solution s;
    vector<int> data{197, 130, 1};
    s.validUtf8(data);
    return 0;
}
