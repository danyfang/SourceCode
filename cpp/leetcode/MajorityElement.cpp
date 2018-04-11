//Leetcode Problem No. 169 Majority ELement
//Solution written by Xuqiang Fang on 11 April, 2018 

#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    int majorityElement(vector<int>& nums){
        int majority = nums.front();
        int count = 0;
        for(const auto i : nums){
            if(i == majority)
                ++count;
            else if(--count == 0){
                majority = i;
                count = 1;
            }
        }
        return majority;
    }
};

int main(){
    Solution s;
    vector<int> nums{5,2,1,3,4,5,6,4,4,4,4,4};
    cout << s.majorityElement(nums) << endl; 
    return 0;
}
