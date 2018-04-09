# Film Query Project

### A program to cross reference films.

#### By _**Rebecca Allen**_

## Setup/Installation requirements

* In order to utilize this project you will need a terminal application such as Terminal or Bash, and a text editor application such as Atom or Eclipse, and a database server program such as MAMP or LAMP.
* Start by opening the terminal application and typing the command
```
git clone https://github.com/RAAllen/FilmQueryProject.git
```
after navigating with the `cd` command to the location you would like the project to be cloned into.
* Use the terminal application to navigate to the project directory you just cloned down off of GitHub using the "cd" command.
* In order to run this program, type
```
java FilmQueryProject
```
while in the project directory.
* If that does not work, check to make sure a compiled version of the project is in the directory by typing `ls`. You should see a FilmQueryProject.class file.
* If no FilmQueryProject.class file exists, create one by compiling the program with the command
```
javac FilmQueryProject.java
```
Then try running it again.
* To edit this program, after navigating into the project directory type the following commands:
```
atom .
```
If you are using Atom. This should open the project in your editor.
* If you are using Eclipse, type
```
open /Applications/eclipse.app
```
in your terminal. This will open the Eclipse editor. You must then open the specific project from within the Eclipse file interface. Depending on your version and display options this is done by going to the "File" tab at the top of the application. After clicking "File" a drop down menu should appear, select "Open Projects From File System" from the drop down menu, then select the location you cloned the project as the file to open. Leave "Search for nested projects" and "Detect and configure project natures" selected, select whichever working set you would like the project to be in located in. Select "Finish" at the bottom right hand corner and the project should be imported in.
* If at any point during this next part of the set up process you get a popup system window to enter a password, it is asking for your computer user account password. Start by opening up your MAMP or LAMP. From the preferences menu of the application, select "Ports" and "Set Web and MySQL ports to 80 & 3306". Select to "Start Servers" from the main window of your application. Return to your terminal, you will need to set up the included sdvid.sql database in order to run this program. Your terminal should still be in the FilmQueryProject. You will be typing a series of commands in the terminal.
```
mysql -u root -p < sdvid.sql
mysql -u root -p
```
You will then be prompted to enter a password in the terminal, type `root`.
```
mysql> CREATE USER student@localhost IDENTIFIED BY 'student';
mysql> GRANT SELECT,INSERT,UPDATE,DELETE on sdvid.* TO student@localhost;
mysql> exit;
```

## Program Specifications

* The user will be greeted by a menu with three options: to look up a film by its id, to look up a film with a keyword or to exit the program.

* If the user chooses to exit, they will be told "Goodbye" and the program will exit.

* If the user chooses to look up the film by id, they will be given a prompt to enter an id. If the film is found by its id it will be displayed, if it is not found they will be told it was not found.

* If the user chooses to look up the film by keyword, they will be given a prompt to enter a keyword. If the film is found by the keyword, it will be displayed, if it is not found they will be told it was not found.


## Support and Contact Details

_Please contact RebeccaZarsky@gmail.com for technical questions or assistance running the program._

## Technologies Used

_This program was made utilizing Java, SQL, MySql, Maven, Atom and the Eclipse Integrated Development Environment._

## License

_This program is licensed under the MIT license._

Copyright (c) 2018 **_Rebecca Allen_**
