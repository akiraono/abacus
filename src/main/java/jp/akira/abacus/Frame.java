package jp.akira.abacus;

public class Frame {
    private Rod rod = new Rod();
    public Frame(){
	System.out.println("Frame is created");
    }


    public void set(int x){
	rod.set(x);
    }
    public void add(int x){
	rod.add(x);
    }
    public int value(){
	return rod.value();
    }
}