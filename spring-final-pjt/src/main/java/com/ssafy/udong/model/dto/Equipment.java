package com.ssafy.udong.model.dto;

public class Equipment {
	private String eqName; //운동기구명
	private String eqPart; //운동부위
	private String eqImg;  //운동기구사진
	
	//기본생성자
	public Equipment() {}
	
	public Equipment(String eqName, String eqPart, String eqImg) {
		this.eqName = eqName;
		this.eqPart = eqPart;
		this.eqImg = eqImg;
	}

	public String getEqName() {
		return eqName;
	}

	public void setEqName(String eqName) {
		this.eqName = eqName;
	}

	public String getEqPart() {
		return eqPart;
	}

	public void setEqPart(String eqPart) {
		this.eqPart = eqPart;
	}

	public String getEqImg() {
		return eqImg;
	}

	public void setEqImg(String eqImg) {
		this.eqImg = eqImg;
	}

	@Override
	public String toString() {
		return "Equipment [eqName=" + eqName + ", eqPart=" + eqPart + ", eqImg=" + eqImg + "]";
	}
	
	
	
}
