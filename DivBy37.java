package com.company;

public class DivBy37 {
    // Java program for checking
// divisibility by 37

        // function divisible37 which
// returns True if number is
// divisible by 37 otherwise False
        public static int divisibleby37(String n1)
        {
            int l = n1.length();
            if (n1 == "0")
                return 0;

            // Append required 0's
            // at the beginning
            if (l % 3 == 1)
            {
                n1 = "00"+ n1;
                l += 2;
            }
            else if (l % 3 == 2)
            {
                n1 = "0"+ n1;
                l += 1;
            }
            char[] n= n1.toCharArray();
            int gSum = 0;
            while (l != 0)
            {

                // group saves 3-digit group
                int gvalue;
                if(l == 2)
                    gvalue = ((int)n[(l - 2)] - 48) * 100 +
                            ((int)n[(l - 1)] - 48) * 10;
                else if(l == 1)
                    gvalue = ((int)n[(l - 1)] - 48) * 100;
                else
                    gvalue = ((int)n[(l - 3)] - 48) * 100 +
                            ((int)n[(l - 2)] - 48) * 10 +
                            ((int)n[(l - 1)] - 48) * 1;
                l = l - 3;

                // add the series
                gSum = gSum + gvalue;
            }

            // if sum of series gSum has minimum 4
            // digits in it, then again recursive
            // call divisibleby37 function
            if (gSum >= 1000)
                return (divisibleby37(String.valueOf(gSum)));
            else
                return (gSum % 23 == 0) ? 1 : 0;

        }

        // Driver Code
        public static void main(String[] args)
        {
            String s="1111111111111111111111";

            if (divisibleby37(s) == 1)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }

// This code is contributed by mits


