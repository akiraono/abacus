package jp.akira.abacus;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class BeadTest {
    @Test
    public void onTest() {
	boolean expected = true;
	Bead bead = new Bead();
	bead.on();
        boolean actual = bead.isOn();
	assertThat(actual, is(expected));
    }
    @Test
    public void offTest() {
	boolean expected = true;
	Bead bead = new Bead();
	bead.off();
        boolean actual = bead.isOff();
	assertThat(actual, is(expected));
    }
    @Test
    public void value0() {
	int expected = 0;
	Bead bead = new Bead(expected);
	bead.off();
	int actual = bead.value();
	assertThat(actual, is(expected));
    }
    @Test
    public void value1() {
	int expected = 1;
	Bead bead = new Bead(expected);
	bead.on();
	int actual = bead.value();
	assertThat(actual, is(expected));
    }
    @Test
    public void value5() {
	int expected = 5;
	Bead bead = new Bead(expected);
	bead.on();
	int actual = bead.value();
	assertThat(actual, is(expected));
    }
}

