package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AverageDTO {
	
	private int totalG;
	
	private int totalMG;
	
	private float avgG;
	
	private float avgMG;

	private float avgG11;
	
	private float avgMG11;
	
	private float avgG12;
	
	private float avgMG12;

	private float avgG21;
	
	private float avgMG21;

	public int getTotalG() {
		return totalG;
	}

	public void setTotalG(int totalG) {
		this.totalG = totalG;
	}

	public int getTotalMG() {
		return totalMG;
	}

	public void setTotalMG(int totalMG) {
		this.totalMG = totalMG;
	}

	public float getAvgG() {
		return avgG;
	}

	public void setAvgG(float avgG) {
		this.avgG = avgG;
	}

	public float getAvgMG() {
		return avgMG;
	}

	public void setAvgMG(float avgMG) {
		this.avgMG = avgMG;
	}

	public float getAvgG11() {
		return avgG11;
	}

	public void setAvgG11(float avgG11) {
		this.avgG11 = avgG11;
	}

	public float getAvgMG11() {
		return avgMG11;
	}

	public void setAvgMG11(float avgMG11) {
		this.avgMG11 = avgMG11;
	}

	public float getAvgG12() {
		return avgG12;
	}

	public void setAvgG12(float avgG12) {
		this.avgG12 = avgG12;
	}

	public float getAvgMG12() {
		return avgMG12;
	}

	public void setAvgMG12(float avgMG12) {
		this.avgMG12 = avgMG12;
	}

	public float getAvgG21() {
		return avgG21;
	}

	public void setAvgG21(float avgG21) {
		this.avgG21 = avgG21;
	}

	public float getAvgMG21() {
		return avgMG21;
	}

	public void setAvgMG21(float avgMG21) {
		this.avgMG21 = avgMG21;
	}

	@Override
	public String toString() {
		return "AverageDTO [totalG=" + totalG + ", totalMG=" + totalMG + ", avgG=" + avgG + ", avgMG=" + avgMG
				+ ", avgG11=" + avgG11 + ", avgMG11=" + avgMG11 + ", avgG12=" + avgG12 + ", avgMG12=" + avgMG12
				+ ", avgG21=" + avgG21 + ", avgMG21=" + avgMG21 + "]";
	}

	
	
}