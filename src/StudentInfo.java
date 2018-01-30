import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInfo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		String ask;
		do {
			int userNum = 0;

			do {
				System.out.println("Which student would you like to learn more about? Enter 1, 2, 3 or 4");
				try {
					userNum = input.nextInt();
					if (!(userNum > 0 && userNum < 5)) {
						System.out.println("That student does not exist. Let's try again.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Must enter an integer. Let's try again.");
					input.next();
				}
			} while (!(userNum > 0 && userNum < 5));

			String[] names = { "Annie", "Barb", "Cassie", "Denise" };
			String[] hometowns = { "Ann Arbor", "Bay Harbor", "Canton", "Detroit" };
			String[] foods = { "apple sauce", "bacon", "charcuterie", "dark chocolate" };

			System.out.printf("Student %d is %s.", userNum, names[userNum - 1]);

			String inquiry = "";
			do {
				System.out.printf(" What would you like to know about %s? (Enter \"hometown\" or \"favorite food\"): ",
						names[userNum - 1]);
				try {
					input.nextLine();
					inquiry = input.nextLine();
					if (!(inquiry.equalsIgnoreCase("hometown") || inquiry.equalsIgnoreCase("favorite food"))) {
						System.out.println("That data does not exist.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Must enter \"hometown or \"favorite food \"");

				}
			} while (!(inquiry.equalsIgnoreCase("hometown") || inquiry.equalsIgnoreCase("favorite food")));

			if (inquiry.equalsIgnoreCase("hometown")) {
				System.out.printf("%s is from %s.", names[userNum - 1], hometowns[userNum - 1]);
			}

			if (inquiry.equalsIgnoreCase("favorite food")) {
				System.out.printf("%s's favorite food is %s.", names[userNum - 1], foods[userNum - 1]);
			}
			System.out.println();
			System.out.println("Would you like to know more? Enter y or n: ");
			ask = input.next();

		} while (ask.equalsIgnoreCase("y"));
		System.out.println("Bye!");
	}

}
