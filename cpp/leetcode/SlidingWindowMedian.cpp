//Leetcode Problem No 480 Sliding Window Median
//Solution written by Xuqiang Fang on 5 June, 2018

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
    vector<double> medianSlidingWindow(vector<int> &nums, int k){
        int n = nums.size();
        vector<double> ans;
        if(k == 0){
            for(int i=0; i<n; ++i){
                ans.push_back((double)nums[i]);
            }    
            return ans;
        }
        vector<int> s(k, 0);
        for(int i=0; i<k; ++i){
            s[i] = nums[i];
        }
        sort(s.begin(), s.end());
        if(k & 1){//k is odd 
            ans.push_back((double)s[(k-1)/2]);
            for(int i=k; i<n; ++i){
                insert_delete(s, nums[i-k], nums[i]);
                ans.push_back((double)s[(k-1)/2]);
            }
        }
        else{
            ans.push_back((double)(s[k/2-1]+s[k/2])/2.0);
            for(int i=k; i<n; ++i){
                insert_delete(s, nums[i-k], nums[i]);
                ans.push_back((double)(s[k/2-1]+s[k/2])/2.0);
            } 
        }
        return ans;
    }
private:
    //a function to remove an element out from the already-sorted array
    //and insert a new element in
    //array in asscending order
    void insert_delete(vector<int> &nums, int out, int in){
        //cout << "out = " << out << ", in = " << in << endl;
        if(in < out){
            //in this case, we need to insert in before out
            //before we find the right spot, all elements must move one spot right
            for(int i=0; i<nums.size(); ++i){
                if(nums[i] == out){
                    for(int j=i; j>=1; --j){
                        if(in >= nums[j-1]){
                            nums[j] = in;
                            return;
                        }
                        else{
                            nums[j] = nums[j-1];
                        }
                    }        
                    nums.front() = in;
                } 
            }
        }
        else if(in > out){
            //in this case, we need to insert in after out
            //before we find the right spot, all elements must move one spot left
            for(int i=nums.size()-1; i>=0; --i){
                if(nums[i] == out){
                    for(int j=i; j<nums.size()-1; ++j){
                        if(in <= nums[j+1]){
                            nums[j] = in;
                            return;
                        }
                        else{
                            nums[j] = nums[j+1];
                        }
                    }
                    nums.back() = in;
                }
            } 
        }
    }
};

int main(){
    Solution s;
    vector<int> nums{1,3,-1,-3,5,3,6,7};
    vector<double> a = s.medianSlidingWindow(nums, 3);
    for(auto b : a){
        cout << b << " ";
    }
    cout << endl;
    return 0;
}
