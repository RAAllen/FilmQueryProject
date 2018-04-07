package com.skilldistillery.iomanager.common;

import java.util.*;

public class SystemIOManager implements IOManager {
  private Scanner sc;
  
  
  
  public SystemIOManager() {
	super();
	init();
}

@Override
  public void init() {
    // Create the Scanner
    sc = new Scanner(System.in);
  }
  
  @Override
  public void destroy() {
    sc.close();
  }
  
  @Override
  public void print(Drawable d) {
    d.draw();
  }
  
  @Override
  public void print(List<Drawable> menuItems) {
    for (Drawable d : menuItems) {
      d.draw();
    }
  }

  public Scanner getSc() {
	return sc;
}

@Override
  public String getUserInput(Drawable d) {
    d.draw();
    return sc.nextLine().trim();  // Removes newline character
  }

@Override
public void getUserInput(String string) {
	// TODO Auto-generated method stub
	
}
}
