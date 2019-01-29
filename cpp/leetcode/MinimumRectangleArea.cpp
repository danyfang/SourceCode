//Leetcode Problem No 963 Minimum Rectangle Area II
//Solution written by Xuqiang Fang on 28 Jan, 2019

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
    double minAreaFreeRect(vector<vector<int>>& points) {
        const int n = points.size();
        double ans = (double)INT_MAX;
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                for(int k=j+1; k<n; ++k){
                    for(int l=k+1; l<n; ++l){
                        auto p = isRectangle(points[i], points[j], points[k], points[l]);
                        if(p.first){
                            ans = min(ans, (double)p.second);
                        }
                    }
                }
            }
        }
        if(ans < INT_MAX){
            return ans;
        }
        return 0;
    }
private:
    pair<bool, double> isRectangle(vector<int>& a, vector<int>& b, vector<int>& c, vector<int>& d) {
        double x1 = (double)a[0],  y1 = (double)a[1];
        double x2 = (double)b[0],  y2 = (double)b[1];
        double x3 = (double)c[0],  y3 = (double)c[1];
        double x4 = (double)d[0],  y4 = (double)d[1];

        double cx,cy;
        double dd1,dd2,dd3,dd4;

        cx=(x1+x2+x3+x4)/4;
        cy=(y1+y2+y3+y4)/4;

        dd1=sqr(cx-x1)+sqr(cy-y1);
        dd2=sqr(cx-x2)+sqr(cy-y2);
        dd3=sqr(cx-x3)+sqr(cy-y3);
        dd4=sqr(cx-x4)+sqr(cy-y4);

        pair<bool, double> ans{false, 0};
        bool valid = abs(dd1-dd2)<10e-6 && abs(dd1-dd3)<10e-6 && abs(dd1-dd4)<10e-6;
        if(valid){
            ans.first = true;
            //cout << x1 << " " << y1 << ", " << x2 << " " << y2 << ", " << x3 << " " << y3 << ", " << x4 << " " << y4 << endl;
            ans.second = abs(x1*y2+x2*y3+x3*y1-x2*y1-x3*y2-x1*y3);
            //cout << ans.second << endl;
        }
        return ans;
    }
    
    double sqr(double x){
        return x * x;
    }
};
int main(){
    Solution s;
    vector<vector<int>> points {{1,2},{2,1},{1,0},{0,1}};
    cout << s.minAreaFreeRect(points) << endl;
    return 0;
}
