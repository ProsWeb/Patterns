//        Complete the given Singleton class. It should contain the following parts:
//        a private no-argument constructor;
//        a public static method getInstance without arguments, it returns the same instance of the class.
//        You will not read input or print output in this problem.
//
//        If your solution is wrong, you will get a compile-time error or a runtime exception.

package patterns.singleton;

class Singleton {

    private static Singleton instance;

    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
