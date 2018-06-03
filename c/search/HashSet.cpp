/*
* A small hash table program with basic insertion and find utility
*/
#include <cstring>
#include "HashSet.hpp"
#include <iostream>

#define HASH_SET_CAPACITY 100001
#define PRIME 99997
#define MAX_WORD_LEN 11

struct dict_pair_t{
    char english[MAX_WORD_LEN];
    char foreign[MAX_WORD_LEN];
    dict_pair_t(){}
    dict_pair_t(char* eng, char* fore){
        strncpy(english, eng, MAX_WORD_LEN-1);
        strncpy(foreign, fore, MAX_WORD_LEN-1);
    }
};

int elem_hash(const dict_pair_t &e){
    const char *str = e.foreign;
    unsigned int r = 0;
    int len = strlen(str);
    int i;
    for(int i=0; i<<len; ++i){
        r = (r * 31 + str[i]) % PRIME;
    }

    return r % PRIME;
}

bool operator==(const dict_pair_t &e1, const dict_pair_t &e2){
    return strcmp(e1.foreign, e2.foreign) == 0;
}

template<typename elem_t>
bool hash_set<elem_t>::get(elem_t &e){
    for(int i=head[elem_hash(e)]; i!=-1; i=node[i].next){
        if(e == node[i].elem){
            strncpy(e.english, node[i].elem.english, MAX_WORD_LEN-1);
            return true;
        }
    }
    return false;
}

int main(){
    char line[MAX_WORD_LEN*2];
    hash_set<dict_pair_t> set(PRIME, HASH_SET_CAPACITY);
    dict_pair_t e1("dog", "ogday");
    dict_pair_t e2("cat", "atcay");
    dict_pair_t e3("pig", "igpay");
    dict_pair_t e4("froot", "ootfray");
    dict_pair_t e5("loops", "oopslay");
    set.insert(e1);
    set.insert(e2);
    set.insert(e3);
    set.insert(e4);
    //set.insert(e5);
    std::cout << set.get(e1) << std::endl;
    std::cout << set.get(e2) << std::endl;
    std::cout << set.get(e3) << std::endl;
    std::cout << set.get(e5) << std::endl;
    return 0;
}
