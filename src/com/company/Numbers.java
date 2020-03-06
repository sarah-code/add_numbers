package com.company;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Numbers  {
    private int number;
    private String splitnum;
    private String split;
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
        System.out.println("Please select how to treat the number: \n (s) to summarize all digits. \n (p) to multiplicate all digits. \n (m) to subtract all digits. \n any other key to exit the program.");
        String descision = scan.next();

        switch(descision)
        {
//            case ("s"):
//                sum(num); break;
//            case("p"):
//            product(num); break;
            case("m"):
                minus(num); break;
            default:
                System.out.println("Exiting programme now. / Termination du logiciel maintement.");
                System.exit(-1);
        }
    }
//    public void sum(int num)
//    {
//
//        int length = returnLength(num);
//        if(length  !=1) {
//            int numberInt = 0;
//            String temp[] = splitNumber(num);
//            for (int i = 0; i < temp.length; i++) {
//                System.out.print(temp[i]);
//                if (i != temp.length - 1) {
//                    System.out.print(" + ");
//                } else {
//                    System.out.print(" = ");
//                }
//                numberInt = numberInt + Integer.parseInt(temp[i]);
//            }
//            System.out.println(numberInt);
//
//            System.out.println("The sum of the given int " + num + " is: " + numberInt);
//            sum(numberInt);
//        }
//        getNumber();
//    }
//   public void product(int num)
//    {
//        String temp[] = splitNumber(num);
//        System.out.println(splitnum);
//        int length = returnLength(num);
//        if (length  !=1 || splitnum != null || splitnum != "0") {
//            try {
//                int numberInt = 1;
//                for (int i = 0; i < temp.length; i++) {
//
//                    System.out.print(temp[i]);
//                    if (i != temp.length - 1) {
//                        System.out.print(" * ");
//                    } else {
//                        System.out.print(" = ");
//                    }
//                    //                try {
//                    numberInt = numberInt * Integer.parseInt(temp[i]);
//                    //                }
//                    //                catch(Exception e)
//                    //                {
//                    //                    getNumber();
//                    //                }
//                }
//
//                System.out.println(numberInt);
//
//                System.out.println("The product of the given int " + num + " is: " + numberInt);
//                product(numberInt);
//            } catch (Exception e) {
//                getNumber();
//
//            }
//            getNumber();
//        }
//    }
    public void minus(int num)
    {
        int numberInt =0;
        int length = returnLength(num);
        int startIndex = 0;
        String temp = null;
        if(length  <= 1 || num != -100 ) { //|| num != -100

            if (num > 0)
            {
                temp = String.valueOf(num);
                numberInt = Integer.parseInt(String.valueOf(temp.charAt(0)));
                length--;
                temp = temp.substring(1,temp.length());
            }
            else if (num < 0)
            {
                temp = String.valueOf(Math.abs(num));
                startIndex = 2;
                int tempvar = Integer.parseInt(temp.substring(0,1));
                System.out.println("Tempvar:"+tempvar);
                numberInt = tempvar;
            }
            System.out.println("Length:"+length+"Temp:"+temp.length());
            for (int i = startIndex; i < length; i++) {
                System.out.print(temp.substring(i, i+1));

                if (i != temp.length() - 1) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" = ");
                }
                int parsedVal = Integer.parseInt(temp.substring(i, i+1)); //is good
                System.out.println("Calc:"+ numberInt+"-"+parsedVal+"="+(numberInt-parsedVal));
                numberInt = numberInt - parsedVal;
            }
            System.out.println("Result: "+ numberInt);

            System.out.println("The sum of the given int " + num + " is: " + numberInt);
            minus(numberInt);
        }

        getNumber();
    }

    public int returnLength(int num)
    {
//        int len = (int)(Math.log10(num)+1);
        return (""+Math.abs(num)).length();
    }

    public String splitNumber(int number) {
        int length = returnLength(number);

        split = String.valueOf(number);

//        for (int i = 0; i < length + 1; i++) {
//            split = splitnum.split("\\D", i);
//        }


        return split;
    }
}
