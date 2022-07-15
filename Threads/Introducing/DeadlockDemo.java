
package DeadLock;

import java.lang.Thread;
import java.util.Set;


    class A{
    // variables
       
    // functions
         synchronized void foo(B b){
             String name = Thread.currentThread().getName();
             System.out.println(name + " joined to A.foo method");
             try{
             Thread.sleep(1000);
             }
             catch(Exception e){
                 System.out.println("Cancelled: " + name);
             }
             System.out.println(name + " wants to call the B.last()");
             b.last();
        }
         synchronized void last(){
         System.out.println("A.last() method");
         }
    }
 class B{
    // variables
       
    // functions
         synchronized void bar(A a){
             String name = Thread.currentThread().getName();
             System.out.println(name + " joined to B.bar method");
             try{
             Thread.sleep(1000);
             }
             catch(Exception e){
                 System.out.println("Cancelled: " + name);
             }
             System.out.println(name + " wants to call the B.last()");
             a.last();
        }
         synchronized void last(){
         System.out.println("B.last() method");
         }
    }
class Deadlock implements Runnable{
    // variables
    A a = new A();
    B b = new B();
    // functions
    Deadlock(){
        Thread.currentThread().setName("Main thread");
        Thread t = new Thread(this,"Competitionist thread");
        t.start();
        a.foo(b);   // lock "a' on that thread
        System.out.println("Back to the main thread");
    }
    public void run(){
    b.bar(a); // lock "b" on that thread
    System.out.println("Back to the other thread");
    }
}

 class DeadLock{
    
    
   public static void main(String[] args) {
            
    new Deadlock();
    }
}
