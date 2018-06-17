// this program is created by Xuqiang Fang on Oct 19th, 2017
// it's for data structure and algorithm analysis

#ifndef BINARYSEARCHTREE_H
#define BINARYSEARCHTREE_H
#include <algorithm>
#include "dsexceptions.h"
using namespace std; 

template <typename Comparable>
class BinarySearchTree
{
public:
    // for all public member functions that have the same name with corresponding 
    // private ones, each public function will call the private one
    bool contains(const Comparable & x) const
    {
        return contains(x, root);
    }
    void insert(const Comparable & x)
    {
        insert(x,root);
    }
    void insert(const Comparable && x)
    {
        insert(x,root);
    }
    void remove(const Comparable & x)
    {
        remove(x,root);
    }
    //constructor
    BinarySearchTree( ) : root{ nullptr }{}
    //destructor
    ~BinarySearchTree()
    {
        makeEmpty();
    }
    // copy constructor
    BinarySearchTree(const BinarySearchTree & rhs):root{nullptr}
    {
        root = clone(rhs.root);
    }
    BinarySearchTree(const BinarySearchTree && rhs):root{rhs.root}
    {
        rhs.root = nullptr;
    }
    // copy assignment
    BinarySearchTree & operator= (const BinarySearchTree & rhs)
    {
        BinarySearchTree copy = this;
        std::swap(*this, copy);
        return *this;
    }
    // move assignment
    BinarySearchTree & operator= (BinarySearchTree && rhs)
    {
        std::swap(root,rhs.root);
        return *this;
    }
    
    const Comparable & findMin() const
    {
        if (isEmpty())
            throw UnderflowException{};
        return findMin(root)->element;
    }
    const Comparable & findMax() const
    {
        if (isEmpty())
            throw UnderflowException{};
        return findMax(root)->element;
    }
    bool isEmpty() const
    {
        return root == nullptr;
    }
    void printTree(ostream & out = cout) const
    {
        if(isEmpty())
            out << "Empty Tree" << endl;
        else 
            printTree(root,out);
    }
    void makeEmpty()
    {
        makeEmpty(root);
    }

private:
    struct BinaryNode
    {
        Comparable element;
        BinaryNode *left;
        BinaryNode *right;

        BinaryNode(const Comparable & theElement, BinaryNode *lt, BinaryNode *rt):
        element{theElement}, left{lt}, right{rt} {}
        BinaryNode(Comparable &&theElement, BinaryNode *lt, BinaryNode *rt):
        element{std::move(theElement)},left{lt},right{rt}{}
    };

    BinaryNode *root;

    void insert(const Comparable & x, BinaryNode * & t)
    {
        if (t == nullptr)
            t = new BinaryNode(x, nullptr, nullptr);
        else if (x < t->element)
            insert(x, t->left);
        else if (x > t->element)
            insert(x, t->right);
        else
            ;//duplicate, do nothing
    }
    void insert(Comparable && x, BinaryNode * & t)
    {
        if (t == nullptr)
            t = new BinaryNode(std::move(x), nullptr, nullptr);
        else if (t < t->element)
            insert(std::move(x), t->left);
        else if (t > t->element)
            insert(std::move(x), t->right);
        else
            ;// duplicate, do nothing
    }
    void remove(const Comparable & x, BinaryNode * & t)
    {
        if (t == nullptr)
            return;
        if (x < t->element)
            remove(x, t->left);
        if (x > t->element)
            remove(x, t->right);
        else if (t->left != nullptr && t->right != nullptr)// two children
        {
            t->element = findMin(t->right)->element;
            remove(t->element, t->right);
        }
        else
        {
            BinaryNode * oldNode = t;
            t = (t->left != nullptr) ? t->left:t->right;
            delete oldNode;
        }
    }
    BinaryNode *findMin(BinaryNode *t) const
    {
        if (t == nullptr)
            return nullptr;
        if (t->left == nullptr)
            return t;
        return findMin(t->left);
    }
    
    BinaryNode *findMax(BinaryNode *t) const
    {
        if (t != nullptr)
            while (t->right != nullptr)
                t = t->right;
        return t;
    }

    bool contains(const Comparable & x, BinaryNode *t) const
    {
        if (t == nullptr)
            return false;
        else if (x < t->element)
            return contains(x, t->left);
        else if (x > t->element)
            return contains(x, t->right);
        else 
            return true;
    }
    void makeEmpty(BinaryNode * & t)
    {
        if (t != nullptr)
        {
            makeEmpty(t->left);
            makeEmpty(t->right);
            delete t;
        }
        t =nullptr;
    }
    void printTree(BinaryNode * t, ostream & out) const;
    BinaryNode * clone(BinaryNode *t) const
    {
        if (t == nullptr)
            return nullptr;
        else 
            return new BinaryNode{t->element, clone(t->left), clone(t->right)};
    }
};

#endif