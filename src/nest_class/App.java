package nest_class;

public class App {

    public static void main(String[] args) {

        // Static public nested class can be created without instance of enclosing class
        EnclosingClass.StaticPublicNestClass static_pub_nest = new EnclosingClass.StaticPublicNestClass();
        static_pub_nest.func();

        // The type EnclosingClass.StaticPrivateNestClass is not visibleJava(16777219)
        // Nested class visibility is managed by enclosing class. Nested class is a
        // memeber of enclosing class
        // EnclosingClass.StaticPrivateNestClass static_pri_nest = new
        // EnclosingClass.StaticPrivateNestClass();

        // Non static public nested classes can ONLY be created based on instance of
        // enclosing class
        EnclosingClass.PublicNestClass pub_nest = new EnclosingClass().new PublicNestClass();
        pub_nest.func();

        // The type EnclosingClass.PrivateNestClass is not visibleJava(16777219)
        // ested class visibility is managed by enclosing class. Nested class is a
        // memeber of enclosing class
        // EnclosingClass.PrivateNestClass pri_nest = new EnclosingClass().new
        // PrivateNestClass();

    }
}

class EnclosingClass {

    private static String str = "Static string";
    private String normal_str = "Normal string";

    static public class StaticPublicNestClass {

        public void func() {
            // can access private memembers of EnclosingClass
            System.out.println(str);
            /*
             * Cannot make a static reference to the non-static field
             * normal_strJava(33554506)
             */
            // System.out.println(normal_str);
        }

        public static void main(String[] args) {
            StaticPublicNestClass ins = new StaticPublicNestClass();
            ins.func();
        }

    }

    // Since this class is private, it can only be instantiated inside
    // EnclosingClass
    static private class StaticPrivateNestClass {

        public void func() {
            System.out.println(str);
            // System.out.println(normal_str);
        }

        public static void main(String[] args) {
            StaticPrivateNestClass ins = new StaticPrivateNestClass();
            ins.func();

        }

    }

    public class PublicNestClass {
        public void func() {

            System.out.println(str);
            // OK, non-static inner class always hold reference to instance of parent class
            System.out.println(normal_str);
        }

        public static void main(String[] args) {
            // No enclosing instance of type EnclosingClass is accessible. Must qualify the
            // allocation with an enclosing instance of type EnclosingClass (e.g. x.new A()
            // where x is an instance of EnclosingClass).Java(16777237)
            // PublicNestClass ins = new PublicNestClass();

            // OK! Must create outer class, then create inner class
            PublicNestClass ins = new EnclosingClass().new PublicNestClass();
            ins.func();
        }
    }

    // Since this class is private, it can only be instantiated inside
    // EnclosingClass
    private class PrivateNestClass {

        public void func() {
            System.out.println(str);
            System.out.println(normal_str);
        }

        public static void main(String[] args) {
            PrivateNestClass ins = new EnclosingClass().new PrivateNestClass();
            ins.func();
        }

    }

    public static void main(String[] args) {
        StaticPrivateNestClass static_pri_nest = new StaticPrivateNestClass();
        static_pri_nest.func();
        StaticPrivateNestClass.main(args);

        PrivateNestClass pri_nest = new EnclosingClass().new PrivateNestClass();
        pri_nest.func();
        PrivateNestClass.main(args);
    }
}