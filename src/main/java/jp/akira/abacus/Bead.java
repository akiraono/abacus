package jp.akira.abacus;
import org.apache.logging.log4j.*;

public class Bead {
    private static final Logger LOG = LogManager.getLogger(jp.akira.abacus.Bead.class.getName());
    private int unit = 1;
    private boolean status = false;

    /**
     * default constructor
     */
    public Bead(){
	this.unit = 1;
    }

    /**
     * construct with a parameter
     * @param value of unit. 1 or 5.
     */
    public Bead(int unit){
	LOG.debug("unit = " + unit);
	this.unit = unit;
    }

    /**
     * change status, this bead becomes active
     * @param none
     * @return void
     * @throws none
     */
    public void on(){
	//LOG.info("status is on");
	status = true;
    }

    /**
     * change status, this bead becomes inactive
     * @param none
     * @return void
     * @throws none
     */
    public void off(){
	status = false;
    }
    
    public boolean isOn(){
	if(status){
	    return true;
	}
	return false;
    }
    public boolean isOff(){
	// if(status){
	//     return false;
	// }
	// return true;
	return !isOn();
    }

    /**
     * value of thie bead for calculation
     * @param none
     * @return int value of this bead. returns 0, 1, or 5.
     * @throws none
     */
    public int value(){
	if(status){
	    return unit;
	}
	return 0;
    }
}
