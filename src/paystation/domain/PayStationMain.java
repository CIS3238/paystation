package paystation.domain;
import java.util.Scanner;
public class PayStationMain{


    public static void main(String args[]) throws IllegalCoinException {
        int choice=0,coinValue=0;
        Scanner s=new Scanner(System.in);
        PayStationImpl payStation = new PayStationImpl();

        choice = 1;
        
        System.out.println("Welcome!");
        while(choice>=1 && choice<=5) {
            System.out.println("\nPlease enter a number for which choice you want.\n"
                +   "1. Deposit Coins\n" +
                    "2. Display Time Bought\n" +
                    "3. Buy Ticket\n" +
                    "4. Cancel Purchase\n" +
                    "5. Change Rate Strategy");
            choice = s.nextInt();
            switch (choice) {
                case 1:   
                    do {
                        System.out.println("\nEnter a coin value of 5, 10, or 25 to enter into the machine.\n"
                            + "When you're finished, enter 0.");
                        coinValue = s.nextInt();
                        
                        if (coinValue == 0) {
                            System.out.println("\n" + payStation.readDisplay() 
                                + " minutes added in total.");
                            break;
                        }
                        
                        payStation.addPayment(coinValue);
                        System.out.println("\n" + payStation.readDisplay() 
                                + " minutes added so far.");
                    } while(coinValue != 0);
                    break;

                case 2:
                    System.out.println("\nYou've added " + payStation.readDisplay()
                    + " minutes so far.");
                    break;

                case 3:
                    Receipt r = payStation.buy();
                    System.out.println("\nYou bought " + r.value()
                    + " minutes. Have a great day!");
                    break;

                case 4:
                    CoinMap cancel = payStation.cancel();
                    System.out.println("\nPayment cancelled. Returning " + cancel.quarters 
                            + " quarters, " + cancel.dimes + " dimes, and " 
                            + cancel.nickles + " nickles.");
                    break;

                case 5:
                    System.out.println("\nWhat strategy do you want to use?\n\n" +
                            "1. Linear\n" +
                            "2. Progressive\n" +
                            "3. Alternating");
                    choice=s.nextInt();
                    switch (choice) {
                        case 1:
                            payStation.rateStrategy = new RateStrategy(new LinearRateStrategy());
                            break;
                        case 2:
                            payStation.rateStrategy = new RateStrategy(new ProgressiveRateStrategy());
                            break;
                        case 3:
                            payStation.rateStrategy = new RateStrategy(new AlternatingRateStrategy());
                            break;
                        default:
                            break;
                    }
                    System.out.println("\nStrategy changed.");
                    break;

                default:
                    break;
            }
        }

    }
}
