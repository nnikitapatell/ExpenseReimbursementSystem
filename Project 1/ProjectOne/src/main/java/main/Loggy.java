package main;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Loggy {
	final static Logger loggy = Logger.getLogger(MainDriver.class);
	
	public static void info(String message) {
		loggy.setLevel(Level.ERROR);
		loggy.info(message);

	}
	public static void error(Exception e) {
		loggy.setLevel(Level.ALL);
		loggy.error(e);
	}
}
