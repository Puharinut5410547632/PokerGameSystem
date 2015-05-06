import java.util.Random;
import java.util.Scanner;

public class Main {

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

		Scanner sc = new Scanner(System.in);
		
		// set initial bluff value and confidence value for AI
		System.out.println("Set bluff value");
		int bluff= sc.nextInt();
		
		// confidence value depends on AI personality and card
		System.out.println("Set confidence value");
		int confidence = sc.nextInt();

		// -------------------------game start-----------------------------//
		System.out.println("Number of turns of test case");
		int j = sc.nextInt();
		// j = number of turns of test case
		
		int fold = 0;
		int check = 0;
		int call = 0;
		int cFold = 0;
		int cCall = 0;
		
		TestBot bot = new TestBot(confidence, bluff);
		
	//	System.out.println("Fold = " + bot.Fold());
	//	System.out.println("Check = " + bot.check());
		
		//Normal roll
		for (int i = 0; i < j; i++) {

			int x = randInt(0, 100);
			if (x < bot.Fold()) {
				fold++;
			} else if (bot.Fold() <= x && x <= bot.check()) {
				check++;
			} else {
				call++;
			}
		}
		
		//Check roll
		
		for(int i = 0; i < check; i++)
		{
			int x = randInt(0, 100);
			if( x <= bot.cFold()){
				cFold++;
			}
			else cCall++;
		}
		System.out.println("fold = "+fold);
		System.out.println("raise/call = "+call);
		System.out.println("cCall = "+ cCall);
		System.out.println("CFold = " + cFold);

	}

}
