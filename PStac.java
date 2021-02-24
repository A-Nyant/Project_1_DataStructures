package Project_1;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class PStac 
{
     //This is the stack
     static int carrary [] = new int [4]; 

     //This is the stack pointer
     static int SP=0;

     //This is scanner that will look for input from users
     static Scanner scan = new Scanner (System.in);
     //This is the message code for picking the text
     static String choicemess = " Please make a choice by selecting a number and typing it into the console\n" +  
                                "Select 1 for Test A \n"+ 
                                "Select 2 for Test B \n" +
                                "Select 3 for Test C";

    public static void main(String[] args) {
        //The message about picking a choice is printed and it will get the user's choice
        System.out.println (choicemess);
        int choice = scan.nextInt();

        //Based on the choice of the user, it will display the test.
        if (choice == 1)
            TestA(carrary);
        else if (choice ==2)
            TestB (carrary);
        else 
            TestC(carrary);
    }
    
    //This is the method for doing test a, true is pushing and false is pop.
    public static void TestA (int [] a){
        status(a);
        checking(12, a, true);
        checking(34, a, true);
        checking(56, a, true);
        status(a);
        checking(0, a, false);
        status(a);
        checking(0, a, false);
        status(a);
        checking(0, a, false);
        status(a);
        checking(0, a, false);
        status(a);
    }

    //This is used to test whether it is a pop or push. Based that, it will check
    //if the sp is less than 0 (pop) or more than 3 (push) and it will display an error message
    public static int checking (int num, int []a, Boolean pushed)
    {
        //if the number is pushed
        if (pushed)
        {
            //If the stack pointer is less than 3
            if (SP <= 3)
            {
                //It will push the number into the stack
                push(num, a, SP);
                //it will increase the stack
                SP++;
            }

            //else, an error message will display.
            else 
            {
                String ErrorMese = "Overflow, Process will end";
                String Title = "Overflow";
                JOptionPane.showMessageDialog(null, ErrorMese, "InfoBox: " + Title, JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Status: OverFlow. The Stack Pointer is at " + (SP-1));
            }
        }

        //if there is a pop, then
        else
        {
            //If the stack pointer is more than 1
            if (SP >= 1)
            {
                //the stack pointer increases
                SP--;
                //The number is popped off the stack
                pop(SP, a);
            }

            //else, an error message will display
            else
            {
                String ErrorMese = "Underflow, Process will end";
                String Title = "Underflow";
                JOptionPane.showMessageDialog(null, ErrorMese, "InfoBox: " + Title, JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Status: UnderFlow, The Stack Pointer is at " + (SP+1));
            }
        }

        //It returns the stackpointer
        return SP;
    }

    //This is the routine for test b
    public static void TestB (int []a)
    {
        status(a);
        checking (0, a, false);
        status(a);
    }

    //This is the routine for test c
    public static void TestC (int []a)
    {
        status(a);
        checking(12, a, true);
        checking(34, a, true);
        checking(56, a, true);
        checking(78, a, true);
        status(a);
        checking(90, a, true);
        status(a);
    }

    //this is the routine for pushing numbers into the stack
    public static int [] push(int ch, int [] a, int Point)
    {
        a [Point] = ch;
        return a;
    }

    //this is the routine for popping a number from the stakc
    public static int [] pop (int Point, int [] a)
    {
        a [Point] = 0;
        return a;
    }

    public static void status(int[] a) {        
        System.out.print("Status: {" + a[0]);        
        for (int i = 1; i < a.length; i++) {            
            System.out.print(", " + a[i]);        
        }        
        System.out.println("}");    
    }
}
