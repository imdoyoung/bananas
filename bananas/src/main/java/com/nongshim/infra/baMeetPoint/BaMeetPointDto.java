package com.nongshim.infra.baMeetPoint;

public class BaMeetPointDto {
	
	// ===== field ===== //
	private String bameSeq;
	private String bameStationName;
	private Double bameLatitude;
	private Double bameLongitudel;
	private String bameLine;
	private Integer bameUseNy;
	private Integer bameDelNy;
	private Double distance;
	private Double midpointLatitude;
	private Double midpointLongitude;
	

	
	// ===== getter/setter ===== //
	
	public String getBameSeq() {
		return bameSeq;
	}
	public void setBameSeq(String bameSeq) {
		this.bameSeq = bameSeq;
	}
	public String getBameStationName() {
		return bameStationName;
	}
	public void setBameStationName(String bameStationName) {
		this.bameStationName = bameStationName;
	}
	public Double getBameLatitude() {
		return bameLatitude;
	}
	public void setBameLatitude(Double bameLatitude) {
		this.bameLatitude = bameLatitude;
	}
	public Double getBameLongitudel() {
		return bameLongitudel;
	}
	public void setBameLongitudel(Double bameLongitudel) {
		this.bameLongitudel = bameLongitudel;
	}
	public String getBameLine() {
		return bameLine;
	}
	public void setBameLine(String bameLine) {
		this.bameLine = bameLine;
	}
	public Integer getBameUseNy() {
		return bameUseNy;
	}
	public void setBameUseNy(Integer bameUseNy) {
		this.bameUseNy = bameUseNy;
	}
	public Integer getBameDelNy() {
		return bameDelNy;
	}
	public void setBameDelNy(Integer bameDelNy) {
		this.bameDelNy = bameDelNy;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getMidpointLatitude() {
		return midpointLatitude;
	}
	public void setMidpointLatitude(Double midpointLatitude) {
		this.midpointLatitude = midpointLatitude;
	}
	public Double getMidpointLongitude() {
		return midpointLongitude;
	}
	public void setMidpointLongitude(Double midpointLongitude) {
		this.midpointLongitude = midpointLongitude;
	}
	

}
