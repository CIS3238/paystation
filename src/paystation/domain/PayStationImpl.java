package paystation.domain;
/**
 * Implementation of the pay station.
 *
 * Responsibilities:
 *
 * 1) Accept payment; 
 * 2) Calculate parking time based on payment; 
 * 3) Know earning, parking time bought; 
 * 4) Issue receipts; 
 * 5) Handle buy and cancel events.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class PayStationImpl implements PayStation {
    
    private int insertedSoFar;
    private int timeBought;
    
    //Coinmap is an object containing the number of each coin inserted prior to a cancel or buy call
    private final CoinMap map = new CoinMap();
    
    /*
    State here is initialized to one of the two possible states, WeekdayState or WeekendState 
    (WeekdayState in this case). This is to demonstrate the functionality of the State design pattern 
    used in the Alternating Rate Strategy. It could just as easily have been WeekendState, this was
    arbitrary. 
    */
    private final State state = new WeekdayState();
    
    /*This line assigns a rateStrategy to the paystation. With Linear and Progressive strategies, 
    the paystation need only be initialized with the appropriate strategy. With the Alternating 
    strategy, there must exist methods accessed during runtime (in the main method) in order to alternate between strategies.
    This is effectively a State design pattern encapsulated within a Strategy design pattern.
    */
    RateStrategy rateStrategy = new RateStrategy(new AlternatingRateStrategy());

    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {
        switch (coinValue) {
            case 5: break;
            case 10: break;
            case 25: break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }
        insertedSoFar += coinValue;
        
        //This line is called each time a rateStrategy algorithm is needed to calculate time
        timeBought = rateStrategy.calculateTime(insertedSoFar);
        map.addCoin(coinValue);
        
    }

    @Override
    public int readDisplay() {
        return timeBought;
    }

    @Override
    public Receipt buy() {
        Receipt r = new ReceiptImpl(timeBought);
        map.clear();
        reset();
        return r;
    }

    @Override
    public CoinMap cancel() {
        CoinMap receiptMap = new CoinMap();
        receiptMap.initialize(map);
        
        map.clear();
        reset();
        return receiptMap;
        
    }
    
    private void reset() {
        timeBought = insertedSoFar = 0;
    }
    
    @Override
    public int empty() {
        int temp = insertedSoFar;
        timeBought = insertedSoFar = 0;
        return temp;
    }
    
    @Override
    public CoinMap getCoinMap() {
        return map;
    }
}
