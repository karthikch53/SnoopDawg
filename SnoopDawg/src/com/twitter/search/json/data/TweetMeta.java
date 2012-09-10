package com.twitter.search.json.data;

import java.util.List;

public class TweetMeta {
	private double completed_in;
	private long max_id;
    private long max_id_str;
    private String next_page;
    private int page;
    private String query;
    private String refresh_url;
    private List<TweetDetails> tweets;
    
	public double getCompleted_in() {
		return completed_in;
	}
	public void setCompleted_in(double completed_in) {
		this.completed_in = completed_in;
	}
	public long getMax_id() {
		return max_id;
	}
	public void setMax_id(long max_id) {
		this.max_id = max_id;
	}
	public long getMax_id_str() {
		return max_id_str;
	}
	public void setMax_id_str(long max_id_str) {
		this.max_id_str = max_id_str;
	}
	public String getNext_page() {
		return next_page;
	}
	public void setNext_page(String next_page) {
		this.next_page = next_page;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getRefresh_url() {
		return refresh_url;
	}
	public void setRefresh_url(String refresh_url) {
		this.refresh_url = refresh_url;
	}
	public List<TweetDetails> getTweets() {
		return tweets;
	}
	public void setTweets(List<TweetDetails> tweets) {
		this.tweets = tweets;
	}
}
