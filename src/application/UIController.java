package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import application.API;

public class UIController extends Thread{
	
	@FXML
	private Label bitcoin;
	@FXML
	private Label ethereum;
	@FXML
	private Label binance;

	@FXML
	public void run()
    {
        try {
            // Displaying the thread that is running
            
        	System.out.println(
                "Thread " + Thread.currentThread().getId()
                + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
	
	@FXML 
	public void mouseevent() {
		float[] btcdata;
		API btcins = new API();
		btcdata = btcins.coin("btc");
		
		bitcoin.setText("Price in USD :$" + btcdata[0] + "\n24h Volume Change : " + btcdata[1]);
	
		btcdata = btcins.coin("eth");
		ethereum.setText("Price in USD :$" + btcdata[0] + "\n24h Volume Change : " + btcdata[1]);
		
		btcdata = btcins.coin("bnb");
		binance.setText("Price in USD :$" + btcdata[0] + "\n24h Volume Change : " + btcdata[1]);
		
		btcdata = null; btcins = null;
		
	}
	
	@FXML
	private void initialize() {
		UIController btcobj = new UIController();
		btcobj.start();
		float[] btcdata;
		API btcins = new API();
		//Bitcoin
		btcdata = btcins.coin("btc");
		bitcoin.setText("Price in USD :$" + btcdata[0] + "\n24h Volume Change : " + btcdata[1]);
		//Ethereum
		btcdata = btcins.coin("eth");
		ethereum.setText("Price in USD :$" + btcdata[0] + "\n24h Volume Change : " + btcdata[1]);
		//Binance
		btcdata = btcins.coin("bnb");
		binance.setText("Price in USD :$" + btcdata[0] + "\n24h Volume Change : " + btcdata[1]);
		
		btcdata = null; btcins = null;
		
    }
}
