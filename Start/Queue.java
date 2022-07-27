import java.util.PriorityQueue;
import java.util.Queue;

public class queues {



    public static void main(String[] args){
        /**     Queues and Priority queues
         * Queue : FIFO
         * Priority Queue: nonlinear, take cares of only the PRIORITY member                             - faster
         * If we want to save all of the priorities/order than Queue<String> qu = new LinkedList<>(); - slower
         * */

        Queue<String> qu = new PriorityQueue<>();
            qu.offer("Elso Cekla");
                System.out.println(qu);
            qu.offer("Masodik Gino");
                System.out.println(qu);
            qu.offer("Harmadik Hegedu");
                System.out.println(qu);
            
        // System.out.println(qu.peek()); -> "Elso Cekla"
            // qu.poll() -> removes the biggest priority member and the second is going to be the peek

    }
}
