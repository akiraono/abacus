package jp.akira.abacus;

public class AbacusCalculator {
    public static void main(String[] args){
	AbacusCalculator app = new AbacusCalculator();
	app.processMain();
    }
    private void processMain(){
	System.out.println("Abacus Calculator");
	Frame frame = new Frame();
	frame.set(1);
	frame.add(2);
	System.out.println("1 + 2 = " + frame.value());
    }
}
