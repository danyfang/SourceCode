//Leetcode Problem No 1024. Video Stitching
//Solution written by Xuqiang Fang on 12 May, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution {
public:
    int videoStitching(vector<vector<int>>& clips, int T) {
        int count = 0;
        sort( clips.begin( ), clips.end( ), [ ]( vector<int>& lhs, vector<int>& rhs ){
            if(lhs[0] == rhs[0]){
                return rhs[1] < lhs[1];
            }
            return lhs[0] < rhs[0];
        });
        //for(auto c : clips){
        //    cout << c[0] << c[1] << endl;
        //}
        if(clips[0][0] != 0){
            return -1;
        }
        auto point = clips[0];
        auto temp = point;
        count++;
        if(point[1] >= T){
            return count;
        }
        const int n = clips.size();
        for(int i=1; i<n; ++i){
            if(clips[i][0] == clips[i-1][0] || clips[i][1] <= point[1]){
                continue;
            }
            if(clips[i][0] > point[1]){
                if(clips[i][0] > temp[1]){
                    return -1;
                }
                point = temp;
                //cout << temp[0] <<  " " << temp[1] << endl;
            }
            if(clips[i][1] > temp[1]){
                if(temp[0] == point[0] && temp[1] == point[1]){
                    count++;
                }
                temp = clips[i];
                if(clips[i][1] >= T){
                    //cout << temp[0] <<  " " << temp[1] << endl;
                    return count;
                }
            }
        }
        if(point[1] < T){
            return -1;
        }
        return count;
    }

  //another classic solution
  int videoStitching2(vector<vector<int>>& clips, int T){
    sort(clips.begin(), clips.end());
    int ans = 0;
    for(auto i=0, st=0, end=0; st<T; st=end, ++ans){
      for(; i<clips.size() && clips[i][0]<=st; ++i){
        end = max(end, clips[i][1]);
      }
      if(st == end){
        return -1;
      }
    }
    return ans;
  }
};

int main(){
  Solution s;
  vector<vector<int>> clips = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
  cout << s.videoStitching(clips, 9) << endl;
  cout << s.videoStitching2(clips, 9) << endl;
  return 0;
}
