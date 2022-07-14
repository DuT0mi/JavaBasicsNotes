// Packages
package com.mycompany.basics;
 import java.util.Scanner;
 import java.util.Random;


public class Basics {
    static boolean isBigger(int given, int param){
        return given>param;        
    }
    static void Fibonacci(int param){
    /*
        Example: 0 1 1 2 3 5 8 11 19 ... param
    */
     int firstTerm = 0,i;
     int secondTerm = 1;
     int nextTerm = firstTerm + secondTerm;
     System.out.printf("%d %d %d ", firstTerm,secondTerm,nextTerm);
     for(i = 3; i < param; ++i){
         firstTerm = secondTerm;
         secondTerm = nextTerm;
         nextTerm = firstTerm + secondTerm;
         if(isBigger(nextTerm,param))
               break;
         System.out.printf("%d ",nextTerm);
     }     
    }
    static boolean isPrime(int given){
    boolean check = true;
    for(int i = 2; i < given ; ++i)
           if(given%i == 0)
               check = false;
    return check;
    }
    static void bubbleSort(int array[]){
    int length = array.length;
        for(int i = 0; i < length - 1; ++i)
             for(int j = 0; j < length - i - 1; ++j)
                 if(array[j]>array[j+1])
                 {
                     int temp = array[j];
                     array[j] = array[j+1];
                     array[j+1] = temp;
                 }
    }
    static void printArray(int array[]){
     int length = array.length;
        for(int i = 0; i < length; ++i)
               System.out.print(array[i] + " ");
    }
    public static void main(String[] args) {
        // Learning the basics
        // I/O
            //            System.out.println("Give a number: ");
            //            Scanner in = new Scanner(System.in);
            //
            //            int number = in.nextInt();
            //            System.out.println("Your choosen number is: " + number);
         Doboz doboz = new Doboz(); 
        //        System.out.println("Give a number: ");
        //        Scanner in = new Scanner(System.in);
        //        int limit = in.nextInt();
        //        Fibonacci(limit);
        //        int[] RandArray = new int[10];
        //        java.util.Random myRandom = new Random();
        //        for(int i = 0; i < 10; ++i)
        //            RandArray[i] = myRandom.nextInt() * 10; // between 0 - 100
        //        printArray(RandArray);
        //            System.out.println();
        //        bubbleSort(RandArray);
        //            System.out.println();
        //        printArray(RandArray);
        //        doboz.height = 10;
        //        doboz.lenght = 10;
        //        doboz.weight = 10;
        //int volume = (int)doboz.volume();
        // doboz.printVolume();
        //        System.out.println("Give the radius: ");
        //        Scanner in = new Scanner(System.in);
        //            double radius = in.nextDouble();
        //        Circle circle = new Circle();
        //        circle.SetRadius(radius);
        //        circle.getAllDataFromCircle();
        
    }
}
