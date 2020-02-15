package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Roles {
    public static double probability (int numRoles, double[] probs ) {
        Arrays.sort(probs);
        double[] p = new double[numRoles];
        double pb = 1;
        for (int i = 0; i < numRoles; i++) {
            p[i] = 1 - probs[i] * probs[probs.length - i - 1];
            pb *= p[i];
        }
        return pb;

    }

    public static void main(String [] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numCases = in.nextInt();
        for (int a = 0; a < numCases; a++) {
            int numRoles = in.nextInt();
            double[] probs = new double[numRoles * 2];
            for (int i = 0; i < numRoles * 2; i++) {
                probs[i] = in.nextDouble();
            }

            System.out.println(probability(numRoles, probs));
        }
    }
}
