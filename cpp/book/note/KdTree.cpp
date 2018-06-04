#include <iostream>
#include <vector>
#include <ctime>
using namespace std;

/**
 * Quick illustration of a two-dimensional tree.
 * No abstraction here.
 */
template <typename Comparable>
class KdTree
{
  public:
    KdTree( ) : root( nullptr ) { }

    void insert( const vector<Comparable> & x )
    {
        insert( x, root, 0 );
    }

    /**
     * Print items satisfying
     * low[ 0 ] <= x[ 0 ] <= high[ 0 ] and
     * low[ 1 ] <= x[ 1 ] <= high[ 1 ]
     */
    void printRange( const vector<Comparable> & low, 
                        const vector<Comparable> & high ) const
    {
        printRange( low, high, root, 0 );
    }
    
    /*
    * Return search result in a vector
    * Added by @xuqiang fang
    */
    vector<vector<Comparable>> search(const vector<Comparable> &low, const vector<Comparable> &high) 
    {
        return search(low, high, root, 0); 
    }
  private:
    struct KdNode
    {
        vector<Comparable> data;
        KdNode            *left;
        KdNode            *right;

        KdNode( const vector<Comparable> & item )
          : data( item ), left( nullptr ), right( nullptr ) { }
    };

    KdNode *root;

    void insert( const vector<Comparable> & x, KdNode * & t, int level )
    {
        if( t == nullptr )
            t = new KdNode( x );
        else if( x[ level ] < t->data[ level ] )
            insert( x, t->left, 1 - level );
        else
            insert( x, t->right, 1 - level );
    }

    void printRange( const vector<Comparable> & low,
                     const vector<Comparable> & high,
                     KdNode *t, int level ) const
    {
        if( t != nullptr )
        {
            if( low[ 0 ] <= t->data[ 0 ] && high[ 0 ] >= t->data[ 0 ] && 
                low[ 1 ] <= t->data[ 1 ] && high[ 1 ] >= t->data[ 1 ] )
                cout << "(" << t->data[ 0 ] << "," 
                            << t->data[ 1 ] << ")" << endl;

            if( low[ level ] <= t->data[ level ] )
                printRange( low, high, t->left, 1 - level );
            if( high[ level ] >= t->data[ level ] )
                printRange( low, high, t->right, 1 - level );
        }
    }

    vector<vector<Comparable>> search( const vector<Comparable> & low,
                     const vector<Comparable> & high, KdNode *t, int level )
    {
        vector<vector<Comparable>> ans;
        if(t != nullptr)
        {
            if( low[ 0 ] <= t->data[ 0 ] && high[ 0 ] >= t->data[ 0 ] && 
                low[ 1 ] <= t->data[ 1 ] && high[ 1 ] >= t->data[ 1 ] )
            {
                ans.push_back({t->data[0], t->data[1]}); 
            }
            if(low[level] <= t->data[level])
            {
                /*use rvalue reference*/
                vector<vector<Comparable>> &&tmp = search(low, high, t->left, 1-level);
                ans.insert(ans.end(), tmp.begin(), tmp.end());
            }
            if(high[level] >= t->data[level])
            {
                /*use rvalue reference*/
                vector<vector<Comparable>> &&tmp = search(low, high, t->right, 1-level);
                ans.insert(ans.end(), tmp.begin(), tmp.end());
            }
        }
        return ans;
    }
};

// Test program
int main( )
{
    KdTree<int> t;
    
    cout << "Starting program" << endl;
    for( int i = 300; i < 1070; ++i )
    {
        vector<int> it( 2 );
        it[ 0 ] =  i;
        it[ 1 ] =  2500 - i;
        t.insert( it );
    }

    vector<int> low( 2 ), high( 2 );
    low[ 0 ] = 70;
    low[ 1 ] = 1186;
    high[ 0 ] = 1200;
    high[ 1 ] = 2500;
    
    clock_t c_start = clock();
    //t.printRange( low, high );
    vector<vector<int>> ans;
    ans = t.search(low, high);
    clock_t c_end = clock();
    for(const auto &a : ans){
        cout << a[0] << " , " << a[1] << endl;
    }
    cout << "used time :" << 1000.0 * (c_end - c_start) / CLOCKS_PER_SEC << endl;
    return 0;
}
