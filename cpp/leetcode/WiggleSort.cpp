//Leetcode Problem No. 324 Wiggle Sort II
//Solution written by Xuqiang Fang on 24 May, 2018

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
class Solution{
public:
    void wiggleSort(vector<int>& nums) {
        vector<int> copy(nums); 
        sort(copy.begin(), copy.end());
        int index = 0;
        int n = copy.size();
        /**
        I think the question really is: is there a fixed way to produce a valid permutation
        */
        if(n % 2 != 0){
            int i = 0;
            while(index < n){
                nums[i] = copy[index++]; 
                i = i + 2;
                if(i >= n){
                    i = 1;
                }
            }
        }
        else{
            //from right to the left
            int i = n-2;        
            while(index < n){
                nums[i] = copy[index++];
                i = i - 2;
                if(i < 0){
                    i = n-1;
                }
            }
        }
        for(auto j : nums){
            cout << j << endl;
        }
    }
};
int main(){
    Solution s;
    vector<int> nums{1,5,1,1,6,4};
    vector<int> n{1,2,3,3,3,4};//3,4,1,3,2,3
    //{4,5,5,6}
    vector<int> num{4,5,5,5,5,6,6,6};
    s.wiggleSort(nums);
    s.wiggleSort(n);
    s.wiggleSort(num);
    return 0;
}
