
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
		return confidence;
	}
	
	
	
}
