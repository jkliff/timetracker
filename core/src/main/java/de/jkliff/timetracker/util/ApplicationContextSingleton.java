package de.jkliff.timetracker.util;

import org.springframework.context.ApplicationContext;

public class ApplicationContextSingleton {

    private static ApplicationContext applicationContext;

    private ApplicationContextSingleton() {

    }

    public static void initialize (ApplicationContext springContext) {
        applicationContext = springContext;

    }

    public static ApplicationContext getApplicationContext () {
        return applicationContext;
    }

}
