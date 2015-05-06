
public class TestBot {

	private double confidence;
	private double bluff;
	private static final double CC = 100;
	
	public TestBot(double confidence, double bluff) {
		this.confidence = confidence;
		this.bluff = bluff;
	}

	public double Fold(){
		double fold = 20 - confidence*10 - bluff*5;
		if (fold <0) fold = 0;
		if (fold > 60) fold = 60;
		return fold;
	}
	
	public double raisecall(){
		double call = 40 + confidence/5*CC;
		if (call > CC*0.8) call = CC*0.8; 
		if (call < 0) call = 20;
		return call;
				
	}
	
	public double check(){
		double check = CC-raisecall();
		return check;
	}
	
	public double cFold(){
		double fold = 50 - confidence*10 - bluff *5;
		if (fold > 80) fold = 80;
		return fold;
	}
	
	public double cCall() {
		
		double call = 100 - cFold();
		return call;
		
	}
	
	public double bluffCheck()
	{
		return 20+(bluff*5)+(bluffFail*10);
	}
	
	public double raiseLow(){
		
		double low = 100 - confidence *15;
		if(low<45){
			low = 45;
		}//Min 45
		return low;
	}
	public double raiseMid(){
		double mid = 100 - raiseLow() - confidence*10;
		if(mid<35){
			mid = 35;
		}
		return mid;
	}
	public double raiseHigh(){
		double high = 100 - raiseLow() - raiseMid();
		return high;
	}
	public String raiseResult(double x){

		double maxlow = raiseLow();
		double maxmid = raiseLow() + raiseMid();
		double maxhigh = raiseLow() + raiseMid() + raiseHigh();
		if(x<maxlow){
			return "Raise Low";
		}
		else if(x<maxmid){
			return "Raise Mid";
		}
		else if(x<maxhigh){
			return "Raise High";
		}
		else
			return "All in";
		
		
	}
	
}
