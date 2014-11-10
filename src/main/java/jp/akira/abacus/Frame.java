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


    public void set(int x){
	int[] reed = parse_reed(x,frame_width);
	//print_array(reed);
	// if(reed.length > rods.length){
	//     System.err.println("too large for this frame");
	//     System.exit(-1);
	// }
	for(int i=0;i<reed.length;i++){
	    rods[rods.length - reed.length + i].set(reed[i]);
	}
	//for(int i=0;i<rods.length;i++){
	//    System.out.println("rods[" + i + "]:" + rods[i].value());
	//}
    }
    
    public void add(int x){
	int[] reed = parse_reed(x,frame_width);
	//int reed.length = reed.length;
	int rod_iterator = rods.length - 1;
	// if(reed.length >= rods.length){
	//     System.err.println("too large for this frame");
	//     System.exit(-1);
	// }
	int carry = 0;
	for(int i=(reed.length - 1); i>=0; i--){
	    carry = rods[rod_iterator].add(reed[i] + carry);
	    rod_iterator--;
	}
    }

    /**
     * calculate value of this frame
     * @parma none
     * @return int
     */
    public int value(){
	int result = 0;
	for(int i=0;i<rods.length;i++){
	    result += rods[i].value();
	    //System.out.println("value result=" + result);
	    if(i < (rods.length - 1)){
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
	int[] result = new int[width];
	for(int i=0;i<width;i++){
	    int remainder = x % 10;
	    //System.out.println("remainder:" + remainder);
	    result[width - i - 1] = remainder;
	    x /= 10;
	}
	//System.out.print("parse_reed:");
	//print_array(result);
	return result;
    }
    
    private int max_reed(int input){
	int reed = 0;
	int x = input;
	while(x>=1){
	    x /= 10;
	    reed++;
	}
	LOG.debug("input:" + input + " max_reed:" + reed);
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