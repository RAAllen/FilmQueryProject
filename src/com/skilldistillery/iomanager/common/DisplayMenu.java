package com.skilldistillery.iomanager.common;

public class DisplayMenu implements Drawable {
	
	@Override
	public void draw() {
		System.out.println(" ✩  What would you like to do?  ✩");
		System.out.println(" 1. Look up a film by id");
		System.out.println(" 2. Look up a film by a keyword");
		System.out.println(" 3. Exit the program");
	}
}
