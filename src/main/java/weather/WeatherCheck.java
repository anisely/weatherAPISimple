package weather;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherCheck
{
	//public static void main(String [] args)
	public static void allCities()
	{
		String inline = "";
	
		try
		{
			URL url = new URL("http://api.openweathermap.org/data/2.5/group?id=6695624,7531002,3094802,3081368,7530858,3093133&units=metric&APPID=YOURAPIKEYHERE");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);
			
			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					inline+=sc.nextLine();
				}
				System.out.println(inline);
				sc.close();
			}
			conn.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
