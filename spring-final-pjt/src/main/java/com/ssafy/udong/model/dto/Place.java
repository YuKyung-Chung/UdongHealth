package com.ssafy.udong.model.dto;

import java.util.Date;

public class Place {
	private int placeId; 			//공원id
	private String placeName; 		//공원명
	private String addressGu; 		//설치주소(구)
	private String addressDong; 	//설치주소(동)
	private String addressDetail; 	//설치주소(상세)
	private String eqKind; 			//설치운동기구종류
	private String eqBroken; 		//고장운동기구명
	private double latitude; 		//위도
	private double longitude; 		//경도
	private String dept; 			//담당부서명
	private String deptPhone; 		//담당부서 전화번호
	private Date updateDate; 		//데이터기준일자
	
	//기본생성자
	public Place() {}
	
	public Place(String placeName, String addressGu, String addressDong, String addressDetail, String eqKind,
			String eqBroken, double latitude, double longitude, String dept, String deptPhone, Date updateDate) {
		this.placeName = placeName;
		this.addressGu = addressGu;
		this.addressDong = addressDong;
		this.addressDetail = addressDetail;
		this.eqKind = eqKind;
		this.eqBroken = eqBroken;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dept = dept;
		this.deptPhone = deptPhone;
		this.updateDate = updateDate;
	}
	
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getAddressGu() {
		return addressGu;
	}
	public void setAddressGu(String addressGu) {
		this.addressGu = addressGu;
	}
	public String getAddressDong() {
		return addressDong;
	}
	public void setAddressDong(String addressDong) {
		this.addressDong = addressDong;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getEqKind() {
		return eqKind;
	}
	public void setEqKind(String eqKind) {
		this.eqKind = eqKind;
	}
	public String getEqBroken() {
		return eqBroken;
	}
	public void setEqBroken(String eqBroken) {
		this.eqBroken = eqBroken;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDeptPhone() {
		return deptPhone;
	}
	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Place [placeName=" + placeName + ", addressGu=" + addressGu + ", addressDong=" + addressDong
				+ ", addressDetail=" + addressDetail + ", eqKind=" + eqKind + ", eqBroken=" + eqBroken + ", latitude="
				+ latitude + ", longitude=" + longitude + ", dept=" + dept + ", deptPhone=" + deptPhone
				+ ", updateDate=" + updateDate + "]";
	}
	
	
}
