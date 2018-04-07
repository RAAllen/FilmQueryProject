package com.skilldistillery.iomanager.common;

public class TextWithNewLine extends Text {

	public TextWithNewLine(String myText) {
		super(myText);
		
	}

	@Override
	public void draw() {
		super.draw();
		System.out.println();
	}

}
