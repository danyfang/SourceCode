/*
    ���ȣ��µ�һ��ugly number�϶��Ǵӽ�С��ugly number����2,3��5������
    ��ô����ά�������±�id0,id1,id
    ��ugly[id0]*2,ugly[id1]*3,ugly[id2]*5����СֵΪ��һ����
    ע����Сֵ������ڵ�ǰ����ugly number�е����ֵ����Ȼ�ͻ��ظ���
    time O(n)
*/

class Solution {
public:
    int nthUglyNumber(int n) {
        typedef long long ll;
        int *ugly = new int[n];
        int id0 = 0,id1 = 0,id2 = 0;
        int cnt = 0;
        ugly[cnt] = 1;
        while(cnt != n - 1){
            //������ڵ�ǰ����ugly number�е����ֵ����Ȼ�ͻ��ظ���
            while(ugly[id0] * 2 <= ugly[cnt])   ++id0;
            while(ugly[id1] * 3 <= ugly[cnt])   ++id1;
            while(ugly[id2] * 5 <= ugly[cnt])   ++id2;
            //��СֵΪ��һ����
            int minid = id0,minval = ugly[id0] * 2;
            if(ugly[id1] * 3 < minval){
                minval = ugly[id1] * 3;
                minid = id1;
            }
            if(ugly[id2] * 5 < minval){
                minval = ugly[id2] * 5;
                minid = id2;
            }
            ugly[++cnt] = minval;
            if(minid == id0)    ++id0;
            else if(minid == id1)   ++id1;
            else    ++id2;
        }
        int res = ugly[n-1];
        delete [] ugly;
        return res;
    }
};
