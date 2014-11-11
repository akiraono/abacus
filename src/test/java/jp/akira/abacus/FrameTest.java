package jp.akira.abacus;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.io.*;

public class FrameTest {
    // private final ByteArrayOutputStream out = ByteArrayOutputStream();
    // @Before public void before(){
    // 	System.setOut(out);
    // }
    // @After public void after(){
    // 	System.setOut(null);
    // }
    
    @Test public void setTest() {
    	Frame frame = new Frame(10);
    	for(int x=0;x<101;x++){
    	    int expected = x;
    	    frame.set(x);
    	    int actual = frame.value();
    	    //System.out.println("expected = " + expected + " actual = " + actual);
    	    assertThat(actual, is(expected));
    	}
    }

    @Test public void addTest() {
    	Frame frame = new Frame(10);
    	for(int x=0;x<10;x++){
	    for(int y=0;y<10;y++){
		frame.set(x);
		frame.add(y);
		int expected = x + y;
		int actual = frame.value();
		//System.out.println("" + x + " + " + y + " = " + expected + " actual = " + actual);
		assertThat(actual, is(expected));
	    }
    	}
    }
    
    @Test public void parse_reedTest(){
    	try{
    	    Frame frame = new Frame(10);
    	    Class[] args = {int.class, int.class};
    	    Method method = frame.getClass().getDeclaredMethod("parse_reed", args);
    	    method.setAccessible(true);
    	    int x = 1234567890;
    	    int[] expected = new int[]{0,9,8,7,6,5,4,3,2,1};
    	    int[] actual = (int[])method.invoke(frame, x, 10);
    	    assertThat(actual, is(expected));
    	}catch(NoSuchMethodException e){
    	    e.printStackTrace();
    	}catch(IllegalAccessException e){
    	    e.printStackTrace();
    	}catch(InvocationTargetException e){
    	    e.printStackTrace();
    	}
    }

    @Test public void max_reedTest(){
	try{
	    Frame frame = new Frame(10);
	    Class[] args = {int.class};
	    Method method = frame.getClass().getDeclaredMethod("max_reed", args);
	    method.setAccessible(true);
	    int x = 12345678;
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