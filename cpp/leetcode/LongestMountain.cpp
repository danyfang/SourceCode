//Leetcode Problem No 845 Longest mountain in Array
//Solution written by Xuqiang Fang on 3 June, 2018

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
    int longestMountain(vector<int>& A) {
        int n = A.size();
        if(n < 3){
            return 0;
        }
        int m = 0;
        for(int i=1; i<n-1; ++i){
            if(A[i-1] < A[i] && A[i+1] < A[i]){
                m = max(m, 1+left(A, i-1)+right(A, i+1));
            }
        }
        return m;
    }

private:
    int left(vector<int>& A, int index){
        int c = 1;
        for(int i=index-1; i>=0; --i){
            if(A[i] < A[i+1]){
                c++;
            }
            else{
                break;
            }
        }
        return c;
    }
    int right(vector<int>& A, int index){
        int c = 1;
        for(int i=index+1; i<A.size(); ++i){
            if(A[i] < A[i-1]){
                c++;
            }
            else{
                break;
            }
        }
        return c;
    }
};

int main(){
    Solution s;
    vector<int> A{2,1,4,7,3,2,5};
    vector<int> B{2,2,2};
    cout << s.longestMountain(A) << endl;
    cout << s.longestMountain(B) << endl;
    return 0;
}
