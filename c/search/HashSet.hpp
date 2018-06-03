#include <algorithm>
/*Hash function for the element*/
template<typename elem_t>
int elem_hash(const elem_t &e);

/*Comparator for the element*/
template<typename elem_t>
bool operator==(const elem_t &e1, const elem_t &e2);

/*Hash Set*/
template<typename elem_t>
class hash_set{
public:
    hash_set(int prime, int capacity);
    ~hash_set();
    bool find(const elem_t &elem);
    bool insert(const elem_t &elem);
    bool get(elem_t &e);
private:
    int prime;
    int capacity;

    int *head; /*index of the first bucket*/

    struct node_t{
        elem_t elem;
        int next;
        node_t(): next(-1){}
    } *node;

    int size;
};


template<typename elem_t>
hash_set<elem_t>::hash_set(int prime, int capacity){
    this->prime = prime;
    this->capacity = capacity;
    head = new int[prime];
    node = new node_t[capacity];
    std::fill(head, head+prime, -1);
    std::fill(node, node+capacity, node_t());
    size = 0;
}

template<typename elem_t>
hash_set<elem_t>::~hash_set(){
    this->prime = 0;
    this->capacity = 0;
    delete[] head;
    delete[] node;
    head = NULL;
    node = NULL;
    size = 0;
}

template<typename elem_t>
bool hash_set<elem_t>::find(const elem_t &elem){
    for(int i=head[elem_hash(elem)]; i != -1; i = node[i].next){
        if(elem == node[i].elem){
            return true;
        }
    }
    return false;
}

template<typename elem_t>
bool hash_set<elem_t>::insert(const elem_t &elem){
    const int hash_code = elem_hash(elem);
    for(int i=head[hash_code]; i != -1; i=node[i].next){
        if(elem == node[i].elem){
            return false;
        }
    }
    node[size].next = head[hash_code];
    node[size].elem = elem;
    head[hash_code] = size++;
    return true;
}


