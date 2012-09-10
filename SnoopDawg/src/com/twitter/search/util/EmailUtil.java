package com.twitter.search.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.twitter.search.json.data.TweetDetails;

public class EmailUtil 
{
	
	static StringBuffer sb = new StringBuffer();
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	
	public static String prepareMailContent(List<TweetDetails> list) {
		
		Date date = new Date();
		sb.append("<p><b>Date : </b>" + formatter.format(date) + "</p>");
		sb.append("<table border='1' cellspacing='1' cellpadding='5' width='90%' style='font-family: arial; font-size: 12px'>");
		sb.append("<tr>");
			sb.append("<th>");
				sb.append("User Name");
				sb.append("</th>");
				
				sb.append("<th>");
				sb.append("Tweet");
				sb.append("</th>");
				
				sb.append("<th>");
				sb.append("To User");
				sb.append("</th>");
				
				sb.append("<th>");
				sb.append("Location");
				sb.append("</th>");
			sb.append("</tr>");
			
			if(null!=list && list.size()>0)
			{
				for(TweetDetails td:list)
				{
					sb.append("<tr>");
					sb.append("<td>");
						sb.append(td.getFromUser());
					sb.append("</td>");
					sb.append("<td>");
						sb.append(td.getText());
					sb.append("</td>");
					sb.append("<td>");
						sb.append(td.getToUser());
					sb.append("</td>");
					sb.append("<td>");
						sb.append(td.getLocation());
					sb.append("</td>");
				sb.append("</tr>");
				}
			}
			else
			{
				sb.append("<tr>");
				sb.append("<td>");
				sb.append("No Data Found");
				sb.append("</td>");
				sb.append("</tr>");
			}
		
			
		sb.append("</table>");
		
		return sb.toString();
	}
}
