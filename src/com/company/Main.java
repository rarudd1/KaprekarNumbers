package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    static void kaprekarNumbers(int p, int q) {

        boolean found = false;
        for(int i = p; i<=q; i++)
        {
            long x = i;
            BigInteger square = new BigInteger("1");
            square=BigInteger.valueOf(x*x); //square the initial value
            String squared = square.toString(); //Change the number to a string find half of it's length

            int d = squared.length()/2;
            if(i==1)
            {
                System.out.print(i+" ");
                found = true;
                continue;
            }
            if(d !=0)
            {
                //Determine the number in each half of the larger number and add them
                int first = Integer.parseInt(squared.substring(0,d));
                int second = Integer.parseInt(squared.substring(d,squared.length()));
                if(i == first+second) //If they add to the original number print the original number a s a kaprekar
                {
                    found = true;
                    System.out.print(i+" ");
                }

            }
        }
        if(!found) //if no kaprekar numbers are found print invalid range
            System.out.println("INVALID RANGE");

    }
    public static void main(String[] args) throws IOException {


        try (Scanner scanner = new Scanner(new FileReader("tests.txt"))) {


            int lowerBound = scanner.nextInt();
            int upperBound = scanner.nextInt();

            kaprekarNumbers(lowerBound, upperBound);

        }
    }
}
