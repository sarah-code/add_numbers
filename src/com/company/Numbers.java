package com.company;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Numbers {
    private int number;
    private String splitnum;
    private String split [];
    private int count;

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
        System.out.println("Please select how to treat the number: \n (s) to summarize all digits. \n (p) to multiplicate all digits. \n any other key to exit the program.");
        String descision = scan.next();

        switch(descision)
        {
            case ("s"):
                sum(num); break;
            case("p"):
            product(num); break;
//            case("m"):
//                minus(num); break;
            default:
                System.out.println("Exiting programme now. / Termination du logiciel maintement.");
                System.exit(-1);
        }
    }
    public void sum(int num)
    {
        int length = returnLength(num);
        if(length  !=1) {
            int numberInt = 0;
            String temp[] = splitNumber(num);
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i]);
                if (i != temp.length - 1) {
                    System.out.print(" + ");
                } else {
                    System.out.print(" = ");
                }
                numberInt = numberInt + Integer.parseInt(temp[i]);
            }
            System.out.println(numberInt);

            System.out.println("The sum of the given int " + num + " is: " + numberInt);
            sum(numberInt);
        }
        getNumber();
    }
   public void product(int num)
    {
        int length = returnLength(num);
        if (length > 1 || num == 0 || length != 1){
            int numberInt = 1;
            String temp[] = splitNumber(num);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != null) {
                    System.out.print(temp[i]);
                    if (i != temp.length - 1) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" = ");
                    }
                    //                try {
                    numberInt = numberInt * Integer.parseInt(temp[i]);
                    //                }
                    //                catch(Exception e)
                    //                {
                    //                    getNumber();
                    //                }
                }
            }
            System.out.println(numberInt);

            System.out.println("The product of the given int " + num + " is: " + numberInt);
            product(numberInt);
        }else {
            getNumber();
        }
    }
//    public void minus(int num)
//    {
//        int length =  returnLength(num);
//        while (length > 0)
//        {
//            splitnum = num;
//
//            for(int i = length ; i > 0; i--)
//            {
//                split = splitnum %10;
//                System.out.print(split);
//
//
//                splitnum = splitnum / 10;
//                count = count - split;
//                if (i > 1)
//                {
//                    System.out.print(" - ");
//                }
//                else
//                {
//                    System.out.println(" = " +count);
//                }
//
//            }
//
//            System.out.println("The sum of the given int "+num+" is: "+ count );
//
//
//            if (returnLength(count) == 1 || count > -100)
//            {
//                getNumber();
//            }
//            sum(count);
//        }
//    }
//
    public int returnLength(int num)
    {
        int len = (int)(Math.log10(num)+1);

        return len;
    }

    public String[] splitNumber(int number)
    {
        int length =  returnLength(number);

        splitnum = Integer.toString(number);
        split=new String [splitnum.length()];

        for(int i = 0 ; i < length + 1; i++)
        {
            split = splitnum.split("", i);
        }
        return split;
    }
}
