package jp.akira.abacus;

public class Rod {
    private Bead bead1 = new Bead(1);
    private Bead bead2 = new Bead(1);
    private Bead bead3 = new Bead(1);
    private Bead bead4 = new Bead(1);
    private Bead bead5 = new Bead(5);
    
    public Rod(){
	clear();
    }

    /**
     * @param int
     * @return void
     */
    public void set(int x){
	clear();
	add(x);
    }

    /**
     * @param int
     * @return int carry over data
     * @throws none
     */
    public int add(int x){
	int carry = 0;
	while(x > 0){
	    carry += addOne();
	    x--;
	}
	return carry;
    }
    
    /**
     * calculate current value
     * @param none
     * @return int
     * @throws none
     */
    public int value(){
	int value = bead1.value() +
	    bead2.value() +
	    bead3.value() +
	    bead4.value() +
	    bead5.value();
	return value;
    }

    /**
     * @params none
     * @return int : carry over
     */
    private int addOne(){
	if(bead1.isOff()){
	    bead1.on();
	    return 0;
	}else if(bead2.isOff()){
	    bead2.on();
	    return 0;
	}else if(bead3.isOff()){
	    bead3.on();
	    return 0;
	}else if(bead4.isOff()){
	    bead4.on();
	    return 0;
	}else if(bead5.isOff()){
	    bead5.on();
	    bead4.off();
	    bead3.off();
	    bead2.off();
	    bead1.off();
	    return 0;
	}
	bead5.off();
	bead4.off();
	bead3.off();
	bead2.off();
	bead1.off();
	return 1;
    }

    /**
     * @param none
     * @return int
     */
    private int subtractOne(){
	if(bead4.isOn()){
	    bead4.off();
	    return 0;
	}else if(bead3.isOn()){
	    bead3.off();
	    return 0;
	}else if(bead2.isOn()){
	    bead2.off();
	    return 0;
	}else if(bead1.isOn()){
	    bead1.off();
	    return 0;
	}else if(bead5.isOn()){
	    bead5.off();
	    bead1.on();
	    bead2.on();
	    bead3.on();
	    bead4.on();
	    return 0;
	}
	bead5.on();
	bead1.on();
	bead2.on();
	bead3.on();
	bead4.on();
	return 1; //borrow from upper rod
    }

    /**
     * reset all value
     * @params none
     * @return void
     */
    private void clear(){
	bead5.off();
	bead4.off();
	bead3.off();
	bead2.off();
	bead1.off();
    }
}
