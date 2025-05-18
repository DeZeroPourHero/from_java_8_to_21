package org.tks.java;

public class Student {
	private String name;
	private int age;
	private double average;

	public Student(String name, int age, double average) {
		this.name = name;
		this.age = age;
		this.average = average;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getAverage() {
		return average;
	}
}
