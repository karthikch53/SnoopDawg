package com.twitter.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.twitter.search.json.data.TweetDetails;
import com.twitter.search.util.Emailer;

public class SearchTwitter 
{
	String twitterUrl = "http://search.twitter.com/search.json";
	String nextUrl = "";
	private final static Logger LOGGER = Logger.getLogger("SearchTwitter");
	
	public void searchTwitter(String query)
	{
		InputStream inputStream = null;
		BufferedReader br = null;
		TweetDetails data = null;
		boolean hasNext = false;
		String tempUrl = "";
		JSONArray results = null;
		JSONParser jp = null;
		List<TweetDetails> dataList = new ArrayList<TweetDetails>();
		String str = null;
		try
		{
			do
			{
				StringBuilder sb = new StringBuilder();
				if(!hasNext)
				{
					tempUrl = "http://search.twitter.com/search.json?geocode=21.1438,79.0926,1000mi&q=" + query;
				}
				else
				{
					tempUrl = "http://search.twitter.com/search.json" + nextUrl;
				}
				URL url = new URL(tempUrl);
				URLConnection conn = url.openConnection();
				inputStream = conn.getInputStream();
				br = new BufferedReader(new InputStreamReader(inputStream));
				while ((str = br.readLine()) != null) 
				{
					sb.append(str);
				}
				jp = new JSONParser();
				JSONObject obj = (JSONObject)jp.parse(sb.toString());
				if(null!= obj.get("next_page") && !obj.get("next_page").toString().equals(""))
				{
					hasNext = true;
					nextUrl = obj.get("next_page").toString();
					System.out.println(nextUrl);
					LOGGER.log(Level.INFO, "URL-"+nextUrl);
				}
				else
				{
					nextUrl = null;
				}
				results = (JSONArray) obj.get("results");
				Iterator<JSONObject> iterator = results.iterator();
				while (iterator.hasNext()) 
				{
					data = new TweetDetails();
					JSONObject obj1 = (JSONObject)iterator.next();
					data.setFromUser("@"+obj1.get("from_user").toString());
					if(null!=obj1.get("location"))
					{
						data.setLocation(obj1.get("location").toString());
					}
					else
					{
						data.setLocation("Nil");
					}
					if(null!= obj1.get("to_user"))
					{
						data.setToUser("@"+obj1.get("to_user").toString());
					}
					else
					{
						data.setToUser("Nil");
					}
					data.setText(obj1.get("text").toString());
					data.setCreatedAt(obj1.get("created_at").toString());
					dataList.add(data);
				}
			}
			while((nextUrl!=null && !nextUrl.equals("")) & results != null);
			generateExcelAndSendMail(dataList);
		}
		catch (MalformedURLException e) 
		{
			LOGGER.log(Level.SEVERE, "Malformed URL-"+ e.getMessage());
		} 
		catch (IOException e) 
		{
			LOGGER.log(Level.SEVERE, "IOException -"+ e.getMessage());
		} 
		catch (ParseException e) 
		{
			LOGGER.log(Level.SEVERE, "ParseException -"+ e.getMessage());
		}
		
	}
	
	private void generateExcelAndSendMail(List<TweetDetails> dataList)
	{
		Emailer.sendEmail(dataList);
	}
	
	public static void main(String[] args) 
	{
		
		SearchTwitter st = new SearchTwitter();
		st.searchTwitter("ebay");
	}

}
