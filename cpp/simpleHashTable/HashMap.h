#ifndef HASH_MAP
#define HASH_MAP

#include "HashEntry.h"
#include "HashFunction.h"


const int TABLE_SIZE = 117;
class HashMap{
private:
    HashEntry **table;
public:
    HashMap(){
        table =  new HashEntry*[TABLE_SIZE];
        for (int i=0; i<TABLE_SIZE; i++){
            table[i] = NULL;
        }
    }

    // hash operation, collision resolving policy is linear probing
    void put(int key, int value){
        int hash = HashFunction(TABLE_SIZE, key);
        while(table[hash] != NULL && table[hash]->getKey() != key)
            hash = HashFunction(TABLE_SIZE,hash+1);
        if (table[hash] != NULL)
            delete table[hash];
        table[hash] = new HashEntry(key, value);
    }

    // hash search operation, the search scheme should follow
    // the hash scheme, namely, linear probing
    int search(int key){
        int hash = HashFunction(TABLE_SIZE,key);
        while(table[hash] != NULL && table[hash]->getKey()!= key)
            hash = HashFunction(TABLE_SIZE, hash+1);
        if(table[hash] == NULL)
            return -1;
        else    
            return table[hash]->getValue();
    }
 

    ~HashMap(){
        for (int i= 0; i<TABLE_SIZE; i++)
            if (table[i] != NULL)
                delete table[i];
        delete[] table;
    }
        

};

#endif
