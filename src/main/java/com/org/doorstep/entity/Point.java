/**
 * 
 */
package com.org.doorstep.entity;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

/**
 * @author hariharank12
 *
 */
@Embeddable
public class Point {

	private BigDecimal latitude;

	private BigDecimal longitude;

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "co-ordinates " + getLatitude() + " - " + getLongitude();

	}

}
