package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Numbers {
    private int number;
    Scanner scan = new Scanner(System.in);
    public void getNumber()
    {
        int num = 0;
        try {
            scan = new Scanner(System.in);
            System.out.print("(Any letter key will abort this program) Please enter a number: ");
            num = scan.nextInt();
        }
        catch(InputMismatchException exception)
        {
            System.err.println(exception +" encountered.");
            System.out.println("Exiting programme now. / Termination du logiciel maintement.");
            System.exit(-1);
        }
        this.number = num;

        menu(number);
    }
    public void menu(int num)
    {
        System.out.println("Please select how to treat the number: \n (s) to summarize all digits. \n (p) to multiplicate all digits. \n (m) minus all digits. \n (d) divide all digits. \n any other key to exit the program.");
        String descision = scan.next();

        switch(descision)
        {
            case ("s"):
                sum(num); break;
            case("p"):
            product(num); break;
            case("m"):
                minus(num); break;
            case("d"):
                division(num); break;
            default:
                System.out.println("Exiting programme now. / Termination du logiciel maintement.");
                System.exit(-1);
        }
    }
    public void sum(int num)
    {
        int length =  returnLength(num);
        while (length > 0)
        {
            int splitnum = num;
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


            if (returnLength(count) == 1)
            {
                getNumber();
            }
            sum(count);
        }
    }

    public void minus(int num)
    {
        int length =  returnLength(num);
        while (length > 0)
        {
            int splitnum = num;
            int split = 0;
            int count = 0;
            for(int i = length ; i > 0; i--)
            {
                split = splitnum %10;
                System.out.print(split);


                splitnum = splitnum / 10;
                count = count - split;
                if (i > 1)
                {
                    System.out.print(" - ");
                }
                else
                {
                    System.out.println(" = " +count);
                }
            }

            System.out.println("The sum of the given int "+num+" is: "+ count );


            if (returnLength(count) == 1 || count <0)
            {
                getNumber();
            }
            minus(count);
        }
    }
    public void division(int num)
    {
        int length =  returnLength(num);
        while (length > 0)
        {

            int  splitnum = num;
            int split = 0;
            int count =1;
            for(int i = length ; i > 0; i--)
            {
                split = splitnum %10;
                System.out.print(split);


                splitnum = splitnum / 10;
                count = count / split;
                if (i > 1)
                {
                    System.out.print(" / ");
                }
                else
                {
                    System.out.println(" = " +count);
                }
            }

            System.out.println("The product of the given int "+num+" is: "+ count );


            if (returnLength(count) == 1 || count == 0)
            {
                getNumber();
            }
            division(count);
        }
    }



    public void product(int num)
    {
        int length =  returnLength(num);
        while (length > 0)
        {

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


            if (returnLength(count) == 1 || count == 0)
            {
                getNumber();
            }
            product(count);
        }
    }
    public int returnLength(int num)
    {
        int len = (int)(Math.log10(num)+1);
        return len;
    }
}
