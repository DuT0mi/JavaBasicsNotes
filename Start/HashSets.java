import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class HashSet {



        public static void main(String[] args){

            /**             HashSets
             * There can't be duplicated data in a Hashset
             * Doesn't care the order, just the data (if we are talking about the HashSet, the LinkedHashSet cares)
             * */
            String[] array = {"AA","BB","CC","AA"};
            List<String> list1 = Arrays.asList(array);
            System.out.println("List: " + list1);
            // List to Set
            Set<String> set = new java.util.HashSet<>(list1);
            System.out.println("Set: " + set);
                // Trying to add an existing data -> will not give error, it isn't going to be added to it
            set.add("BB");
            System.out.println("Modified set: " + set);
            
            
            // If we want to keep the order then we must use LinkedHashSet
            // just modify the HashSet to LinkedHashSet, btw it is also has the same properties as the HashSet
        }
}
