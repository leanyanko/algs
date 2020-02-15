package com.company;

import java.io.*;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args) {
        String file = "src/com/company/temp";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currLine = reader.readLine();
          //  System.out.println(currLine);
            Scanner scanner = new Scanner(new File(file));
            while(scanner.hasNext()) {
                String s = scanner.nextLine();
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println(e);
        }


    }
}
