
public class StockHolding {
	
	String symbol;
	int shares;
	double intPrice;
	double currentPrice;
	
	public StockHolding(String ticker, int numberShares, double initialPrice){
		symbol = ticker;
		shares = numberShares;
		intPrice = initialPrice;
		currentPrice = initialPrice;
		
		
	}
	
	String getTicker(){
		return symbol;
	}
	int getShares(){
		return shares;
	}
	double getInitialSharePrice(){
		return intPrice;
	}
	double getCurrentSharePrice(){
		return currentPrice;
	}
	double getInitialCost(){
		// number of shares * initial price
		return shares * intPrice;
	}
	double getCurrentValue(){
		// number of shares * current price
		return shares * currentPrice;
	}
	double getCurrentProfit(){
		// number of shares * (current price - initial price)
		return shares * (currentPrice - intPrice);
	}
	public String toString(){
		// returns "stock <ticker>, <number of shares> shares bought at <initial price>, current price <current price>
		String line = "Stock " + symbol + " shares: " + shares + " perShare: " + intPrice;
		System.out.println(line);
		return line;
	}
	
	void setCurrentSharePrice(double sharePrice){
		currentPrice = sharePrice;
	}
	
	

}

