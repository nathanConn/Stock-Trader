import java.util.ArrayList;

public class PortfolioList {
	
	private ArrayList<StockHolding> stocks;
	
	public PortfolioList(){
		stocks = new ArrayList<StockHolding>();
	}
	
	public boolean add(StockHolding stk){
		stocks.add(stk);
		return true;
	}

	public int shareFinder(String sym){
		int shrs = 0;
		for(int i = 0; i< stocks.size(); i++){
			if (stocks.get(i).getTicker().equals(sym))
				shrs = stocks.get(i).getShares();
		}
		return shrs;
	}
	
	public boolean remover(String sym){
		for(int i = 0; i< stocks.size(); i++){
			if (stocks.get(i).getTicker().equals(sym))
				stocks.remove(i);
		}
		return true;
	}
	
	public double currentVal(String sym){
		double cv = 0.0;
		for(int i = 0; i< stocks.size(); i++){
			if (stocks.get(i).getTicker().equals(sym))
			cv = stocks.get(i).getCurrentValue();	
		}
		return cv;
	}
	
	public double totalPortfolioValue(){
		double tv = 0.0;
		for(int i = 0; i< stocks.size(); i++){
			tv += stocks.get(i).getCurrentValue();
		}
		return tv;
	}
	
	public int size(){
		return stocks.size();
	}
	
	@Override
	public String toString(){
		String str = "";
		for(int i = 0; i < stocks.size(); i++){
			str += stocks.get(i).toString() + "\n";	
		}
		return str;
		
		
	}
}



