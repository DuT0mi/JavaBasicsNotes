

   public class Apple {
       public interface  Watcher{
           public void watching();
       }
       public void doSMTH(Watcher pWatcher){
           pWatcher.watching();
       }
       public static void main(String[] args){
        Dog dog = new Dog();
        Apple apfel = new Apple();
        apfel.doSMTH(dog);
        // Introduce the lambda function
           // Instead of making an object which is implements the Watcher (like Butterfly) and then overwrite the watching()
           // functions, make it with lambda expression
           Watcher watching = () -> {
             System.out.println("I see you!");
           }; // Also good without brackets, {}
           apfel.doSMTH(watching);
       }
}
// Dog class in Dog.java
//public class Dog implements Medior.Watcher{
//        @Override
//        public void watching(){
//            System.out.println("Im a dog but i see you");
//        }
//    }
