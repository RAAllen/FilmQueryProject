package com.skilldistillery.iomanager.common;

import java.util.List;

public interface IOManager {
  void init();
  void destroy();
  void print(Drawable d);
  void print(List<Drawable> items);  // So we can display
                                     // any menu
  String getUserInput(Drawable prompt);

	void getUserInput(String string);
}
