package com.assign2Part2;

import java.util.Scanner;

/**
 *password and username can be anything it is to demonstrate that i have added a sign in module
 *
 */
public class App 
{
    public static void main( String[] args ) {

            Calculate cal= new Calculate();
            SignIn reg = new SignIn();
            Menu menu = new Menu();
            MathTools tool = new MathTools();
            int num,num2;
            int option;
            int calInput,toolInput;
            String username,password;
            Scanner input = new Scanner(System.in);

            System.out.println("Enter username:");
            username = input.next();
             System.out.println("Enter password:");
             password = input.next();



             menu.Display();
             System.out.println("Please enter 1-3 to perform math options:");
             option = input.nextInt();
             while(option<1 && option>3){
                 System.out.println("Invalid re-enter:");
                 option = input.nextInt();
             }
        while(option != 3) {
            if (option == 1) {
                menu.DisplayCalulate();
                System.out.println("Please enter a operation to perform:");
                calInput = input.nextInt();
                while (calInput < 1 && calInput > 6) {
                    System.out.println("Invalid re-enter:");
                    calInput = input.nextInt();
                }
                if (calInput == 1) {
                    System.out.println("Enter number:");
                    num = input.nextInt();
                    System.out.println("Enter number:");
                    num2 = input.nextInt();

                    System.out.println("Answer" + cal.addInt(num, num2));
                } else if (calInput == 2) {
                    System.out.println("Enter number:");
                    num = input.nextInt();
                    System.out.println("Enter number:");
                    num2 = input.nextInt();

                    System.out.println("Answer" + cal.subtractInt(num, num2));
                } else if (calInput == 3) {
                    System.out.println("Enter number:");
                    num = input.nextInt();
                    System.out.println("Enter number:");
                    num2 = input.nextInt();

                    System.out.println("Answer" + cal.multiplyInt(num, num2));
                }
                else
                    if (calInput == 4) {
                        System.out.println("Enter number:");
                        num = input.nextInt();
                        System.out.println("Enter number:");
                        num2 = input.nextInt();
                        while(num2==0){
                            System.out.println("Cannot divide by 0 re-enter:");
                            num2 = input.nextInt();
                        }

                    System.out.println("Answer" + cal.divideInt(num, num2));
                } else
                    if(calInput == 5) {
                        menu.Display();
                    }

            }

            else
                if(option == 2){
                    menu.DisplayMathTools();
                    System.out.println("please enter one of the operations");
                    toolInput = input.nextInt();
                    if(toolInput == 1){
                        System.out.println("Enter number:");
                        num = input.nextInt();
                        System.out.println("Enter number:");
                        num2 = input.nextInt();
                        System.out.println("The smallest number is:" + tool.smallerInt(num,num2));

                    }
                    else
                        if(toolInput ==2){
                            System.out.println("Enter number:");
                            num = input.nextInt();
                            System.out.println("Enter number:");
                            num2 = input.nextInt();
                            System.out.println("The smallest number is:" + tool.biggerInt(num,num2));
                        }
                    else
                            if(toolInput == 3){
                                menu.Display();
                            }
                }
            menu.Display();
            System.out.println("Enter an operation to perform:");
            option = input.nextInt();
        }//end while






    }
}
