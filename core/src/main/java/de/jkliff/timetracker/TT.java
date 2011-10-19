package de.jkliff.timetracker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(
				new String[] { "classpath:context.xml" });
	}

}
