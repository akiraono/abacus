package jp.akira.abacus;
import org.kohsuke.args4j.*;
import org.apache.logging.log4j.*;

public class AbacusCalculator {
    @Option(name="--debug")
	private boolean debug = false;

    Logger LOG = LogManager.getLogger(AbacusCalculator.class);
    
    public static void main(String[] args){
	AbacusCalculator app = new AbacusCalculator();
	CmdLineParser parser = new CmdLineParser(app);
	try{
	    parser.parseArgument(args);
	}catch(CmdLineException e){
	    e.printStackTrace();
	}
	app.processMain();
    }
    private void processMain(){
	LOG.info("Abacus Calculator " + debug);
	int[] t = new int[]{1,2,3};
	for(int i=0;i<t.length;i++){
	    System.out.println(t[i]);
	}
	Frame frame = new Frame(10);
	int x = 28;
	int y = 25;
	frame.set(x);
	frame.add(y);
	LOG.info("" + x + " + " + y + " = " + frame.value());
	x = 54;
	y = 18;
	frame.set(x);
	frame.subtract(y);
	LOG.info("" + x + " - " + y + " = " + frame.value());
    }
}

