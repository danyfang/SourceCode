#ifndef HASH_FUNCTION
#define HASH_FUNCTION


int HashFunction(int TableSize, int key){
    return key%TableSize;
}

#endif