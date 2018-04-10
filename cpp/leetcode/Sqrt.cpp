#include <iostream>
#include <string>

using namespace std;
class Solution{
public:
    int mySqrt(int x){
        if(x <= 1)
            return x;
        for(long long s = 1; s <= x; ++s){
            if(s * s > x)
                return s - 1;
        }
        return -1;
    }

    int mySqrt_(int x){
        int l = 1;
        int r = x;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(m > x / m){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return r;
    }

    int mySqrt_n(int a){
        constexpr double epsilon = 1e-2;
        double x = a;
        while(x * x - a > epsilon){
            x = (x + a / x) / 2.0;
        }
        return x;
    }
};

int main(int argc, char* argv[]){
    Solution s;
    cout << s.mySqrt_n(stoi(argv[1])) << endl;
    return 0;
}
