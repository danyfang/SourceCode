//Leetcode Problem No. 179 Largest Number
//Solution written by Xuqiang Fang on 12 April,2018 

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution{
public:
    string largestNumber(vector<int>& nums){
        vector<string> arr;
        for(const auto i : nums){
            arr.push_back(to_string(i));
        }
        sort(begin(arr), end(arr), [](string &s1, string &s2){return s1+s2 > s2+s1;});
        string result;
        for(const auto s : arr){
            result += s;
        }
        if(result[0] == '0')
            return "0";
        return result;
    }
};

int main(){
    Solution s;
    vector<int> nums = {3,30,34,5,9};
    vector<int> nums2 = {0,0,0,0,0,1,0};
    cout << s.largestNumber(nums) << endl;
    cout << s.largestNumber(nums2) << endl;
    return 0;
}
