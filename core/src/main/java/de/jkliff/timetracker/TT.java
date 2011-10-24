package de.jkliff.timetracker;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.grizzly.http.embed.GrizzlyWebServer;
import com.sun.grizzly.http.servlet.ServletAdapter;
import com.sun.jersey.spi.container.servlet.ServletContainer;

import de.jkliff.timetracker.config.InvalidConfigurationException;
import de.jkliff.timetracker.config.TimeTrackerConfiguration;
import de.jkliff.timetracker.util.ApplicationContextSingleton;

public class TT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(
				new String[] { "classpath:context.xml" });

		ApplicationContextSingleton.initialize (springContext);
		
		TimeTrackerConfiguration conf;
		try {
			conf = TimeTrackerConfiguration.from("tt.conf");
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Trying with default configuration...");

			conf = TimeTrackerConfiguration.defaultFallbackConfiguration();
		}

		GrizzlyWebServer webServer = new GrizzlyWebServer(conf.getBindPort());

		ServletAdapter jerseyAdapter = new ServletAdapter();
		jerseyAdapter.addInitParameter(
				"com.sun.jersey.config.property.packages",
				"de.jkliff.timetracker.rest.resource");
		jerseyAdapter.setContextPath("/");
		jerseyAdapter.setServletInstance(new ServletContainer());

		webServer.addGrizzlyAdapter(jerseyAdapter, new String[] { "/" });

		try {
			System.out.println("starting server...");
			webServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
