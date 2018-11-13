import java.awt.event.ActionEvent;
import java.util.Scanner;

import javax.swing.*;

public class Trader {

	private JLabel cash;
	private JLabel csh;
	
	private JButton sell;
	
	private JButton buy;
	
	private JTextField stock;
	private JTextField shares;
	private JTextField perShare;
	private JTextArea portfolio;
	private JLabel pnlText;
	private JLabel pnl;
	private JLabel totalPValueText;
	private JLabel totalPValue;

	private PortfolioList porty = new PortfolioList();
	
	
	public Trader(){
		WidgetView wv = new WidgetView();
		
		stock = new JTextField("Stock");
		shares = new JTextField("Shares");
		perShare = new JTextField("perShare");
		
		TradeEvent eventHandler = new TradeEvent();

		csh = new JLabel("Cash: $");
		cash = new JLabel("1000.00");
		
		sell = new JButton("Sell");
		sell.addActionListener(eventHandler);

		buy = new JButton("Buy");
		buy.addActionListener(eventHandler);

		
		portfolio = new JTextArea();
		
		pnlText = new JLabel("Profit / Loss: $");
		pnl = new JLabel("");
		
		totalPValueText = new JLabel("          Total Portfolio Value: $");
		totalPValue = new JLabel("");
		
		wv.add(stock);
		wv.add(shares);
		wv.add(perShare);
		wv.add(csh);
		wv.add(cash);
		wv.add(sell);
		wv.add(buy);
		wv.add(portfolio);
		wv.add(pnlText);
		wv.add(pnl);
		wv.add(totalPValueText);
		wv.add(totalPValue);
		
		
	}
	
	class TradeEvent extends WidgetViewActionEvent {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jc = (JButton) e.getSource();
			String st = stock.getText();
			stock.setText("Stock");
			int sh = 0;
			double ps = Double.parseDouble(perShare.getText());
			perShare.setText("perShare");
			double currentCash = Double.parseDouble(cash.getText());
			double profitLoss = 0.0;
			double portfolioValue = 0.0;

			
			
			
			
			
			if (jc.getText() == "Buy" && currentCash >= (Integer.parseInt(shares.getText())*ps)){
				sh = Integer.parseInt(shares.getText());
				StockHolding stockS = new StockHolding(st, sh, ps);
				shares.setText("Shares");
				porty.add(stockS);
				currentCash -= (sh*ps);
				cash.setText(String.valueOf(currentCash));
				portfolio.setText(porty.toString());
				portfolioValue = porty.totalPortfolioValue();
				totalPValue.setText(String.valueOf(portfolioValue));
			}else if (jc.getText() == "Buy" && currentCash < (Integer.parseInt(shares.getText())*ps)){
				shares.setText("Shares");
				portfolio.setText(porty.toString());
				portfolioValue = (porty.totalPortfolioValue());
				totalPValue.setText(String.valueOf(portfolioValue));
			}else if (jc.getText() == "Sell"){
				int sellShares = porty.shareFinder(st);
				profitLoss += ((sellShares * ps) - porty.currentVal(st));
				porty.remover(st);
				currentCash += (sellShares * ps);
				cash.setText(String.valueOf(currentCash));
				pnl.setText(String.valueOf(profitLoss));
				portfolio.setText(porty.toString());
				portfolioValue = (porty.totalPortfolioValue());
				totalPValue.setText(String.valueOf(portfolioValue));
					
			}
			
		}
		}




}
