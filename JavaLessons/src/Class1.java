/**
 * Created by NikolS on 3/29/2015.
 */
public class Class1 {
    public static void main(String [] args){
        System.out.println("HelloWorld");
        for (int i=0; i<10; i++) {
            Cat cat = new Cat();
        }
        System.out.println(Cat.catCount);
    }
}

    class Cat{
        static int catCount = 0;
        public Cat(){
            catCount++;
        }
        }