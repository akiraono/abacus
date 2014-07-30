package jp.akira.abacus;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.*;

public class RodTest {
    @Test
    public void setTest(){
	Rod rod = new Rod();
	for(int expected = 1;expected<10;expected++){
	    rod.set(expected);
	    int actual = rod.value();
	    assertThat(actual, is(expected));
	}
    }
    @Test
    public void addTest(){
	Rod rod = new Rod();
	for(int x = 1; x<10; x++){
	    for(int y = 1; y<10; y++){
		int expected = x + y;
		if(expected > 9) break;
		rod.set(x);
		rod.add(y);
		int actual = rod.value();
		assertThat(actual, is(expected));
	    }
	}
    }
    
    @Test
    public void defaultvalue() {
	int expected = 0;
	Rod rod = new Rod();
        int actual = rod.value();
	assertThat(actual, is(expected));
    }
    
    @Test
    public void clearTest() {
	try{
	    int expected = 0;
	    Rod rod = new Rod();
	    rod.add(3);
	    Method method = rod.getClass().getDeclaredMethod("clear");
	    method.setAccessible(true);
	    method.invoke(rod,null); //same as rod.clear();
	    int actual = rod.value();
	    assertThat(actual, is(expected));
	}catch(NoSuchMethodException e){
	    e.printStackTrace();
	}catch(IllegalAccessException e){
	    e.printStackTrace();
	}catch(InvocationTargetException e){
	    e.printStackTrace();
	}
    }
    @Test
    public void addOneTest() {
	try {
	    Rod rod = new Rod();
	    Method method = rod.getClass().getDeclaredMethod("addOne");
	    method.setAccessible(true);
	    for(int expected = 1; expected <10; expected++){
		method.invoke(rod, null);
		int actual = rod.value();
		assertThat(actual, is(expected));
	    }
	}catch(NoSuchMethodException e){
	    e.printStackTrace();
	}catch(IllegalAccessException e){
	    e.printStackTrace();
	}catch(InvocationTargetException e){
	    e.printStackTrace();
	}    
    }
}
