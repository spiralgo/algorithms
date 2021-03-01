import java.util.HashMap;
import java.util.Map;
 
// A class to represent a disjoint set
class DisjointSet
{
    private Map<Integer, Integer> parent = new HashMap();
 
    // stores the depth of trees
    private Map<Integer, Integer> rank = new HashMap();
 
    // perform MakeSet operation
    public void makeSet(int[] universe)
    {
        // create `n` disjoint sets (one for each item)
        for (int i: universe)
        {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }
 
    // Find the root of the set in which element `k` belongs
    public int find(int k)
    {
        // if `k` is not the root
        if (parent.get(k) != k)
        {
            // path compression
            parent.put(k, find(parent.get(k)));
        }
 
        return parent.get(k);
    }
 
    // Perform Union of two subsets
    public void union(int a, int b)
    {
        // find the root of the sets in which elements
        // `x` and `y` belongs
        int x = find(a);
        int y = find(b);
 
        // if `x` and `y` are present in the same set
        if (x == y) {
            return;
        }
 
        // Always attach a smaller depth tree under the
        // root of the deeper tree.
        if (rank.get(x) > rank.get(y)) {
            parent.put(y, x);
        }
        else if (rank.get(x) < rank.get(y)) {
            parent.put(x, y);
        }
        else {
            parent.put(x, y);
            rank.put(y, rank.get(y) + 1);
        }
    }
    
      public static void printSets(int[] universe, DisjointSet ds)
    {
        for (int i: universe) {
            System.out.print(ds.find(i) + " ");
        }
 
        System.out.println();
    }
 
    public static void main(String[] args)
    {
        // universe of items
        int[] universe = { 1, 2, 3, 4, 5 };
 
        // initialize `DisjointSet` class
        DisjointSet ds = new DisjointSet();
 
        // create a singleton set for each element of the universe
        ds.makeSet(universe);
        printSets(universe, ds);
 
        ds.union(4, 3);        // 4 and 3 are in the same set
        printSets(universe, ds);
 
        ds.union(2, 1);        // 1 and 2 are in the same set
        printSets(universe, ds);
 
        ds.union(1, 3);        // 1, 2, 3, 4 are in the same set
        printSets(universe, ds);
    }
}
 
 

