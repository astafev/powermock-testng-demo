package demo.powermockito.testng;

public class ClassA {
    public static String getA() {
        return "A";
    }

    public static void doWith4() {
        if(ClassB.get4()!=4) {
            throw new IllegalStateException();
        }
    }
}
