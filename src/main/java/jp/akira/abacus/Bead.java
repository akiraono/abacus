package jp.akira.abacus;
import org.apache.logging.log4j.*;

public class Bead {
    private static final Logger LOG = LogManager.getLogger(Bead.class);
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
	LOG.trace("unit = " + unit);
	this.unit = unit;
    }

    /**
     * change status, this bead becomes active
     * @param none
     * @return void
     * @throws none
     */
    public void on(){
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

    /**
     * check status of bead is active
     * @param none
     * @return boolean
     */
    public boolean isOn(){
	if(status){
	    return true;
	}
	return false;
    }

    /**
     * check status of bead is inactive
     * @param none
     * @return boolean
     */
    public boolean isOff(){
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
