package com.wind.s06;

import java.util.ArrayList;

public class Student {
		private String name;
		private int age;
		private double height;
		private double weight;
		private ArrayList<String> hobbies;

		public Student(String name, int age, ArrayList<String> hobbies) {
			this.name = name;
			this.age = age;
			this.hobbies = hobbies;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public ArrayList<String> getHobbies() {
			return hobbies;
		}

		public void setHobbies(ArrayList<String> hobbies) {
			this.hobbies = hobbies;
		}

		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

}
