package com.mycompany.book_modul2;
 import java.util.Scanner;

public class Book_Modul2 {
    static int[][] MatrixMultipli(int[][] matrixA, int[][] MatrixB){  
        int n = matrixA.length;         // | 1 2 |
        int row = matrixA[0].length;    // | 3 4 |
        int [][] res = new int [n][n];
        for(int i = 0; i < n; ++i ){
            for(int j = 0; j < row; ++j){
                for(int k = 0; k < n ; ++k){
                    res[i][j] += matrixA[i][k] * MatrixB[k][j];
                }
            }
                
        }
        return res;
    }
    static void printMatrix(int[][] Matrix){
        int n = Matrix.length;         // | 1 2 |
        int row = Matrix[0].length;
            for(int i = 0; i < n ; ++i){
                for(int j = 0; j < row; ++j){
                    System.out.print(Matrix[i][j] + " ");
                }
                System.out.println();
            }
                 
    }
    static void binary(int n){
        if(n > 1)
            binary(n >> 1);
        System.out.printf("%d", n & 1);
    // 25 = 00011001
    //      00001100 = 12
    //      00000110 = 6
    //      00000011 = 3
    //      00000001 = 1
    }
    public static void main(String[] args) {
            //        int [] tomb = new int[10];
            //        int [][] twoD = new int[10][10];
            //        int size = twoD.length;           // 1. dimenzió nagyságához
            //        int row_length = twoD[0].length; // 2. dimenzó nagyságához
            //        int i = 1;
            //        int j = ++i;
            //        int k = i++;
            //        System.out.printf("%d %d ",j,k);
            //            int a = 10;
            //            float b = 1.0f;
            // instanceof -> objektumokra
            //            int j = 10;
            //            int i = j < 0? 5: 10;
            //            int [][] matrix_one = {
            //                                    {1,2},
            //                                    {3,4}
            //                                   };    
            //            int [][] matrix_two = {
            //                                    {1,2},
            //                                    {3,4}
            //                                   };
            //            int [][] matrix_res = MatrixMultipli(matrix_one,matrix_two);
            //            printMatrix(matrix_res);
            //            Scanner in = new Scanner(System.in);
            //            int number = in.nextInt();
            //            // 10 = 00001010
            //            //>>1 = 00000101 = 5
            //            //<<1 = 00010100 = 20
            //            int number_modified = number << 1;
            //            //            System.out.println("Before shifting >>1 : " + number);
            //            //            System.out.println("After shifting >>1 : " + number_modified);
            //            
            Scanner input = new Scanner(System.in);
            System.out.println("Pls give an integer: ");
            int in = input.nextInt();
            binary(in);
            
    }
}
