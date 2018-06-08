//Leetcode Problem No  493 Reverse Pairs
//Solution written by Xuqiang Fang on 6 June, 2018

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
    int reversePairs(vector<int>& nums) {
        int n = nums.size();
        int count = mergesort(nums, 0, n);
        return count;
    }
private:
    int mergesort(vector<int> &nums, int left, int right){
        if(right - left <= 1){
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergesort(nums, left, mid) + mergesort(nums, mid, right);
        vector<int> cache(right-left, 0);
        int i = left, j = mid, k = 0;
        for(int x=mid; x<right; ++x){
            if((long)nums[mid-1] > (long)nums[x]*2){
                count += binarySearch(nums, left, mid, nums[x]);
            }
        }
        //the following is a standard merge sort routine
        while(i < mid && j < right){
            if(nums[j] < nums[i]){//it comes from the right half
                cache[k++] = nums[j++]; 
            }  
            else{
                cache[k++] = nums[i++];
            }
        }
        while(i < mid){//j == right
            cache[k++] = nums[i++];
        }
        while(j < right){
            cache[k++] = nums[j++]; 
        }
        for(int x=0; x<right-left; ++x){
            nums[x+left] = cache[x];
        }
        return count;
    }

    int binarySearch(vector<int> &nums, int left, int right, int p){
        int l = left;
        int r = right;
        while(l < r){
            int m = l + (r - l) / 2;
            if((long)nums[m] > (long)p * 2){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return right - l;
    }
};

int main(){
    Solution s;
    vector<int> nums{1,3,2,3,1};
    vector<int> num{2,4,3,5,1};
    vector<int> nu{4,4,4,4,4,1};
    cout << s.reversePairs(nums) << endl;
    cout << s.reversePairs(num) << endl;
    cout << s.reversePairs(nu) << endl;
    return 0;
}
