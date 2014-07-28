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
    
    public void set(int x){
	clear();
	add(x);
    }
    public void add(int x){
	while(x > 0){
	    addOne();
	    x--;
	}
    }
    
    
    public int value(){
	int value = bead1.value() +
	    bead2.value() +
	    bead3.value() +
	    bead4.value() +
	    bead5.value();
	return value;
    }
    private void addOne(){
	if(bead1.isOff()){
	    bead1.on();
	    return;
	}else if(bead2.isOff()){
	    bead2.on();
	    return;
	}else if(bead3.isOff()){
	    bead3.on();
	    return;
	}else if(bead4.isOff()){
	    bead4.on();
	    return;
	}else if(bead5.isOff()){
	    bead5.on();
	    bead4.off();
	    bead3.off();
	    bead2.off();
	    bead1.off();
	}
    }
    private void clear(){
	bead5.off();
	bead4.off();
	bead3.off();
	bead2.off();
	bead1.off();
    }
}