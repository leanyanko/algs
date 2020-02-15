package c_successor;

import static java.lang.Math.max;

public class Node {

    int i;
    int size;
    int max;
    Node root;

    Node(Node self, int i) {
        self.i = i;
        self.size = 1;
        self.max = i;
        self.root = self;
    }

    private Node root(Node node) {
        Node r = node;

        while (r.root != r) {
            r = r.root;
        }
   // #perform path compression
        while (node.root != node) {
            node = node.root;
            node.root =  r;
        }
        return r;
    }
//
//    private void  union(Node n1, Node n2) {
//        n1 = root(n1);
//        n2 = root(n2);
//        if (n1.size<n2.size)
//        n1, n2 = n2, n1
//        n2.root = n1
//        n1.size += n2.size
//        n1.max = max(n1.max, n2.max);
//    }
//
//    private Node Sfind(uf, i):
//            return root(uf[i]).max
//
//    def Sdelete(uf, i):
//    union(uf[i], uf[i+1])
//
//    N = 100
//    S = dict((i, Node(i)) for i in xrange(1, N))
//    Sdelete(S, 10)
//    Sdelete(S, 12)
//    Sdelete(S, 11)
//
//for i in [10, 12, 13, 20]:
//    print i, Sfind(S, i)
}
