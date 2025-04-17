package Rounds;
import java.util.*;
public class CodeGuesser {
		public static void main(String[] args) throws InterruptedException {
			Scanner scan = new Scanner(System.in); // USER INPUT
			Random rand = new Random();

			int winz = 0;
			int lost = 0;

			System.out.println("==== CODE GAME ====");
			System.out.println();

			for (int roundz = 1; roundz <= 3; roundz++) { // LOOP
				System.out.println("Round: " + roundz);

				System.out.println("Pick level:");
				System.out.println("1. Easy");
				System.out.println("2. Medium");
				System.out.println("3. Hard");
				int diff = scan.nextInt(); // USER INPUT
				int len = 3;
				if (diff == 2) { // IF STATEMENT
					len = 4;
				}
				if (diff == 3) { // IF STATEMENT
					len = 5;
				}

				String thecode = "";
				for (int i = 0; i < len; i++) {
					thecode += rand.nextInt(10);
				}

				int tries = 5;
				int time = 120;
				ArrayList<String> myguesses = new ArrayList<>(); // LIST
				long start = System.currentTimeMillis();

				boolean didwin = false;

				while (tries > 0) { // LOOP
					long now = System.currentTimeMillis();
					time = 120 - (int)((now - start) / 1000);
					if (time <= 0) { // IF STATEMENT
						System.out.println("You ran out of time...");
						break;
					}

					System.out.println("Tries left: " + tries);
					System.out.println("Time left: " + time + " seconds");
					System.out.println("Enter guess (" + len + " numbers):");
					String guess = scan.next(); // USER INPUT

					if (guess.length() != len) { // IF STATEMENT
						System.out.println("wrong length\n");
						continue;
					}

					myguesses.add(guess); // LIST

					printFeedback(guess, thecode); // METHOD CALL

					if (guess.equals(thecode)) { // IF STATEMENT
						System.out.println("you got it!");
						String[] stuff = {"cash", "car", "cookie", "gold bar", "ip address", "secret file"};
						String prize = stuff[rand.nextInt(stuff.length)];
						System.out.println("You got: " + prize);
						didwin = true;
						break;
					}

					tries--;
				}

				if (didwin) { // IF STATEMENT
					winz++;
				} else {
					lost++;
					System.out.println("the code was: " + thecode);
				}

				System.out.println("you tried: " + myguesses);
				System.out.println();
			}

			System.out.println("=== Results ===");
			System.out.println("Wins: " + winz);
			System.out.println("Loss: " + lost);
		}

		public static void printFeedback(String guess, String code) { // METHOD WITH PARAMETER
			int correctDigits = 0;
			int correctPositions = 0;
			int len = code.length();

			for (int i = 0; i < len; i++) { // LOOP
				if (code.contains(guess.charAt(i) + "")) { // IF STATEMENT
					correctDigits++;
				}
				if (code.charAt(i) == guess.charAt(i)) { // IF STATEMENT
					correctPositions++;
				}
			}

			System.out.println("match: " + correctDigits);
			System.out.println("in place: " + correctPositions);
			System.out.println();
		}
	}