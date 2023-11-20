package com.ssafy.udong.model.dto;

public class Equipment {
	private int eqId;
	private String eqPart; //운동 부위 분류
	private String eqDiv; //운동 부위 분류 상세
	private String eqName; //운동기구 명
	
	//기본생성자
	public Equipment() {}

	public Equipment(int eqId, String eqPart, String eqDiv, String eqName) {
		super();
		this.eqId = eqId;
		this.eqPart = eqPart;
		this.eqDiv = eqDiv;
		this.eqName = eqName;
	}

	public int getEqId() {
		return eqId;
	}

	public void setEqId(int eqId) {
		this.eqId = eqId;
	}

	public String getEqPart() {
		return eqPart;
	}

	public void setEqPart(String eqPart) {
		this.eqPart = eqPart;
	}

	public String getEqDiv() {
		return eqDiv;
	}

	public void setEqDiv(String eqDiv) {
		this.eqDiv = eqDiv;
	}

	public String getEqName() {
		return eqName;
	}

	public void setEqName(String eqName) {
		this.eqName = eqName;
	}

	@Override
	public String toString() {
		return "Equipment [eqId=" + eqId + ", eqPart=" + eqPart + ", eqDiv=" + eqDiv + ", eqName=" + eqName + "]";
	}
	
	
	
	
	
	
}
