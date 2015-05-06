import java.util.Random;
import java.util.Scanner;


public class Main2 {

	/**
	 * @param args
	 */
	
	public static int randInt(int min, int max) {

		// Usually this can be a field rather than a method variable
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		// set initial bluff value and confidence value for AI
		//System.out.println("Set bluff value");
		//int bluff= sc.nextInt();
		
		// confidence value depends on AI personality and card
		//System.out.println("Set confidence value");
		//int confidence = sc.nextInt();

		// -------------------------game start-----------------------------//
		
		
		System.out.println("Minimum Confidence");
		int a = sc.nextInt();
		System.out.println("Maximun Confidence");
		int b = sc.nextInt();
		System.out.println("Number of turns of test case");
		int j = sc.nextInt();
		// j = number of turns of test case
		
		int clow = 0;
		int cmid = 0;
		int chigh = 0;
		int callin = 0;
		
		for(int i = 0; i < j; i++)
		{
			//random confidence between 0 to 6
			double confi = randInt(a, b);
			//roll x
			double x = randInt(0, 102);
			
			TestBot bot = new TestBot(confi, 0);
			if(bot.raiseResult(x).equals("Raise Low")){
				clow++;
			}
			if(bot.raiseResult(x).equals("Raise Mid")){
				cmid++;
			}
			if(bot.raiseResult(x).equals("Raise High")){
				chigh++;
			}
			if(bot.raiseResult(x).equals("All in")){
				callin++;
			}
			
		}
		System.out.println("Raise Low "+clow);
		System.out.println("Raise Mid "+cmid);
		System.out.println("Raise High "+chigh);
		System.out.println("All in "+callin);
		
	}

}
