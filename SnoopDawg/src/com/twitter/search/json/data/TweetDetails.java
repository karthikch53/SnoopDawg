package com.twitter.search.json.data;

public class TweetDetails 
{
	private String createdAt;
    private String fromUser;
    private long fromUserId;
    private long fromUserIdStr;
    private String fromUserName;
    private String geo;
    private String location;
	private long id;
    private long idStr;
    private String isoLanguageCode;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String source;
    private String text;
    private String toUser;
    private String toUserId;
    private String toUserIdStr;
    private String toUserName;
    
    public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
    
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public long getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}
	public long getFromUserIdStr() {
		return fromUserIdStr;
	}
	public void setFromUserIdStr(long fromUserIdStr) {
		this.fromUserIdStr = fromUserIdStr;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getGeo() {
		return geo;
	}
	public void setGeo(String geo) {
		this.geo = geo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdStr() {
		return idStr;
	}
	public void setIdStr(long idStr) {
		this.idStr = idStr;
	}
	public String getIsoLanguageCode() {
		return isoLanguageCode;
	}
	public void setIsoLanguageCode(String isoLanguageCode) {
		this.isoLanguageCode = isoLanguageCode;
	}
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	public String getProfileImageUrlHttps() {
		return profileImageUrlHttps;
	}
	public void setProfileImageUrlHttps(String profileImageUrlHttps) {
		this.profileImageUrlHttps = profileImageUrlHttps;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public String getToUserIdStr() {
		return toUserIdStr;
	}
	public void setToUserIdStr(String toUserIdStr) {
		this.toUserIdStr = toUserIdStr;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
}
