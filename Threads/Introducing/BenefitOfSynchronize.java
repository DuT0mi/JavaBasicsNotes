
package book_modul3;

import java.lang.Thread;
import java.util.Set;

class Primes{
   // variable
   
   // function
    synchronized void printPrimes(int n){
    System.out.print("\n" + "smaller prime numbers than " + n  + " \n ");
        for(int i = 2; i < n; ++i){
            for(int j = 2; j < i; j++){
            if(i%j == 0)
                break;
            if(j == i-1){
                  System.out.print(i + ",");
                break;
            }
           }
        }
    }
}
 class Client extends Thread{
    // variable
     Primes prime;
     int n;
   // function
     Client(Primes pPrime, int pN){
         this.prime = pPrime;
         this.n = pN;
         start();
     }
     @Override
     public void run(){
         prime.printPrimes(n);
     }
 }
public class Book_Modul3 {
    // main thread control
    public static void main(String[] args) {
        int [] array = {50,100};
        Primes p = new Primes();
        for(int i = 0; i < array.length; i++){
            new Client(p,array[i]);
        }
    }
}
/*
  without synchronize
  Output:
  smaller prime numbers than 50 
      ?...??
  smaller prime numbers than 100 
     3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
*/
