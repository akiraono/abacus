package jp.akira.abacus;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;

public class FrameTest {
    // @Test
    // public void setTest() {
    // 	Frame frame = new Frame(10);
    // 	for(int x=0;x<200;x++){
    // 	    int expected = x;
    // 	    frame.set(x);
    // 	    int actual = frame.value();
    // 	    System.out.println("expected = " + expected + " actual = " + actual);
    // 	    assertThat(actual, is(expected));
    // 	}
    // }

    @Test
    public void max_reedTest(){
	try{
	    Frame frame = new Frame(10);
	    Class[] args = {double.class};
	    Method method = frame.getClass().getDeclaredMethod("max_reed", args);
	    method.setAccessible(true);
	    double x = 12345678.0;
	    int expected = 8;
	    Integer actual = (Integer)method.invoke(frame, x);
	    assertThat((int)actual, is(expected));
	}catch(NoSuchMethodException e){
	    e.printStackTrace();
	}catch(IllegalAccessException e){
	    e.printStackTrace();
	}catch(InvocationTargetException e){
	    e.printStackTrace();
	}
    }
}