package com.metacube.soap.service;

public class CalculatorService {

	public double getArea(double side1, double side2, double side3){
		double s=(side1+side2+side3)/2;
		double area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	}
}
