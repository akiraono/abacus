package jp.akira.abacus;

public class AbacusCalculator {
    public static void main(String[] args){
	AbacusCalculator app = new AbacusCalculator();
	app.processMain();
    }
    private void processMain(){
	System.out.println("Abacus Calculator");
	Frame frame = new Frame(10);
	int x = 12;
	int y = 21;
	frame.set(x);
	frame.add(y);
	//System.out.println("" + x + " + " + y + " = " + frame.value());
	System.out.println(frame.value());
    }
}
