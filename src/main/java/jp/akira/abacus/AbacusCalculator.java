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
	Frame frame = new Frame(10);
	int x = 12;
	int y = 21;
	frame.set(x);
	frame.add(y);
	LOG.info("" + x + " + " + y + " = " + frame.value());
    }
}
// pull from github
