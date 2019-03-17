class UnionFind{
public:
  int find(int i){
    auto p = parent[i];
    if(i == p){
      return i;
    }
    return parent[i] = find(p);
  } 

  void union_op(int i, int j){
    int p1 = find(i);
    int p2 = find(j);
    if(p1 != p2){
      parent[p1] = p2;
    }
  }
  int get(){
    return 0;
  }
  UnionFind(int n){
    parent = vector<int>(n, -1);
    for(int i=0; i<n; ++i){
      parent[i] = i;
    }
  }
private:
  vector<int> parent;
};
