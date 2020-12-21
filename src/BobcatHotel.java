import java.util.Scanner;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Random;
public class BobcatHotel {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		System.out.println("1. Single: $50.50 per night");
		System.out.println("2. Double: $75.00 per night");
		System.out.println("3. Queen: $100.75 per night");
		System.out.println("4. King: $150.25 per night");
		System.out.println("5. Master Suite: $225.50 per night");
		double single = 50.50;
		double two = 75.00;
		double queen = 100.75;
		double king = 150.20;
		double master = 225.50;
		int guest;
		double choice;
		double nights;
		int aaa; // for AAA member holds yes or no
		int club; // club member
		double meal; // meal package
		double com = 0; // complementary
		double stan = 30.00; // standard
		double del = 50.00; // deluxe
		double ind = 85; // only available to guests who reserve the Master Suite
		double baseRoomCost;
		double mealCost;
		double prelimTotal; // Preliminary total cost
		int newNight; // discount for club member
		double clubNight = 0;
		double aaaDis = 0;
		double totalCost;
		double clubMemDis = 0;
		int carry = 0;
		boolean a = false; 
		
		
		
		
		System.out.println("Please specify the number of guests: ");
		guest = input.nextInt();
		System.out.println("Please select your room choice (enter 1/2/3/4/5 corresponding to the options shown\r\n" + 
				"above):");
		choice = input.nextDouble();
		System.out.println("Please enter the number of nights:");
		nights = input.nextInt();
		System.out.println("Are you a AAA member (enter 1 for yes, 0 for no)?");
		aaa = input.nextInt();
		System.out.println("Are you a club member (enter 1 for yes, 0 for no)?");
		club = input.nextInt();
		
		
		
	
		
		//Room cost
		
				if(choice == 1) { 
					choice = single;
				}
				if(choice == 2) {
					choice = two;
				}
				if(choice == 3) {
					choice = queen;
				}
				if(choice == 4) {
					choice = king;
				}
				if(choice == 5) {
					choice = master;
				}
				baseRoomCost = choice * nights;
				
		
		
		
		//Club Member Discount
		if(club == 1) {
		int number = random.nextInt(11);
		if(number >= 4) {
			newNight = (int) (nights / 4);
			clubMemDis = (choice * (nights+newNight)) - (choice * nights);
			System.out.println("Congratulations! You've qualified for our \"Stay 4 nights get 1 free promotion");
			System.out.println("Discount will be applied during checkout depending on the number of days");
			carry = number;
		}
		else {
			a = false;
			System.out.println("Unfortunately, you didn't qualify for our \"Stay 4 nights get 1 free promotion\".");
			System.out.println("Better luck next time!");
		}
		}
		
		
		
		
		System.out.println("MEAL PACKAGES (PRICES SHOWN ARE PER GUEST PER NIGHT)");
		System.out.println("0. Complementary @ $0 per guest");
		System.out.println("1. Standard @ $30 per guest");
		System.out.println("2. Deluxe @ $50 per guest");
		if(choice == master) {
			System.out.println("3. Indulgence @ $85 per guest");
		}
		
		if((0 <= choice) && (choice <= 2)) {
			System.out.println("Please select your desired meal package (enter 0/1/2 corresponding to the options  shown above): ");
		}
		else {
			System.out.println("Please select your desired meal package (enter 0/1/2/3 corresponding to the options  shown above): ");
		}
		meal = input.nextDouble();
		
		
		
		
		//Meal cost
				if(meal == 0) {
					meal = com;
				}
				if(meal == 1) {
					meal = stan;
				}
				if(meal == 2) {
					meal = del;
				}
				if(meal == 3 && choice == master) {
					meal = ind;
				}
				mealCost = meal * guest * nights;
				
		
				
		//AAA Discount (Switch Statement)
		switch(aaa) {
		case 1:
			aaaDis = (baseRoomCost + mealCost) * 0.10;
		}
		
		 
		
		//Preliminary total cost
		prelimTotal = baseRoomCost + mealCost;
		
		
		
		
		//Total cost
		totalCost = prelimTotal - clubMemDis - aaaDis;
	
		
		
		//boolean part
		if(aaa == 0) {
			a  = false; 
		}
		if(aaa == 1) {
			a = true;
		}
		
		
		
		
		//Decimal transformation
		DecimalFormat df = new DecimalFormat("###.##");
		
		
		//final print
		System.out.println("CHECKOUT");
		System.out.println("Room Cost:" + "\t" + "\t" +"\t$" + df.format(baseRoomCost));
		
		if(meal >= 1) {
		System.out.println("Meal Cost:" + "\t" + "\t" + "\t+$" + mealCost);
		}
		
		System.out.println("Preliminary Total Cost:" + "\t" + "\t" + "$" + df.format(prelimTotal));
		if(aaa == 1) {
			System.out.println("AAA Discount:" + "\t" + "\t" +"\t-$" + aaaDis);
		}
		if(club == 1 && carry >= 4) {
			System.out.println("Club Member Discount:" + "\t" + "\t" +"-$" + clubMemDis);
		}
		
		if((a == false) && (club == 0)) {
			System.out.println("No Discount Applied");
		}
		System.out.println("Total Cost of Booking:" + "\t" + "\t" + df.format(totalCost));
		
		
	 
		
		
		
		
		
		
		
		
		
		
	}
}
