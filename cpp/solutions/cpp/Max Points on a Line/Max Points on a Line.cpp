/*
    ��ͬһֱ���ϵĵ�б����ͬ����ô������O(n)ö��ÿ���㣬��O(n)ö�������������б�ʣ�����б����ͬ�ĵ����һ��ֱ����
    �����ڸ������ļ�������0�����أ����Դ����б�ʵ�dx��dy(dx��dy�Ǿ�������ģ��������)
    ����ʱ�临�Ӷ���O(n^2)
*/

class Solution {
public:
    int maxPoints(vector<Point>& points) {
        typedef pair<int,int> P;
        if(points.size() == 1 || points.size() == 0)    return points.size();
        int res = 0;
        for(int i = 0;i < points.size();i++){
            map<P,int> cnt;                             //pair��dx��dy��int�����б�ʳ��ֵĴ���
            int maxval = 0;                             //��i��ֱ�ߵ���๲�ߵ����
            for(int j = i + 1;j < points.size();j++){
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                if(dx == 0 && dy == 0){                 //���i��j��һ��λ���ϣ���ôj���Լӵ�������iֱ���ϣ�����ͳ��ʱ��Ҫ����cnt[P(0,0)]
                    cnt[P(0,0)]++;
                    maxval++;
                }
                else if(dx == 0){                                       //dx == 0 && dy != 0 ͳһ��(0,1)��ʾ
                    maxval = max(maxval,++cnt[P(0,1)] + cnt[P(0,0)]);
                }
                else if(dy == 0){                                       //dx != 0 && dy == 0 ͳһ��(1,0)��ʾ
                    maxval = max(maxval,++cnt[P(1,0)] + cnt[P(0,0)]);
                }
                else{                                                   //dx��dy���ͬ�Ŷ�ȡ��������dxȡ��
                    if(dx * dy < 0){
                        dx = -abs(dx);dy = abs(dy);
                    }
                    else{
                        dx = abs(dx);dy = abs(dy);
                    }
                    int tmp = gcd(abs(dx),abs(dy));                     //��dx��dy�����Լ��
                    dx /= tmp;
                    dy /= tmp;
                    maxval = max(maxval,++cnt[P(dx,dy)] + cnt[P(0,0)]);
                }
            }
            res = max(res,maxval);
        }
        return res + 1;
    }
    int gcd(int x,int y)
    {
        if(y == 0)  return x;
        else    return gcd(y,x%y);
    }
};

