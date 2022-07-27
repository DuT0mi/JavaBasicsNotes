import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Llist {

        // main
    public static void main(String[] args){
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Gyula");
        list1.add("Krisz");
            System.out.println(list1);
        // Iterator, works for arraylist as well for linkedlist
        Iterator<String> iterator = list1.iterator();
            while(iterator.hasNext()){
                String actual = iterator.next();
                if(actual.equals("Gyula"))
                    iterator.remove();
                System.out.println(iterator.next());
            }
    }
}
// Person.java from the previous commit
