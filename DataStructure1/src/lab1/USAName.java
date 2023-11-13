package lab1;

import java.util.Iterator;

public class USAName implements Comparable<USAName> {
	private String name;
	private char gender;
	private int freq;



	public USAName(String name, char gender, int freq) {
		this.name = name;
		this.gender = gender;
		this.freq = freq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	@Override
	public int compareTo(USAName o) {
		if (o.name == this.name) {
			return 0;
		} else
			return -1;
	}

	public String toString(){
		return "Name: " + name + " Gender: " + gender + " freq: " + freq;
	}
}
