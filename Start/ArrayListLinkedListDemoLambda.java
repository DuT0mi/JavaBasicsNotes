import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Llist {

        // main
    public static void main(String[] args){
        // ArrayList vs Linkedlist
            // Arraylist
                // Gyorsabb keresés, lassabb hozzáadás/törlés,
                // indexelt, dinamikus
            // Linkedlist
                // Lassabb keresés, gyorsabb hozzáadás/törlés, több informűciót táról ( nyílván hisz hivatkozik élőre és hátra ( láncolástól függően..))
                // nem indexelt (innen következik a lassabb keresés), dinamikus
        LinkedList<String> LList = new LinkedList<String>();
            LList.add("Tomi");
            LList.add("Olivér");
            LList.add("Botond");
        ArrayList<String> AList = new ArrayList<>();
            AList.add("Zoli");
            AList.add("Pajkos szekreny");
            AList.add("Human mogyoro");
            // Printing functions
                // 0.
                    //for(int i = 0; i < AList.size();i++)
                    //        System.out.println(AList.get(i));
                // 1.
                    //for(String s:AList)
                    //        System.out.println(s);
                // 2.
                    // With Lambda, the brackets and the type(String) dont necessary
                    //AList.forEach((String s)->{System.out.println(s);});
                // 3.
                    // Bound form but works
                    // System.out.println(AList);
                    
            ArrayList<Person> people = new ArrayList<>();
            people.add(new Person(22,"aaaa"));
            people.add(new Person(18,"vvvv"));
                    Collections.sort(people);
                        //for(int i = 0; i < people.size();i++)
                        // System.out.println(people.get(i));
        // Or sort without Collections, new comparator in person.java
            //people.sort(Person.Namecomp);
            //for(int i = 0; i < people.size();i++)
             //System.out.println(people.get(i));
        // lambda
            people.sort((Person p1, Person p2)->    p1.getAge() - p2.getAge()); // The "Person" is necessary


    }
}
// Person.java
import java.util.Comparator;

public class Person implements Comparable {
    // implements comparable because we will need the sort

    // variables
        private int age;
        private  String name;
    // functions
        public Person(){}
        public Person(int pAge, String pName){this.age = pAge;this.name = pName;}
        public int getAge(){return age;}
        public String getName(){return name;}
        public void setAge(int pAge){this.age = pAge;}
        public void setName(String pName){this.name = pName;}
        @Override
        public int compareTo(Object t){
            int cAge = ((Person) t).getAge();
            return  (this.age - cAge); // ascending order, for descend cAge - this.age
        }
        public static Comparator<Person> Namecomp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                String o1name = o1.getName();
                String o2name = o2.getName();
                return o1name.compareTo(o2name);
            }
        };

}
