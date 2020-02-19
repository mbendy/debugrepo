package debug;

public class Dice {
	
	public static int[] rollDie(int numDie) {
		int [] dice = new int[numDie];
		
		for (int i = 0; i < numDie; i++) {
			dice[i] = (int)(Math.random() * 7);
			System.out.print(dice[i] + " ");

		}
		return dice;
	}
	
	public static int sumRoll(int[] dice) {
		int sum = 0; 
		for(int i = 0; i < dice.length; i++) {
			sum += dice[i];
		}
		return sum; 
	}
	
	public static boolean checkYahtzee(int [] dice) {
		boolean yahtzee = true; 
		for(int j = 1; j < dice.length; j++) {
            if(dice[0] != dice[j]) {
                yahtzee = false; 
                break; 
            }
        }
		return yahtzee; 
	}

    public static void main(String[] args) {
        int numDice = 4;
        int numRolls = 7;

        int[][] allDice = new int[numRolls][numDice];
        int[] frequency = new int[numDice * 6  + 1];

        int yahtzee = 0;
        for(int i = 0; i < numRolls; i++) {
            System.out.print("Roll: ");
            allDice[i] = rollDie(numDice);
            int sum = sumRoll(allDice[i]);
            System.out.println(" Sum: " + sum);
            frequency[sum]++;
            if (checkYahtzee(allDice[i])) {
            	yahtzee++; 
            }
        }
        
        System.out.println("There were " + yahtzee + " yahtzees");

        for(int i = 0; i < frequency.length; i++) {
        	if (frequency[i] != 0) {
                System.out.println("Sum: " + i + " times: " + frequency[i]);
        	}
        }
    }

}
