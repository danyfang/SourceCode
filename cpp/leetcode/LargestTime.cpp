//Leetcode Problem No 949 Largest Time For Given Digits
//Solution written by Xuqiang Fang on 

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
    string largestTimeFromDigits(vector<int>& A) {
        sort(A.begin(), A.end());
        vector<int> time;
        do{
            int ans = 0;
            for(auto& a : A){
                ans *= 10;
                ans += a;
            }
            cout << ans << endl;
            time.push_back(ans);
        }while(next_permutation(A.begin(), A.end()));
        sort(time.begin(), time.end(), greater<int>());
        for(auto& ans : time){
            if(valid(ans)){
                int hour = ans / 100;
                int minute = ans % 100;
                string h, m;
                if(hour < 10){
                    h += "0";
                }
                h += to_string(hour);
                if(minute < 10){
                    m += "0";
                }
                m += to_string(minute);
                string s = h + ":" + m;
                return s;
            }
        }
        string ans = "";
        return ans;
    }
private:
    bool valid(int a){
        int minute = a % 100;
        int hour = a / 100;
        return (minute < 60 && hour < 24);
    }
};

int main(){
    Solution s;
    vector<int> A{1,2,3,4};
    cout << s.largestTimeFromDigits(A) << endl;
    A = {5,5,5,5};
    cout << s.largestTimeFromDigits(A) << endl;
    A = {0,0,0,0};
    cout << s.largestTimeFromDigits(A) << endl;
    A = {4,1,0,0};
    cout << s.largestTimeFromDigits(A) << endl;
    /*
    string str = to_string(A[0]) + to_string(A[1])
        + to_string(A[2]) + to_string(A[3]);
    do{
        cout << str << endl;
    }while(next_permutation(str.begin(), str.end()));
    */
    return 0;
}
