package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class API {
	static String URLtemp = "https://data.messari.io/api/v1/assets/%s/metrics";
	
	public static float[] coin(String coin) {
		float[] coinarr;
		coinarr = new float[20];
			try {
					
					String URLt = String.format(URLtemp, coin);
					
		            URL url = new URL(URLt);
		            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		            conn.setRequestMethod("GET");
		            conn.setRequestProperty("Accept", "application/json");
		            if (conn.getResponseCode() != 200) {
		                throw new RuntimeException("Failed : HTTP Error code : "
		                        + conn.getResponseCode());
		            }
		            InputStreamReader in = new InputStreamReader(conn.getInputStream());
		            BufferedReader br = new BufferedReader(in);
		            String output = br.readLine();
		   
		            JSONObject data = new JSONObject(output);  
		            System.out.println(data);
		            JSONObject jdata = data.getJSONObject("data");  
		            JSONObject status = jdata.getJSONObject("market_data");  
		            Float priceusd = status.getFloat("price_usd");  
		            coinarr[0] = priceusd;
		            //System.out.println("this is the price of Coin: " + priceusd);
		            
		            Float volume24 = status.getFloat("volume_last_24_hours");  
		            coinarr[1] = volume24;
		            //System.out.println("Volume 24h of BTC: " + volume24);  
		            
		            conn.disconnect();
		            return coinarr;

		        } catch (Exception e) {
		            System.out.println("Exception in NetClientGet:- " + e);
		        }
		    return coinarr;
		
	
	}
	
}
