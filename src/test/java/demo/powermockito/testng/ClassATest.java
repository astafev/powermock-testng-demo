package demo.powermockito.testng;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.testng.Assert.*;


@PrepareForTest(ClassB.class)
public class ClassATest extends PowerMockTestCase {
    @Test
    public void testA() {
        assertEquals(ClassA.getA(), "A");
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public  void testExcOnDoWith4() {
        mockStatic(ClassB.class);
        when(ClassB.get4()).thenReturn(3);

        ClassA.doWith4();
    }
}