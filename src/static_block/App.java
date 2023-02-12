package static_block;

public class App {

    public static void main(String[] args) {

        // Note: when calling static function, a instance of AnotherClass will be
        // instantiated, which leands to the calling of static block to instantiate
        // static variables of Another class
        AnotherClass.func();

        // Following code will not call static block again, because the static variables
        // are instantiated only once.
        AnotherClass ins = new AnotherClass();
        ins.gunc();
    }

}

class SomeClass {
    public String[] names;
    public int[] age;
}

class AnotherClass {
    private static SomeClass some;

    // initialzie static variables
    static {
        some = new SomeClass();
        some.names = new String[] { "Shanghai", "Beijing" };
        some.age = new int[] { 1, 2, 3 };
        for (String item : some.names) {
            System.out.println(item);
        }
        for (int item : some.age) {
            System.out.println(item);
        }
    }

    static void func() {
        System.out.println("Hello world");
    }

    void gunc() {
        System.out.println("Hello Shanghai");
    }
}
