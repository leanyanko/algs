package a_friends;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
* Question 1
* Social network connectivity. Given a social network containing n members
* and a log file containing m timestamps at which times pairs of members
* formed friendships, design an algorithm to determine the earliest time
* at which all members are connected (i.e., every member is a friend of a
* friend of a friend ... of a friend). Assume that the log file is sorted
* by timestamp and that friendship is an equivalence relation. The running
* time of your algorithm should be mlogn or better and use extra space
* proportional to n.
 */

public class Friends {

    public static void main(String[] args) {

        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        String date, time;
        //timestamps are sorted ascending
        while (!StdIn.isEmpty()) {

            int p = StdIn.readInt();
            int q = StdIn.readInt();
            date = StdIn.readString();
            time = StdIn.readString();

            uf.union(p, q);

           // StdOut.println("All me");

            StdOut.println("[" + p + "," + q + "]");

            if (uf.count() == 1) {
                StdOut.println("All members were connected at: " + date + " " + time);
                break;
            }

        }
    }
}
