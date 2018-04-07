package com.skilldistillery.iomanager.common;

public class Text implements Drawable {
	private String myText; 
	
	@Override
	public void draw() {
		System.out.print(myText);
	}
	
	public Text(String myText) {
		super(); 
		this.myText = myText;
	}

}
