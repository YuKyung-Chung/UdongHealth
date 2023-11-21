package com.ssafy.udong.model.dto;

public class Hashtag {
	private int hashtagId;
	private String hashtag;
	
	public Hashtag() {}
	
	public Hashtag(int hashtagId, String hashtag) {
		this.hashtagId = hashtagId;
		this.hashtag = hashtag;
	}

	public int getHashtagId() {
		return hashtagId;
	}

	public void setHashtagId(int hashtagId) {
		this.hashtagId = hashtagId;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	@Override
	public String toString() {
		return "Hashtag [hashtagId=" + hashtagId + ", hashtag=" + hashtag + "]";
	}
	
	
	
	
}
