// this is implemetation of List ADT from the book Data Structures and Algorithm Analysis
// copied by Xuqiang Fang on 15th, Oct, 2017

#ifndef LIST_H
#define LIST_H

#include<algorithm>
using namespace std;

template <typename Object>

//nested Node class for List class

class List
{
private:
    struct Node
    {
        Object data;
        Node *prev;
        Node *next;
    
        Node (const Object & d =Object{}, Node *p = nullptr, Node *n = nullptr):
        data{d}, prev{p}, next{n}
        {}
    
        Node (Object &&d, Node *p =nullptr, Node *n = nullptr):
        data{std::move(d)}, prev{p}, next{n} 
        {}
    };
public:
    // nested const_iterator class for List class
    class const_iterator
    {   
    public:
        const_iterator() : current{nullptr}
        { }
    
        const Object & operator*() const
        {
            return retrieve();
        }
        const_iterator & operator++ ( )
        {
            current = current->next;
            return *this;
        }

        const_iterator operator++ (int)
        {
            const_iterator old = *this;
            ++(*this);
            return old;
        }
        const_iterator & operator-- ( )
        {
            current = current->prev;
            return *this;
        }

        const_iterator operator-- ( int )
        {
            const_iterator old = *this;
            --( *this );
            return old;
        }

        bool operator== (const const_iterator & rhs) const
        {
            return current == rhs.current;
        }

        bool operator!= (const const_iterator & rhs) const
        {
            return !(*this == rhs);
        }
    protected:
        Node *current;
        Object & retrieve() const
        {
            return current -> data;
        }

        const_iterator (Node *p) : current{p}
        { }
    
        friend class List<Object>;

    };
    // nested iterator class for List class
    class iterator : public const_iterator
    {
    public:
        iterator()
        { }
    
        Object & operator*()
        {
            return const_iterator::retrieve();
        }

        const Object & operator* () const
        {
            return const_iterator::operator*();
        }

        iterator & operator++ ( )
        {
            this -> current = this->current->next;
            return *this;
        }

        iterator operator++ (int)
        {
            iterator old = *this;
            ++(*this);
            return old;
        }


        iterator & operator-- ( )
        {
            this->current = this->current->prev;
            return *this;
        }

        iterator operator-- ( int )
        {
            iterator old = *this;
            --( *this );
            return old;
        }

    protected:
        iterator (Node *p) : const_iterator{p}
        { }

       friend class List<Object>;
    };
public:
    //constructor
    List()
    {
        init();
    }
    List(const List &rhs)
    {
        init();
        for (auto & x : rhs)
        {
            push_back(x);
        }
    }
    ~List()
    {
        clear();
        delete head;
        delete tail;
    }
    List & operator= (const List & rhs)
    {
        List copy = rhs;
        std::swap(*this, copy);
        return *this;
    }
    
    List (List && rhs) : theSize{rhs.theSize}, head{rhs.head}, tail{rhs.tail}
    { 
        rhs.theSize = 0;
        rhs.head = nullptr;
        rhs.tail = nullptr;
    }

    List & operator= (List && rhs)
    { 
        std::swap(theSize, rhs.theSize);
        std::swap(head, rhs.head);
        std::swap(tail, rhs.tail);

        return *this;
    }

    iterator begin()
    {
        return iterator{head->next};
    }

    const_iterator begin() const
    {
        return const_iterator{head -> next};
    }

    iterator end()
    {
        return iterator{tail};
    }

    const_iterator end() const
    {
        return const_iterator{tail};
    }

    int size() const
    {
        return theSize;
    }
    bool empty() const
    {
        return size() == 0;
    }

    void clear()
    {
        while ( !empty())
        {
            pop_front();
        }
    }

    Object & front()
    {
        return *begin();
    }

    const Object & front() const
    {
        return *begin();
    }

    Object &back()
    {
        return *--end();
    }

    const Object & back() const
    {
        return *--end();
    }

    void push_front(const Object & x)
    {
        insert(begin(), x);
    }

    void push_front(Object && x)
    {
        insert(begin(), std::move(x));
    }

    void push_back(const Object & x)
    {
        insert(end(), x);
    }

    void push_back(Object && x)
    {
        insert(end(), std::move(x));
    }

    void pop_front()
    {
        erase(begin());
    }

    void pop_back()
    {
        erase(--end());
    }
    // insert x before itr
    iterator insert(iterator itr, const Object & x)
    {
        Node *p = itr.current;
        ++theSize;
        return iterator{p->prev = p->prev->next = new Node{x, p->prev, p}};
    }
    //insert x before itr
    iterator insert(iterator itr, Object && x)
    {
        Node *p = itr.current;
        ++theSize;
        return iterator{p->prev = p->prev->next = new Node{std::move(x), p->prev, p}};
    }

    //erase item at itr
    iterator erase(iterator itr)
    {   
        Node * p = itr.current;
        iterator retVal{p->next};
        p->prev->next = p->next;
        p->next->prev = p->prev;
        delete p;
        --theSize;
        
        return retVal;
    }

    iterator erase(iterator from, iterator to)
    {
        for (iterator itr = from; itr != to;)
        {
            itr = erase(itr);
        }
        return to;
    }

private:
    int theSize;
    Node *head;
    Node *tail;

    void init()
    {
        theSize = 0;
        head = new Node;
        tail = new Node;
        head -> next = tail;
        tail -> prev = head;
    }
    
};

#endif