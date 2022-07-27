import java.util.*;

public class MapExample{


    public static void main(String[] args){

        /**                                                 Map
         *  Use it when:
         *              - If you want to search a data in a list it can be difficult for example for(int i....)if
         *                 equals(..) then break..
         *                 --> instead of that you can use it with more efficiency, if you liked to call the objects
         *                 by their names than use map
         *              - Medicine box example from SFJ: Like (key)Monday: (value)med1, Tuesday: med2, Wednesday: med3, ...etc
         *              - the key (id), doesn't need to be a String, like in sql, could be int too
         *    IMPORTANT - The Map.entry is the little box in the big box (Like: monday,tuesday,..)
         *   Properties:
         *                  - does not care about the order when we put or etc... but we can fix it with LinkedHashSet marker instead of HashMap at line 20
         *                  -
         * */
        // Now the key has String type and the values are Integers
        // Now here we add the Interface (Map) instead of HashMap, nah that's why:
        // The map contains also the HashMap and the LinkedHashMap, and maybe your colleagues will use HashMap.
        // With this smart move you aren't closing the door for the better development (like spread it, and the colleague can decide what he like'd to use)
        Map<String,Integer> testMap = new HashMap<>();

        testMap.put("Elso",21);
        testMap.put("Masodik",22);
        testMap.put("Harmadik",23);
        System.out.println(testMap);
        System.out.println(testMap.get("Masodik"));
        testMap.remove("Elso"); // return with value of the removed Object !
        System.out.println(testMap);

        // Iterating
        Iterator it = testMap.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry pair = (Map.Entry) it.next(); // pair because of it's store two elements. (key,value)
                    // we usually save it out to a variable (for sure we must to cast it)
                        String key = (String)pair.getKey();
                        Integer value = (Integer)pair.getValue();
                System.out.println(pair.getKey() + " + " + pair.getValue());
                    if(value.equals(21)) // !!! Not == operator
                        it.remove();
            }
    }
}
