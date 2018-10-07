package paystation.domain;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class PayStationMain{


    public static void main(String args[]) throws IllegalCoinException {
        int choice=0,coinValue;
        Scanner s=new Scanner(System.in);
        PayStationImpl payStation = new PayStationImpl();

        System.out.println("Welcome! Please enter a number for which choice you want");
        while(choice>=1 && choice<=5) {
            System.out.println("1. Deposit Coins\n" +
                    "2. Display Time Bought\n" +
                    "3. Buy Ticket\n" +
                    "4. Cancel Purchase\n" +
                    "5. Change Rate Strategy");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter a coin value of 5, 10, or 25 to enter into the machine");
                    coinValue = s.nextInt();
                    payStation.addPayment(coinValue);
                    break;

                case 2:
                    System.out.println(payStation.readDisplay());
                    break;

                case 3:
                    payStation.buy();
                    break;

                case 4:
                    payStation.cancel();
                    break;

                case 5:
                    System.out.println("What strategy do you want to use?\n" +
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
                            if (currentDay == weekend) {
                                payStation.rateStrategy = new RateStrategy(new AlternatingRateStrategy(new WeekendState()));
                            } else {
                                payStation.rateStrategy = new RateStrategy(new AlternatingRateStrategy(new WeekdayState()));
                            }

                            break;
                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }
        }

    }
}
