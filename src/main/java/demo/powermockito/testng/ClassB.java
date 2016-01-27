package demo.powermockito.testng;

public class ClassB {
    public static int get4() {
        return 4;
    }

    public static void doWithA() {
        if(!"A".equals(ClassA.getA())) {
            throw new IllegalStateException();
        }
    }
}
