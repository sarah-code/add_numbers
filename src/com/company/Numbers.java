package com.company;

import java.util.Scanner;

public class Numbers {
    private int number;
    Scanner scan = new Scanner(System.in);
    public void getNumber()
    {
        scan = new Scanner(System.in);
        System.out.print("Any letter key will abort this program) Please enter a number: ");
        int num = scan.nextInt();
        if (String.valueOf(num).matches("[a-zA-Z]+") == true)
        {
            System.exit(-1);
        }
        this.number = num;
        menu(number);
    }
    public void menu(int num)
    {
        System.out.println("Please select how to treat the number: \n (s) to summarize all digits. \n (p) to multiplicate all digits. \n any other key to abort.");
        String descision = scan.next();

        switch(descision)
        {
            case ("s"):
                sum(num); break;
            case("p"):
                product(num); break;
            default:
                System.exit(-1);
        }
    }
    public void sum(int num)
    {
        int length = (int)(Math.log10(num)+1);
        int  splitnum = num;
        int split = 0;
        int count = 0;
        for(int i = length ; i > 0; i--)
        {
            split = splitnum %10;
            System.out.print(split);


            splitnum = splitnum / 10;
            count = count + split;
            if (i > 1)
            {
                System.out.print(" + ");
            }
            else
            {
                System.out.println(" = " +count);
            }
        }

        System.out.println("The sum of the given int "+num+" is: "+ count );
        getNumber();
    }
    public void product(int num)
    {
        int length = (int)(Math.log10(num)+1);
        int  splitnum = num;
        int split = 0;
        int count =1;
        for(int i = length ; i > 0; i--)
        {
            split = splitnum %10;
            System.out.print(split);


            splitnum = splitnum / 10;
            count = count * split;
            if (i > 1)
            {
                System.out.print(" * ");
            }
            else
            {
                System.out.println(" = " +count);
            }
        }

        System.out.println("The product of the given int "+num+" is: "+ count );
        getNumber();
    }
}
