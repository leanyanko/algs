package b_find;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;


/*
* Question 2
*Union-find with specific canonical element. Add a method find()
* to the union-find data type so that find(i) returns the largest
* element in the connected component containing i. The operations,
* union(), connected(), and find() should all take logarithmic time or better.
* For example, if one of the connected components is {1,2,6,9}, then the find()
* method should return 9 for each of the four elements in the connected components.
 */

public class UnionMax {

    private int[] sz;
    private int[] uf;
    private int count;
    private int[] max;

    public UnionMax(int n) {
        sz = new int[n];
        uf = new int[n];
        max = new int[n];

        count = n;

        for (int i = 0; i < n; i++) {
            sz[i] = 1;
            uf[i] = i;
            max[i] = i;
        }
    }

    public int count() {return count;}

    public int root(int p){
        while( p != uf[p]){
            p = uf[p];
        }
        return p;
    }

    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }

    public int find (int p) {
        return max[root(p)];
    }


    public void union (int p, int q) {
        if(connected(p, q))  return;

        int i = root(p);
        int j = root(q);
        if (sz[i] > sz[j]){
            sz[i]+=sz[j];
            uf[j] = i;
        } else {
            sz[q]+=sz[i];
            uf[i] = j;
        }

        if(max[i] < max[j])
            max[i] = max[j];
        else max[j] = max[i];

        if(max[i] < p) max[i] = p;
        if(max[i] < q) max[i] = q;
        if(max[j] < p) max[j] = p;
        if(max[j] < q) max[j] = q;

        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        System.out.println(n);
        UnionMax uf = new UnionMax(n);
        int i = StdIn.readInt();

     //   while (!StdIn.isEmpty()){
        for ( int j = 0; j < i; j++){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            StdOut.println("union " + p + " " + q);
        }

        int ans = uf.find(0);

        StdOut.println("resp " + ans);
    }
}
