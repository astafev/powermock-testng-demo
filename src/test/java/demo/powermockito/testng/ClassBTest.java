package demo.powermockito.testng;

import org.powermock.core.classloader.MockClassLoader;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.testng.Assert.assertEquals;

@PrepareForTest(ClassA.class)
public class ClassBTest extends PowerMockTestCase{
    @Test
    public void test4() {
        assertEquals(ClassB.get4(), 4);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public  void testExcOnDoWithA() {
        mockStatic(ClassA.class);
        when(ClassA.getA()).thenReturn("B");

        System.out.println(Whitebox.getInternalState(ClassB.class.getClassLoader(), "modify"));
        ClassB.doWithA();
    }
}