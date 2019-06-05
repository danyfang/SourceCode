//Leetcode Problem No 
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
    long long playGames(vector<int> &A) {
        // Write your code here
        const int n = A.size();
        int s = 0;
        int m = A[0];
        for(auto& a : A){
            s += a;
            m = max(m, a);
        }
        int ans = s/(n-1);
        if(s % (n-1) != 0)
          ans++;
        return max(ans, m);
    }  
};

int main(){
  Solution s;
  vector<int> d{84,53};
  cout << s.playGames(d) << endl;
  d = {1,2,3,4,5,6,7};
  cout << s.playGames(d) << endl;
  d = {2,2,2,2,2,2};
  cout << s.playGames(d) << endl;
  d = {7,6,2,8,2,9,6,9,6,0,1,2,7,0,9,3,3,3,1,9,7};
  cout << s.playGames(d) << endl;
  d = {500023556,500011764,500002781,500014185,500030108,500001641,500027907,500015524,500006183,500026711,500018892,500000204,500005471,500002015,500018661,500000178,500023396,500011505,500007055,500019803,500002225,500018283,500020537,500024908,500031823,500003717,500001108,500023300,500013896,500012140,500026723,500016587,500007263,500020269,500019025,500012714,500030462,500025557,500006664,500010171,500014960,500010454,500007231,500012195,500028752,500012973,500016275,500014684,500021826,500026050,500018394,500026168,500032481,500021648,500017332,500030754,500007672,500018693,500000098,500017959,7};
  cout << s.playGames(d) << endl;  
  return 0;
}
