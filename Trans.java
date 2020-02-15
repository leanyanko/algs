package com.company;

import java.util.Arrays;

public class Trans {
    public static int[] bankRequests(int[] accounts, String[] requests) {
        int ac_size = accounts.length;
     //   System.out.println("numbers: " + ac_size);

        for (int k = 0; k < requests.length; k++) {
            if (accounts[0] < 0) return accounts;
            String[] request = requests[k].split(" ");
            String transaction = request[0];

            int[] id = new int[] {-3};
            if (request.equals("transfer")) id = new int[] {-1};
            else if (request.equals("deposit")) id = new int[] {-2};

            System.out.println(transaction);

            int i = Integer.parseInt(request[1]) - 1;
            int j = -1;
            if (request.length == 4) {
                j = Integer.parseInt(request[2]) - 1;
                if (j >= ac_size || j < 0){

                    System.out.println("Transaction denied: incorrect account number: j = " + j );
                    return id;
                }
            }
            int sum = Integer.parseInt(request[request.length - 1]);

            if (i >= ac_size || i < 0 ){
                System.out.println("Transaction denied: incorrect account number: i = " + i );
                return id;
            }
            else {
//                switch (transaction) {
//                    case "transfer":
//                        accounts = transfer(i, j, sum, accounts);
//                        break;
//                    case "deposit":
//                        accounts = deposit(i, sum, accounts);
//                        break;
//                    case "withdraw":
//                        accounts = withdraw(i, sum, accounts);
//                        break;
//                    // default: System.out.println("Transaction denied: incorrect transaction");
//                    //          break;
//                }
                if (transaction.equals("withdraw")) accounts = withdraw(i, sum, accounts);
                else if (transaction.equals("deposit")) accounts = deposit(i, sum, accounts);
                else accounts = transfer(i, j, sum, accounts);
            }
            System.out.println(Arrays.toString(accounts));
        }
        return accounts;
    }


    public static int[] transfer(int i, int j, int sum, int[] accounts) {
        if (sum > accounts[i]) {
            System.out.println("Transaction denied: insufficient amount");
           // return accounts;
            return new int[]{-1};
        }
        accounts[i] = accounts[i] - sum;
        accounts[j] = accounts[j] + sum;
        return accounts;
    }

    public static int[] deposit(int i, int sum, int[] accounts) {
        accounts[i] += sum;
        return accounts;
    }

    public static int[] withdraw (int i, int sum, int[] accounts) {
        if (sum > accounts[i]) {
            System.out.println("Transaction denied: insufficient amount");
            //return accounts;
            return new int[]{-3};
        }
        accounts[i] -=sum;
        return accounts;
    }

    public static void main(String[] args) {
//        String[] requests = {
//                "withdraw 2 10", //: [10, 90, 20, 50, 30];
//        "transfer 5 1 20", //: [30, 90, 20, 50, 10];
//        "deposit 5 20", //: [30, 90, 20, 50, 30];
//        "transfer 3 4 15" //[30, 90, 5, 65, 30]
//        };

        //int[] accounts = {10, 100, 20, 50, 30};

//        int [] accounts = {20, 1000, 500, 40, 90};
//        String [] requests = {"deposit 3 400",
//                "transfer 1 2 30",
//                "withdraw 4 50"};
//        System.out.println(Arrays.toString(accounts));

        int [] accounts = {20, 1000, 500, 40, 90};
        String[] requests = {"deposit 3 400",
                "transfer 1 2 30",
                "withdraw 4 50"};

   //     for (int i = 0; i< requests.length; i++) {
   //         System.out.println(requests[i]);
            System.out.println(Arrays.toString(bankRequests(accounts, requests)));
   //     }
    }
}
