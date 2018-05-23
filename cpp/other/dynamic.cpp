//dynamic programming example

/* A utility function to check whether a word is
  present in dictionary or not. An array of strings
  is used for dictionary.  Using array of strings for
  dictionary is definitely not a good idea. We have
  used for simplicity of the program*/



#include<iostream>
#include<string.h>

using namespace std;

int dictionaryContains(string word){
    string dictionary[] = {"mobile", "xiaomi","xiao","mi","man","mango","xuqiang", "susu","susie","fang","icecream","and","go","i","like","ice","cream"," "};
    int size =  sizeof(dictionary)/sizeof(dictionary[0]);
    for(int i = 0; i < size; i++){
        if(dictionary[i].compare(word) == 0)
            return true;
    }
    return false;
}
bool wordBreak(string str){
    int size =  str.size();
    cout << "str.size(): " << size << endl;
    if(size == 0) return true;
    bool wb[size+1];
    memset(wb,0,sizeof(wb));

    for(int i=1; i<=size; i++){
        if(wb[i] == false && dictionaryContains(str.substr(0,i))){
            cout << str.substr(0,i) << endl;
            wb[i] = true;
        }
        if(wb[i] == true){
            if(i == size){
                return true;
            }
            for(int j=i+1; j<=size; j++){
                if(wb[j] == false && dictionaryContains(str.substr(i,j-i))){
                    wb[j] = true;
                    cout << str.substr(i,j-1) << endl;
                }
                if(j == size && wb[j] == true){
                    return true;
                }
            }
        }
    }
    return false;
}




int main(){
    wordBreak("ilikexuqiangfangicecreamsusususie")? cout << "Yes\n": cout<< "No\n";
}
