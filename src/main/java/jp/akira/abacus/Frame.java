package jp.akira.abacus;

public class Frame {
    private int rod_width = 1;
    private Rod[]  rods;
    
    public Frame(int rod_width){
	this.rod_width = rod_width;
	rods = new Rod[rod_width];
	for(int i=0;i<rod_width;i++){
	    rods[i] = new Rod();
	}
    }


    public void set(int x){
	int[] reed = parse_reed(x,rod_width);
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
	int[] reed = parse_reed(x,rod_width);
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
	//if(x == 0) x = 1;
	while(x>=1){
	    x /= 10;
	    //System.out.println(x);
	    reed++;
	}
	//	double log10 = Math.log10(d);
	//	int result = (int)Math.ceil(log10);
	//System.out.println("max_reed input :" + input + " result:" + reed);
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