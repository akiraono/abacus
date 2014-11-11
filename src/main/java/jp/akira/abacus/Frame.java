package jp.akira.abacus;
import org.apache.logging.log4j.*;

public class Frame {
    private static final Logger LOG = LogManager.getLogger(Frame.class);
    private int frame_width = 1;
    private Rod[]  rods;
    
    /**
     *  constructor with parameter
     */
    public Frame(int frame_width){
	this.frame_width = frame_width;
	rods = new Rod[frame_width];
	for(int i=0;i<frame_width;i++){
	    rods[i] = new Rod();
	}
    }

    /**
     * set initial values to all rods
     * @params integer
     * @return void
     */
    public void set(int x){
	int[] reed = parse_reed(x,frame_width);
	for(int i=0;i<reed.length;i++){
	    rods[rods.length - reed.length + i].set(reed[i]);
	}
    }

    /**
     * add calculator method
     * @params integer
     * @return void
     */
    public void add(int x){
	int[] reed = parse_reed(x,frame_width);
	int carry = 0;
	for(int i=0; i<reed.length; i++){
	    carry = rods[i].add(reed[i] + carry);
	}
    }

    public void subtract(int x){
	LOG.trace("input:" + x);
	int[] reed = parse_reed(x,frame_width);
	int carry = 0;
	for(int i=0; i<=(reed.length - 1); i++){
	    carry = rods[i].subtract(reed[i] + carry);
	}
    }

    /**
     * calculate value of this frame
     * @parma none
     * @return int
     */
    public int value(){
	int result = 0;
	for(int i=(rods.length - 1);i>=0;i--){
	    result += rods[i].value();
	    //System.out.println("value result=" + result);
	    if(i > 0){
		result *= 10;
	    }
	}
	return result;
    }

    /**
     * convert int value to array of integer
     * @params int value
     * @params int width
     * @return int[]
     */
    private int[] parse_reed(int x, int width){
	//int reed = max_reed(x);
	//LOG.trace("input:" + x + " reed:" + max_reed(x));
	int[] result = new int[width];
	for(int i=0;i<width;i++){
	    int remainder = x % 10;
	    //System.out.println("remainder:" + remainder);
	    result[i] = remainder;
	    x /= 10;
	}
	//System.out.print("parse_reed:");
	//print_array(result);
	String s = "";
	for(int i=0;i<result.length;i++){
	    s += result[result.length - i - 1];
	}
	LOG.trace("result:" + s);
	return result;
    }

    /**
     * calculate reed of integer
     * @params int value
     * @return int
     */
    private int max_reed(int input){
	int reed = 0;
	int x = input;
	while(x>=1){
	    x /= 10;
	    reed++;
	}
	LOG.trace("input:" + input + " max_reed:" + reed);
	return reed;
    }
    
    private void print_array(int[] data){
	System.err.print("debug : ");
	for(int i=0;i<data.length;i++){
	    System.err.print(data[i]);
	}
	System.err.print("\n");
    }
}