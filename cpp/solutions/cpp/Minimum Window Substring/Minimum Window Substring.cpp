/*
    ��s����߿�ʼɨ��ά��һ����˵��һ���Ҷ˵�
    �����ǰ�����ж�����ַ��ʹ���˼����п�ȱ�ʹ��Ҷ˼�
    ʱ�临�Ӷ�O(n)
*/

class Solution {
public:
    string minWindow(string s, string t) {
        int cnts[300] = {0},cntt[300] = {0};
        for(int i = 0;i < t.size();i++)     cntt[t[i]]++; //ͳ��t��ÿ��Ԫ�صĸ���
        int lhs = 0,rhs = 0;
        int resl = -1,resr = s.size();  //�����ַ�������˺��Ҷ�
        int sum = 0;                    //ͳ��s�����е�t���ַ��ĸ���
        while(rhs < s.size()){
            cnts[s[rhs]]++;                //ͳ��s��ÿ��Ԫ�صĸ���
            if(cntt[s[rhs]] && cntt[s[rhs]] >= cnts[s[rhs]])   sum++;
            if(cnts[s[rhs]] > cntt[s[rhs]]){                        //����ж���ģ���s��˿�ʼ��
                while(lhs <= rhs && cnts[s[lhs]] > cntt[s[lhs]]){
                    cnts[s[lhs]]--;
                    lhs++;
                }
            }
            if(sum == t.size() && rhs - lhs < resr - resl){
                resr = rhs;
                resl = lhs;
            }
            rhs++;
        }
        string res;
        if(resl == -1)  return res;
        else    return s.substr(resl,resr - resl + 1);
    }
};
